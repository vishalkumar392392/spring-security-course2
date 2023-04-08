package com.vishal.security.springsecuritybasic.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
	
	private String message;
	
	private String errorCode;
	
	private String errorType;

}
