package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.repository.CategoriaRepository;
import com.bookstore.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		//Pode ser que ele encontre ou não, por isso passamos o Optional
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		//Se não encontrar, vai retornar a função anônima que imlementa a minha execeção personalizada para objetos não encontrados
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id: " + id + " Tipo: " + Categoria.class.getName()));
	}
	
	//Retorna todas as categorias
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria categoria) {
		// Se o id vier preenchido, vamos passar nulo para o JPA não atualizar e só inserir
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
}
