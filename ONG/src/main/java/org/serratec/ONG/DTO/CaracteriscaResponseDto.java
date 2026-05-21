package org.serratec.ONG.DTO;

import org.serratec.ONG.Domain.Caracterisca;

import java.math.BigDecimal;

public class CaracteriscaResponseDto {

    private Long id;
    private String porte;
    private BigDecimal peso;
    private BigDecimal altura;
    private String pelo;
    private Integer idade;

    public static CaracteriscaResponseDto from(Caracterisca c) {
        if (c == null) return null;
        CaracteriscaResponseDto dto = new CaracteriscaResponseDto();
        dto.id     = c.getId();
        dto.porte  = c.getPorte();
        dto.peso   = c.getPeso();
        dto.altura = c.getAltura();
        dto.pelo   = c.getPelo();
        dto.idade  = c.getIdade();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
