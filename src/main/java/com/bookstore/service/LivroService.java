package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Livro;
import com.bookstore.repository.LivroRepository;
import com.bookstore.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + id + " Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer idCategoria) {
		//Verificar se a Categoria existe
		categoriaService.findById(idCategoria);
		return livroRepository.findAllByCategoria(idCategoria);
	}
}
