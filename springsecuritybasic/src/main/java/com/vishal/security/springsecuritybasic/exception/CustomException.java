package com.vishal.security.springsecuritybasic.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 3586919387095559720L;

	private HttpStatus httpStatus;

	private ExceptionResponse exceptionResponse;

	public CustomException(HttpStatus httpStatus, ExceptionResponse exceptionResponse) {
		super();
		this.httpStatus = httpStatus;
		this.exceptionResponse = exceptionResponse;
	}

}
