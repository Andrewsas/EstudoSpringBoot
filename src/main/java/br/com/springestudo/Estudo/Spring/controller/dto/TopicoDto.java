package br.com.springestudo.Estudo.Spring.controller.dto;

import br.com.springestudo.Estudo.Spring.model.StatusTopico;
import br.com.springestudo.Estudo.Spring.model.Topico;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicoDto {
    @Getter
    Long id;

    @Getter
    String titulo;

    @Getter
    String mensagem;

    @Getter
    String nomeAutor;

    @Getter
    StatusTopico statusTopico;

    @Getter
    List<RespostaDto> respostaDtos;


    @Getter
    LocalDateTime dataCriacao;

    public static List<TopicoDto> convert(List<Topico> topicos) {
        return topicos.stream().map(t -> new TopicoDto(t, false)).collect(Collectors.toList());
    }

    public TopicoDto(Topico topico, boolean all) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        if (all) {
            this.statusTopico = topico.getStatus();
            this.nomeAutor = topico.getAutor() != null ? topico.getAutor().getNome() : "Aluno";
            this.respostaDtos = topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList());
        }
    }

}
