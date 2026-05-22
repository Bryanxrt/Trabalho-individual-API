package org.serratec.ONG.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.ONG.Domain.Pessoa;

@JsonPropertyOrder({"id", "nome", "email", "telefone"})
@Schema(description = "Dados retornados de uma pessoa")
public class PessoaResponseDto {

    @Schema(description = "ID da pessoa", example = "1")
    private Long id;

    @Schema(description = "Nome completo", example = "João Silva")
    private String nome;

    @Schema(description = "Email", example = "igor@email.com")
    private String email;

    @Schema(description = "Email", example = "joao@email.com")
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
