package com.bookstore.resource.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookstore.service.exception.DataIntegrityViolationException;
import com.bookstore.service.exception.ObjectNotFoundException;



//Essa anotação gerencia as exceções de forma global
@ControllerAdvice
public class ResourceExceptionHandler {
	//Essa anotação indica o método que vai ser compartilhado entre várias classes de controller para que elas possam retornar toda a lógica da exceção
		@ExceptionHandler(ObjectNotFoundException.class)
		public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest servletRequest){
			StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		    //Se não encontrar o objeto no banco de dados, ele retorna o status NOT FOUND para a requisição e a mensagem de erro
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
		}
		
		@ExceptionHandler(DataIntegrityViolationException.class)
		public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest servletRequest){
			StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
		}
		
		
}
