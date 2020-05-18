package br.com.springestudo.Estudo.Spring.controller.form;

import br.com.springestudo.Estudo.Spring.model.Curso;
import br.com.springestudo.Estudo.Spring.model.Topico;
import br.com.springestudo.Estudo.Spring.repository.CursoRepository;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class TopicoForm {
    @Getter
    @Setter
    @NotEmpty(message = "titulo.required") @Length(min = 5, message = "titulo.min.lenght")
    private String titulo;

    @Getter
    @Setter
    @NonNull @NotEmpty @Length(min = 5)
    private String mensagem;

    @Getter
    @Setter
    @NonNull @NotEmpty @Length(min = 3)
    private String nomeCurso;


    public Topico convert(CursoRepository cursoRepository) {
        Topico topico;
        Curso curso = cursoRepository.findByNome(nomeCurso);
        if (curso != null) {
            topico =  new Topico(titulo, mensagem, curso);
        } else {
            curso = cursoRepository.save(new Curso(nomeCurso));
            topico =  new Topico(titulo, mensagem, curso);
        }
        return topico;
    }
}
