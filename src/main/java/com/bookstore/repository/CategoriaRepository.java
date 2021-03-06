package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.domain.Categoria;

/*Informa para o Spring que estamos criando uma interface repository 
 * Vamos fazer a persistência de nossas informações
 * */
@Repository
/*
 * Extendemos do JPA Repository um framework que auxila a manipulação de dados
 * com ele não precisamos criar os comandos sql e nem os DAO ou Repositorys
 * manualmente ele recebe como argumento o objeto que no caso é Categoria e o
 * tipo primitivo da chave primária da tabela referente ao objeto no banco de
 * dados.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
