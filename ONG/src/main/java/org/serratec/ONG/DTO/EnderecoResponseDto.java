package org.serratec.ONG.DTO;

import org.serratec.ONG.Domain.Endereco;

public class EnderecoResponseDto {

    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private Long pessoaId;

    public static EnderecoResponseDto from(Endereco endereco) {
        EnderecoResponseDto dto = new EnderecoResponseDto();
        dto.logradouro = endereco.getLogradouro();
        dto.complemento = endereco.getComplemento();
        dto.bairro = endereco.getBairro();
        dto.cidade = endereco.getCidade();
        dto.uf = endereco.getUf();
        dto.cep = endereco.getCep();
        dto.pessoaId = endereco.getPessoa().getId();
        if (endereco.getPessoa() != null)
           dto.pessoaId = endereco.getPessoa().getId();
        return dto;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
