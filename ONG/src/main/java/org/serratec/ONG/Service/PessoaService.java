package org.serratec.ONG.Service;

import org.serratec.ONG.DTO.PessoaRequestDto;
import org.serratec.ONG.DTO.PessoaResponseDto;
import org.serratec.ONG.Domain.Animal;
import org.serratec.ONG.Domain.Pessoa;
import org.serratec.ONG.Exception.DuplicateEntryException;
import org.serratec.ONG.Exception.ResourceNotFoundException;
import org.serratec.ONG.Repository.AnimalRepository;
import org.serratec.ONG.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public List<PessoaResponseDto> findAll() {
        return pessoaRepository.findAll()
                .stream()
                .map(PessoaResponseDto::from)
                .collect(Collectors.toList());
    }

    public PessoaResponseDto findById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa", id));
        return PessoaResponseDto.from(pessoa);
    }

    public PessoaResponseDto salvar(PessoaRequestDto dto) {
        if (pessoaRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateEntryException("Já existe uma pessoa cadastrada com o email: " + dto.getEmail());
        }
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setTelefone(dto.getTelefone());
        return PessoaResponseDto.from(pessoaRepository.save(pessoa));
    }

    public PessoaResponseDto atualizar(Long id, PessoaRequestDto dto) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa", id));
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setTelefone(dto.getTelefone());
        return PessoaResponseDto.from(pessoaRepository.save(pessoa));
    }

    public PessoaResponseDto apadrinharAnimal(Long idPessoa, Long idAnimal) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa", idPessoa));
        Animal animal = animalRepository.findById(idAnimal)
                .orElseThrow(() -> new ResourceNotFoundException("Animal", idAnimal));

        if (pessoa.getAnimaisApadrinhados().contains(animal)) {
            throw new DuplicateEntryException("Pessoa já apadrinha este animal");
        }
        pessoa.getAnimaisApadrinhados().add(animal);
        return PessoaResponseDto.from(pessoaRepository.save(pessoa));
    }
}
