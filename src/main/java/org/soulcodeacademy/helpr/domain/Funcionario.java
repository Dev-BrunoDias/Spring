package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario extends Usuario {
    // Gera uma coluna dtype para indicar qual a subclasse (Funcionario ou Cliente)

    // Coluna foto não é obrigatória
    private String foto;

    @ManyToOne // MUITOS Funcionários para UM Cargo
    @JoinColumn(name = "id_Cargo") // Cria uma coluna nova que é a chave estrangeira do Cargo
    private Cargo cargo; // se eu quiser mudar o Cargo do funcionario basta mudar o objeto deste campo

    public Funcionario() {}

    public Funcionario(Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo) {
        super(id, nome, email, cpf, senha, Perfil.FUNCIONARIO); // Chamada do Construtor de Usuario
        this.foto = foto;
        this.cargo = cargo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}


// Anotações de relacionamento
//@OnetoOne = 1:1
//@OneToMany/@ManyToOne = 1:N
// @ManyToMany = N:N

// Relacionamento Unidirecional = apenas uma das entidades "conhece" a outra.
// Relacionamento Biderecional = as duas entidades se "conhecem".