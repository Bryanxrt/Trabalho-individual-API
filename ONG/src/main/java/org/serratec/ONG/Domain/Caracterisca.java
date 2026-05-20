package org.serratec.ONG.Domain;

import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Caracterisca {

    @OneToOne
    private Animal animal;
    private BigDecimal peso;
    private BigDecimal altura;
    private String pelo;
    private Integer idade;


    public Caracterisca() {
    }
}
