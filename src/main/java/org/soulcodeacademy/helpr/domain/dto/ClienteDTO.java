package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.NotNull;

public class ClienteDTO extends UsuarioDTO{

    private String telefone;


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}