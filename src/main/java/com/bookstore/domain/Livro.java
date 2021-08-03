package com.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Essa anotação indica para o JPA que ela pode criar uma tabela na nossa base de dados
@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	// Indica que o campo id é uma chave primária da entidade Livro
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "O campo TÍTULO deve ser preenchido")
	@Length(min = 3, max = 50, message = "O campo TÍTULO deve ter entre 3 e 50 caracteres.")
	private String titulo;
	
	@NotEmpty(message = "O campo NOME DO AUTOR deve ser preenchido")
	@Length(min = 3, max = 50, message = "O campo  NOME DO AUTOR deve ter entre 3 e 50 caracteres.")
	private String nomeAutor;
	
	@NotEmpty(message = "O campo TEXTO deve ser preenchido")
	@Length(min = 10, max = 10000, message = "O campo TEXTO deve ter entre 10 e 10.000 caracteres.")
	private String texto;

	// 1 categoria para vários livros
	// JsonIgnore ignora a categoria ao criar o json de dados e evita um loop
	// infinito
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Livro() {
		super();

	}

	public Livro(Integer id, String titulo, String nomeAutor, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

}
