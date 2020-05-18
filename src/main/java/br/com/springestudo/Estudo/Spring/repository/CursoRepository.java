package br.com.springestudo.Estudo.Spring.repository;

import br.com.springestudo.Estudo.Spring.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nome);
}
