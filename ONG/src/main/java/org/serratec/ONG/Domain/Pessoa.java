package org.serratec.ONG.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome deve ser preenchido")
    @Size(min = 2, max = 50)
    private String nome;

    @Email(message = "Email invalido")
    @NotBlank(message = "O email deve ser preenchido")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "O telefone deve ser preenchido")
    private String telefone;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonManagedReference("pessoa-enderecos")
    private List<Endereco> endereco = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonManagedReference("pessoa-interesses")
    private List<InteresseAdocao> interesseAdocao =  new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "pessoa_animal_apadrinhado", joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_animal"))
    private List<Animal> animaisApadrinhados = new ArrayList<>();

    public Pessoa() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public List<InteresseAdocao> getInteresseAdocao() {
        return interesseAdocao;
    }

    public void setInteresseAdocao(List<InteresseAdocao> interesseAdocao) {
        this.interesseAdocao = interesseAdocao;
    }

    public List<Animal> getAnimaisApadrinhados() {
        return animaisApadrinhados;
    }

    public void setAnimaisApadrinhados(List<Animal> animaisApadrinhados) {
        this.animaisApadrinhados = animaisApadrinhados;
    }
}
