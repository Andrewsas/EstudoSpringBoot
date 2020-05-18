package br.com.springestudo.Estudo.Spring.repository;

import br.com.springestudo.Estudo.Spring.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
