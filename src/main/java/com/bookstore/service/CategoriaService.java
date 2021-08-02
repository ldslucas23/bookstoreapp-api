package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.dto.CategoriaDTO;
import com.bookstore.repository.CategoriaRepository;
import com.bookstore.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		//Pode ser que ele encontre ou não, por isso passamos o Optional
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		//Se não encontrar, vai retornar a função anônima que imlementa a minha execeção personalizada para objetos não encontrados
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id: " + id + " Tipo: " + Categoria.class.getName()));
	}
	
	//Retorna todas as categorias
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria categoria) {
		// Se o id vier preenchido, vamos passar nulo para o JPA não atualizar e só inserir
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Integer id, CategoriaDTO categoriaDTO) {
		//Verificamos se o objeto existe, se não existir vai ter que retornar uma exceção
		Categoria categoria = findById(id);
		categoria.setNome(categoriaDTO.getNome());
		categoria.setDescricao(categoriaDTO.getDescricao());
		//Esse método já entende que tem um id é uma atualização
		return categoriaRepository.save(categoria);
	}

	public void delete(Integer id) {
		//Verificamos se o objeto existe, se não existir vai ter que retornar uma exceção
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.bookstore.service.exception.DataIntegrityViolationException("A Categoria não pode ser deletada! Pois, possui livros associados Id: " + id + " Tipo: " + Categoria.class.getName());
		}

	}
	

}
