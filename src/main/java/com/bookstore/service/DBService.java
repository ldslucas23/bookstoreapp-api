package com.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.domain.Livro;
import com.bookstore.repository.CategoriaRepository;
import com.bookstore.repository.LivroRepository;

//Anotação utilizada para fornecer funcionalidades de negócios
@Service
public class DBService {

	// Essa anotação indica para o spring quando criar, gerenciar e destruir a
	// instancia do objeto abaixo
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		// Instanciei categorias e um livros e fiz os dois se relacionarem
		Categoria cat1 = new Categoria(null, "Informática", "Livro de informática");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Uiografias", "Livros de Uiografias");

		Livro l1 = new Livro(null, "Clean code", "Ronbert Martin", "Loren ipsun", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Autor 1", "Loren ipsun", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "Autor 2", "Loren ipsun", cat2);
		Livro l4 = new Livro(null, "A Guerra dos Mundos", "Autor 3", "Loren ipsun", cat2);
		Livro l5 = new Livro(null, "Eu, Robô", "Autor 3", "Loren ipsun", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		// Chamei as interfaces e utilizei os métodos prontos do JPA para salvar na base
		// de dados
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

	}
}
