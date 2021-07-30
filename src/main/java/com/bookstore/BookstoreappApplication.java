package com.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.domain.Categoria;
import com.bookstore.domain.Livro;
import com.bookstore.repository.CategoriaRepository;
import com.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreappApplication implements CommandLineRunner{

	@Autowired 
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreappApplication.class, args);
	}

	
	//Esse método vai ser chamado sempre que der run na aplicação
	@Override
	public void run(String... args) throws Exception {
		
		//Instanciei uma categoria e um livro e fiz os dois se relacionarem
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		//Chamei as interfaces e utilizei os métodos prontos do JPA para salvar na base de dados
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
	}

}
