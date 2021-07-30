package com.bookstore.resource.exception;

//Serve como objeto padrão da estrura de gravação de erros
public class StandardError {

	// Momento que ocorreu a exceção
	private Long timeStamp;
	// Status da requisição Exem: 404
	private Integer status;
	// O erro em si
	private String error;

	public StandardError() {
		super();
	}

	public StandardError(Long timeStamp, Integer status, String error) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
