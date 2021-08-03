package com.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.domain.Livro;
import com.bookstore.dto.LivroDTO;
import com.bookstore.service.LivroService;


//Essa anotação informa que o endpoint /livros pode receber requisições de diversas fontes, de diversas portas Exemplo: A porta do angular 4200
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro livro = livroService.findById(id);
		return ResponseEntity.ok().body(livro);
	}
	
	//Quando recebemos uma requisição com /livros e recebemos um id de categoria ele vai listar todos os livros
	//localhost:8080/livros?categoria=1, esse é um exemplo de como fica
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAlll(@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria){
		List<Livro> livros = livroService.findAll(idCategoria);
		List<LivroDTO> livrosDTO = livros.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livrosDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro livroParaAtualizar){
		Livro livroAtualizado = livroService.update(id, livroParaAtualizar);
		return ResponseEntity.ok().body(livroAtualizado);
	}
	
	//Atualiza parcialmente as iformações
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @Valid @RequestBody Livro livroParaAtualizar){
		Livro livroAtualizado = livroService.update(id, livroParaAtualizar);
		return ResponseEntity.ok().body(livroAtualizado);
	}
	
	//Quando recebemos uma requisição POST com /livros e recebemos um id de categoria ele vai vincular o livro
	//localhost:8080/livros?categoria=1, esse é um exemplo de como fica
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value= "categoria", defaultValue = "0" ) Integer idCategoria, @Valid @RequestBody Livro livro){
		Livro novoLivro = livroService.create(idCategoria, livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(novoLivro.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
