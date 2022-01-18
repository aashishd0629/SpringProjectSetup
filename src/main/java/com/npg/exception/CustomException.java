package com.npg.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID=1L;
	
	public CustomException(HttpStatus httpStatus, String err) {
		super(err);
		this.httpStatus =httpStatus;
	}
	private HttpStatus httpStatus;

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
