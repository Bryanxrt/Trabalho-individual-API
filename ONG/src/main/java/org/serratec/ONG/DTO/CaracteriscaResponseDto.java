package org.serratec.ONG.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.ONG.Domain.Caracterisca;

import java.math.BigDecimal;

@JsonPropertyOrder({"id", "porte", "peso", "altura", "pelo", "idade"})
@Schema(description = "Dados retornados das características de um animal")
public class CaracteriscaResponseDto {

    @Schema(description = "ID da característica", example = "1")
    private Long id;

    @Schema(description = "Porte do animal", example = "Grande")
    private String porte;

    @Schema(description = "Peso em kg", example = "30.5")
    private BigDecimal peso;

    @Schema(description = "Altura em metros", example = "0.70")
    private BigDecimal altura;

    @Schema(description = "Tipo de pelo", example = "curto")
    private String pelo;

    @Schema(description = "Idade em anos", example = "5")
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
