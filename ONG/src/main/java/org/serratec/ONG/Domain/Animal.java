package org.serratec.ONG.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Espécie é obrigatória")
    private String especie;

    @NotBlank
    private String raca;

    private Boolean adotado = false;

    @Column(name = "data_chegada")
    private LocalDate dataChegada;

    @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
    private Caracterisca caracterisca;

    @ManyToMany(mappedBy = "animaisApadrinhados")
    @JsonBackReference("pessoa-apadrinhados")
    private List<Pessoa> padrinhos = new ArrayList<>();

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDate dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Boolean getAdotado() {
        return adotado;
    }

    public void setAdotado(Boolean adotado) {
        this.adotado = adotado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Caracterisca getCaracterisca() {
        return caracterisca;
    }

    public void setCaracterisca(Caracterisca caracterisca) {
        this.caracterisca = caracterisca;
    }

    public List<Pessoa> getPadrinhos() {
        return padrinhos;
    }

    public void setPadrinhos(List<Pessoa> padrinhos) {
        this.padrinhos = padrinhos;
    }
}
