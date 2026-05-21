package org.serratec.ONG.DTO;

import org.serratec.ONG.Domain.Animal;

import java.time.LocalDate;

public class AnimalResponseDto {

    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private Boolean adotado;
    private LocalDate dataChegada;

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
