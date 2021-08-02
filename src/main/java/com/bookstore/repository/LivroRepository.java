package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.Livro;

/*Informa para o Spring que estamos criando uma interface repository 
 * Vamos fazer a persistência de nossas informações
 * */
@Repository
/*
 * Extendemos do JPA Repository um framework que auxila a manipulação de dados
 * com ele não precisamos criar os comandos sql e nem os DAO ou Repositorys
 * manualmente ele recebe como argumento o objeto que no caso é Livro e o
 * tipo primitivo da chave primária da tabela referente ao objeto no banco de
 * dados.
 */
public interface LivroRepository extends JpaRepository<Livro, Integer> {

	@Query("Select obj from Livro obj where obj.categoria.id = :id_categoria order by titulo ")
	List<Livro> findAllByCategoria(@Param(value="id_categoria")  Integer idCategoria);

}
