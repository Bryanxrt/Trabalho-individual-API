package org.serratec.ONG.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.ONG.Domain.Animal;

import java.time.LocalDate;

@JsonPropertyOrder({"id", "nome", "especie", "raca", "adotado", "dataChegada", "caracterisca"})
@Schema(description = "Dados retornados de um animal")
public class AnimalResponseDto {

    @Schema(description = "ID do animal", example = "1")
    private Long id;

    @Schema(description = "Nome do animal", example = "Rex")
    private String nome;

    @Schema(description = "Espécie", example = "Cachorro")
    private String especie;

    @Schema(description = "Raça", example = "Labrador")
    private String raca;

    @Schema(description = "Se já foi adotado", example = "false")
    private Boolean adotado;

    @Schema(description = "Data de chegada na ONG", example = "2025-01-15")
    private LocalDate dataChegada;

    @Schema(description = "Caracteristicas fisicas do animal")
    private CaracteriscaResponseDto caracterisca;

    public static AnimalResponseDto from(Animal animal) {
        AnimalResponseDto animalResponseDto = new AnimalResponseDto();
        animalResponseDto.id = animal.getId();
        animalResponseDto.nome = animal.getNome();
        animalResponseDto.especie = animal.getEspecie();
        animalResponseDto.raca = animal.getRaca();
        animalResponseDto.dataChegada = animal.getDataChegada();
        animalResponseDto.adotado = animal.getAdotado();

        if (animal.getCaracterisca() != null) {
            animalResponseDto.caracterisca = CaracteriscaResponseDto.from(animal.getCaracterisca());
        }
        return animalResponseDto;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Boolean getAdotado() {
        return adotado;
    }

    public void setAdotado(Boolean adotado) {
        this.adotado = adotado;
    }

    public LocalDate getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDate dataChegada) {
        this.dataChegada = dataChegada;
    }
}
