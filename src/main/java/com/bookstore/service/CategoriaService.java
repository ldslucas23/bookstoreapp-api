package com.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		//Pode ser que ele encontre ou não, por isso passamos o Optional
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		//Se não encontrar, vai retornar nulo
		return categoria.orElse(null);
	}
}
