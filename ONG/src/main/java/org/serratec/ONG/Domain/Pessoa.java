package org.serratec.ONG.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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

    @OneToMany(mappedBy = "endereco")
    private List<Endereco> endereco;

    @OneToMany(mappedBy = "interesseAdocao", cascade = CascadeType.ALL)
    private List<InteresseAdocao> interesseAdocao;

    public Pessoa(Long id, String nome, String email, String telefone, List<Endereco> endereco, List<InteresseAdocao> interesseAdocao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.interesseAdocao = interesseAdocao;
    }

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
}
