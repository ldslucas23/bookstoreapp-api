package com.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.bookstore.domain.Categoria;



/*O padrão DTO é utilizado para omitir algumas informações, 
 * no caso se queremos apenas buscar a categoria sem os livros, sendo assim a busca fica mais rápida quando precisamos */
public class CategoriaDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	//Essa anotação indica que o nome não pode ser vazio
	@NotEmpty(message = "O campo NOME deve ser preenchido")
	//Essa anotação de define o tamanho minímo e o tamanho máximo do campo
	@Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres.")
	private String nome;
	@NotEmpty(message = "O campo DESCRIÇÃO deve ser preenchido")
	@Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre 3 e 200 caracteres.")
	private String descricao;

	public CategoriaDTO() {
		super();

	}

	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
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

}
	
