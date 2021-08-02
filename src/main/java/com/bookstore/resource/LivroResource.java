package com.bookstore.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.domain.Livro;
import com.bookstore.dto.LivroDTO;
import com.bookstore.service.LivroService;

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
}
