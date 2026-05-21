package org.serratec.ONG.DTO;

import org.serratec.ONG.Domain.InteresseAdocao;

import java.time.LocalDate;

public class InteresseAdocaoResponseDto {

    private Long id;
    private Long pessoaId;
    private String pessoaNome;
    private Long animalId;
    private String animalNome;
    private LocalDate dataInteresse;
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
