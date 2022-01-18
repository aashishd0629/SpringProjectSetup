package com.npg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling specific exception
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> customExceptionHandling(CustomException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, exception.getHttpStatus());
	}

	// handling global exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails("id not found bhatte", request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}