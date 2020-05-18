package br.com.springestudo.Estudo.Spring.controller.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AccountForm {

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String senha;

    public UsernamePasswordAuthenticationToken login() {
       return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
