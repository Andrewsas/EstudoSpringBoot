package br.com.springestudo.Estudo.Spring.util;


import lombok.Getter;
import lombok.Setter;

public class ErroFormulario {

    @Getter
    private String campo;

    @Getter
    private String mensagem;

    public ErroFormulario(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }
}
