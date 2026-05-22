package org.serratec.ONG.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.ONG.Domain.InteresseAdocao;

import java.time.LocalDate;

@JsonPropertyOrder({"id", "pessoaId", "pessoaNome", "animalId", "animalNome", "dataInteresse", "descricao"})
@Schema(description = "Dados retornados de um interesse de adoção")
public class InteresseAdocaoResponseDto {

    @Schema(description = "ID do interesse", example = "1")
    private Long id;

    @Schema(description = "ID da pessoa interessada", example = "1")
    private Long pessoaId;

    @Schema(description = "Nome da pessoa interessada", example = "João Silva")
    private String pessoaNome;

    @Schema(description = "ID do animal", example = "2")
    private Long animalId;

    @Schema(description = "Nome do animal", example = "Rex")
    private String animalNome;

    @Schema(description = "Data do interesse", example = "2025-05-01")
    private LocalDate dataInteresse;

    @Schema(description = "Motivacao do interesse", example = "Tenho espaco e amor para dar")
    private String descricao;

    public static InteresseAdocaoResponseDto from(InteresseAdocao interesseAdocao) {

        InteresseAdocaoResponseDto interesseAdocaoResponseDto = new InteresseAdocaoResponseDto();
        interesseAdocaoResponseDto.id            = interesseAdocao.getId();
        interesseAdocaoResponseDto.dataInteresse = interesseAdocao.getDataInteresse();
        interesseAdocaoResponseDto.descricao     = interesseAdocao.getDescricao();

        if (interesseAdocao.getPessoa() != null) {
            interesseAdocaoResponseDto.pessoaId   = interesseAdocao.getPessoa().getId();
            interesseAdocaoResponseDto.pessoaNome = interesseAdocao.getPessoa().getNome();
        }
        if (interesseAdocao.getAnimal() != null) {
            interesseAdocaoResponseDto.animalId   = interesseAdocao.getAnimal().getId();
            interesseAdocaoResponseDto.animalNome = interesseAdocao.getAnimal().getNome();
        }
        return interesseAdocaoResponseDto;
    }

    public Long getId() {
        return id;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public String getAnimalNome() {
        return animalNome;
    }

    public LocalDate getDataInteresse() {
        return dataInteresse;
    }

    public String getDescricao() {
        return descricao;
    }
}
