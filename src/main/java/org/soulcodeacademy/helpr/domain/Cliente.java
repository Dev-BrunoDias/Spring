package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Cliente extends Usuario {

    private String telefone;

    @ManyToOne
    private Cargo cargo;

    public Cliente() {}

    public Cliente(Integer id, String nome, String email, String cpf, String senha, String telefone, Cargo cargo) {
        super(id, nome, email, cpf, senha, Perfil.CLIENTE);
        this.telefone = telefone;
        this.cargo = cargo;
    }



    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
