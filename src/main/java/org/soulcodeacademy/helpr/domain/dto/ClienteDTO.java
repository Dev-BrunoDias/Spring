package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.NotNull;

public class ClienteDTO extends UsuarioDTO{

    private String telefone;

    @NotNull
    private  Integer idCargo;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
}
