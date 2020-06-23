package com.filservtech.filipovcashapi.resource;

import com.filservtech.filipovcashapi.event.RecursoCriadoEvent;
import com.filservtech.filipovcashapi.model.Categoria;
import com.filservtech.filipovcashapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

	/* @GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	} */

    /* Exemplo da Aula - 3.5. Coleção vazia, o que retornar? */
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Categoria categoria = categoriaRepository.findOne(codigo);

        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

}