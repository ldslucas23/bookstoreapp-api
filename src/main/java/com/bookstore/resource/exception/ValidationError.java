package com.bookstore.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	// Essa lista de erros que dão na requisição quando algum campo não é preenchido, etc...
	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError() {
		super();

	}

	public ValidationError(Long timeStamp, Integer status, String error) {
		super(timeStamp, status, error);

	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String fieldName, String erro) {
		this.erros.add(new FieldMessage(fieldName, erro));
	}

}
