package br.com.springestudo.Estudo.Spring.controller;

import br.com.springestudo.Estudo.Spring.controller.dto.TopicoDto;
import br.com.springestudo.Estudo.Spring.controller.form.TopicoForm;
import br.com.springestudo.Estudo.Spring.model.Topico;
import br.com.springestudo.Estudo.Spring.repository.CursoRepository;
import br.com.springestudo.Estudo.Spring.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    @Cacheable(value = "listaTopicos")
    public List<TopicoDto> topicoList(@PageableDefault(sort = "id") Pageable paginacao) {
        List<Topico> topicos = topicoRepository.findAll(paginacao).getContent();
        return TopicoDto.convert(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> topicoDetalhes(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new TopicoDto(topico.get(), true));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @CacheEvict(value = "listaTopicos", allEntries = true)
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.convert(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico, false));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = topicoRepository.getOne(id);
//        topico.
//        topicoRepository.save();
        URI uri = uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico, false));
    }
}
