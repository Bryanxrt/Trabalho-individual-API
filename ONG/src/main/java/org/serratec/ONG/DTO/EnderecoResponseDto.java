package org.serratec.ONG.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.ONG.Domain.Endereco;

@JsonPropertyOrder({"id", "pessoaId", "logradouro", "complemento", "bairro", "cidade", "uf", "cep"})
@Schema(description = "Dados de um endereço")
public class EnderecoResponseDto {

    @Schema(description = "ID do endereço", example = "1")
    private Long id;

    @Schema(description = "Logradouro", example = "Rua Francisco")
    private String logradouro;

    @Schema(description = "Complemento", example = "N 201")
    private String complemento;

    @Schema(description = "Bairro", example = "Centro")
    private String bairro;

    @Schema(description = "Cidade", example = "Sao Jose")
    private String cidade;

    @Schema(description = "UF", example = "RJ")
    private String uf;

    @Schema(description = "CEP", example = "25780-000")
    private String cep;

    @Schema(description = "ID da pessoa dona do endereço", example = "1")
    private Long pessoaId;

    public static EnderecoResponseDto from(Endereco endereco) {
        EnderecoResponseDto dto = new EnderecoResponseDto();
        dto.id = endereco.getId();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
