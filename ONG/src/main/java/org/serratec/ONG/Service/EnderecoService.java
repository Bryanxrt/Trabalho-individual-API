package org.serratec.ONG.Service;

import org.serratec.ONG.DTO.EnderecoRequestDto;
import org.serratec.ONG.DTO.EnderecoResponseDto;
import org.serratec.ONG.Domain.Endereco;
import org.serratec.ONG.Domain.Pessoa;
import org.serratec.ONG.Exception.ResourceNotFoundException;
import org.serratec.ONG.Repository.EndereceRepository;
import org.serratec.ONG.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EndereceRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<EnderecoResponseDto> findAll() {
        return enderecoRepository.findAll()
                .stream()
                .map(EnderecoResponseDto::from)
                .collect(Collectors.toList());
    }

    public EnderecoResponseDto findById(Long id) {
        Endereco e = enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço", id));
        return EnderecoResponseDto.from(e);
    }

    public EnderecoResponseDto salvar(EnderecoRequestDto dto) {
        Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId())
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa", dto.getPessoaId()));

        Endereco e = new Endereco();
        e.setPessoa(pessoa);
        e.setLogradouro(dto.getLogradouro());
        e.setComplemento(dto.getComplemento());
        e.setBairro(dto.getBairro());
        e.setCidade(dto.getCidade());
        e.setUf(dto.getUf());
        e.setCep(dto.getCep());
        return EnderecoResponseDto.from(enderecoRepository.save(e));
    }

    public EnderecoResponseDto atualizar(Long id, EnderecoRequestDto dto) {
        Endereco e = enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço", id));
        e.setLogradouro(dto.getLogradouro());
        e.setComplemento(dto.getComplemento());
        e.setBairro(dto.getBairro());
        e.setCidade(dto.getCidade());
        e.setUf(dto.getUf());
        e.setCep(dto.getCep());
        return EnderecoResponseDto.from(enderecoRepository.save(e));
    }

    public void delete(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Endereço", id);
        }
        enderecoRepository.deleteById(id);
    }
}
