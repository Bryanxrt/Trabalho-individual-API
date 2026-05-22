package org.serratec.ONG.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class CaracteriscaRequestDto {

    @NotNull(message = "O ID do animal é obrigatório")
    private Long animalId;

    private String porte;

    @Positive(message = "Peso deve ser positivo")
    private BigDecimal peso;

    @Positive(message = "Altura deve ser positiva")
    private BigDecimal altura;

    private String pelo;

    @Min(value = 0, message = "Idade não pode ser negativa")
    private Integer idade;

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public String getPelo() {
        return pelo;
    }

    public void setPelo(String pelo) {
        this.pelo = pelo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
