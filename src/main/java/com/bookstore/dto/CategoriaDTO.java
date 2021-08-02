package com.bookstore.dto;

import java.io.Serializable;

import com.bookstore.domain.Categoria;



/*O padrão DTO é utilizado para omitir algumas informações, 
 * no caso se queremos apenas buscar a categoria sem os livros, sendo assim a busca fica mais rápida quando precisamos */
public class CategoriaDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
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
	
