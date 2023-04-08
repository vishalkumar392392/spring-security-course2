package com.vishal.security.springsecuritybasic.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<Object> handleDBValidation(CustomException ex, WebRequest req) {

		return new ResponseEntity<>(ex.getExceptionResponse(), ex.getHttpStatus());

	}
}
