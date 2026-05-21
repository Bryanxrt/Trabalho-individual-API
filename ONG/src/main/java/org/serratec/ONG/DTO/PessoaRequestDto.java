package org.serratec.ONG.DTO;

import jakarta.validation.constraints.*;

public class PessoaRequestDto {

    @NotBlank(message = "O nome deve ser preenchido")
    @Size(min = 2, max = 50, message = "Nome deve ter entre 2 e 50 caracteres")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "O email deve ser preenchido")
    private String email;

    @NotBlank(message = "O telefone deve ser preenchido")
    @Size(min = 11, max = 11, message = "O telefone deve conter 11 digitos")
    private String telefone;

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
