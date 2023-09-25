package com.api.locadoraveiculos.dtos;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class UsuarioDto {

    @NotBlank
    private String login;
    @NotBlank
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}