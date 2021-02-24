package com.system.model.dto;

import com.system.model.entities.Usuario;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private Usuario entidad;
    public UsuarioDTO(){
        this.entidad = new Usuario();
    }
    public Usuario getEntidad(){
        return entidad;
    }
    public void setEntidad(Usuario entidad){
        this.entidad = entidad;
    }
}
