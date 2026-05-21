package org.serratec.ONG.DTO;

import org.serratec.ONG.Domain.Pessoa;

public class PessoaResponseDto {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public static PessoaResponseDto from(Pessoa pessoa) {
        PessoaResponseDto dto = new PessoaResponseDto();
        dto.id       = pessoa.getId();
        dto.nome     = pessoa.getNome();
        dto.email    = pessoa.getEmail();
        dto.telefone = pessoa.getTelefone();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
