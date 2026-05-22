package org.serratec.ONG.Service;

import org.serratec.ONG.DTO.InteresseAdocaoRequestDto;
import org.serratec.ONG.DTO.InteresseAdocaoResponseDto;
import org.serratec.ONG.Domain.Animal;
import org.serratec.ONG.Domain.InteresseAdocao;
import org.serratec.ONG.Domain.Pessoa;
import org.serratec.ONG.Exception.DuplicateEntryException;
import org.serratec.ONG.Exception.ResourceNotFoundException;
import org.serratec.ONG.Repository.AnimalRepository;
import org.serratec.ONG.Repository.InteresseAdocaoRepository;
import org.serratec.ONG.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InteresseAdocaoService {

    @Autowired
    private InteresseAdocaoRepository interesseRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public List<InteresseAdocaoResponseDto> findAll() {
        return interesseRepository.findAll()
                .stream()
                .map(InteresseAdocaoResponseDto::from)
                .collect(Collectors.toList());
    }

    public InteresseAdocaoResponseDto findById(Long id) {
        InteresseAdocao i = interesseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Interesse de adocao", id));
        return InteresseAdocaoResponseDto.from(i);
    }

    public InteresseAdocaoResponseDto salvar(InteresseAdocaoRequestDto dto) {
        Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId())
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa", dto.getPessoaId()));

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new ResourceNotFoundException("Animal", dto.getAnimalId()));

        boolean jaExiste = interesseRepository.existsByPessoaIdAndAnimalId(
                dto.getPessoaId(), dto.getAnimalId());
        if (jaExiste) {
            throw new DuplicateEntryException(
                    "Já existe interesse de adocao registrado para esta pessoa e animal");
        }

        InteresseAdocao interesse = new InteresseAdocao();
        interesse.setPessoa(pessoa);
        interesse.setAnimal(animal);
        interesse.setDataInteresse(dto.getDataInteresse());
        interesse.setDescricao(dto.getDescricao());
        return InteresseAdocaoResponseDto.from(interesseRepository.save(interesse));
    }

    public InteresseAdocaoResponseDto atualizar(Long id, InteresseAdocaoRequestDto dto) {
        InteresseAdocao interesse = interesseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Interesse de adoção", id));
        interesse.setDataInteresse(dto.getDataInteresse());
        interesse.setDescricao(dto.getDescricao());
        return InteresseAdocaoResponseDto.from(interesseRepository.save(interesse));
    }

    public void delete(Long id) {
        if (!interesseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Interesse de adoção", id);
        }
        interesseRepository.deleteById(id);
    }
}
