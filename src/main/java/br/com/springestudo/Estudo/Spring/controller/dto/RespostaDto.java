package br.com.springestudo.Estudo.Spring.controller.dto;

import br.com.springestudo.Estudo.Spring.model.Resposta;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaDto {
    @Getter
    private Long id;

    @Getter
    private String mensagem;

    @Getter
    private LocalDateTime dataCriacao;

    @Getter
    private String nomeAutor;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }
}
