package com.bookstore.service.exception;

//Estou aproveitando a estrutura do RuntimeException para criar os métodos e construtores
public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	
	}
	
	

}
