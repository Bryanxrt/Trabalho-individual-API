package org.serratec.ONG.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class InteresseAdocaoRequestDto {

    @NotNull(message = "O ID da pessoa é obrigatório")
    private Long pessoaId;

    @NotNull(message = "O ID do animal é obrigatório")
    private Long animalId;

    @NotNull(message = "A data do interesse é obrigatória")
    @Past(message = "A data deve estar no passado")
    private LocalDate dataInteresse;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public LocalDate getDataInteresse() {
        return dataInteresse;
    }

    public void setDataInteresse(LocalDate dataInteresse) {
        this.dataInteresse = dataInteresse;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
