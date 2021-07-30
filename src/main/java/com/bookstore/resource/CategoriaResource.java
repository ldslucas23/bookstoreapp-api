package com.bookstore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.domain.Categoria;
import com.bookstore.service.CategoriaService;

//Essa é uma classe de controlador Rest que recebe requisições
@RestController
//Para acessar os endpoints preciso passar o /categorias no endereço e chamar o endpoint após
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	//Passamos o id da categoria logo após o requestMapping e ele cai nesse endpoint e faz a lógica
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findByID(@PathVariable Integer id){
		Categoria categoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
	
}
