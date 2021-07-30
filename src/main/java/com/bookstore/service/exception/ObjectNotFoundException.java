package com.bookstore.service.exception;

//Estou aproveitando a estrutura do RuntimeException para criar os métodos e construtores
public class ObjectNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ObjectNotFoundException(String message) {
		super(message);
	
	}

}
