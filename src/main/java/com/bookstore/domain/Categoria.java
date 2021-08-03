package com.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

//Essa anotação indica para o JPA que ela pode criar uma tabela na nossa base de dados
@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	// Indica que o campo id é uma chave primária da entidade Categoria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//Essa anotação indica que o nome não pode ser vazio
	@NotEmpty(message = "O campo NOME deve ser preenchido")
	//Essa anotação de define o tamanho minímo e o tamanho máximo do campo
	@Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres.")
	private String nome;
	@NotEmpty(message = "O campo DESCRIÇÃO deve ser preenchido")
	@Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre 3 e 200 caracteres.")
	private String descricao;

	// Cardinaliade de 1 para n com o objeto categoria na classe Livro
	// Uma categoria para vários livros
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList<>();

	public Categoria() {
		super();

	}

	public Categoria(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
}
