package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
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

	public Livro update(Integer id, Livro livro) {
		Livro livroParaAtualizar = findById(id);
		UpdateData(livroParaAtualizar, livro);
		return livroRepository.save(livroParaAtualizar);
	}

	private void UpdateData(Livro livroParaAtualizar, Livro livro) {
		livroParaAtualizar.setTitulo(livro.getTitulo());
		livroParaAtualizar.setTexto(livro.getTexto());
		livroParaAtualizar.setNomeAutor(livro.getNomeAutor());
	}

	public Livro create(Integer idCategoria, Livro livro) {
		livro.setId(null);
		//Verifica se a categoria existe
		Categoria categoria = categoriaService.findById(idCategoria);
		livro.setCategoria(categoria);
		return livroRepository.save(livro);
	}

	public void delete(Integer id) {
		Livro livro = findById(id);
		livroRepository.delete(livro);;
	}
}
