package br.com.springestudo.Estudo.Spring.controller.dto;

import lombok.Getter;

public class TokenDto {

    @Getter
    private String token;

    @Getter
    private String tipo;

    public TokenDto(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }
}
