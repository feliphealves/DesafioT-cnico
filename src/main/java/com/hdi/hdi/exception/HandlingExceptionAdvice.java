package com.hdi.hdi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class HandlingExceptionAdvice {
	
	@ExceptionHandler(BrokerNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	protected ErrorResponse noBrokerFoundExceptionHandler(BrokerNotFoundException ex, WebRequest request) {
		
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false)		
				);
		return errorResponse;
	}
	
	@ExceptionHandler(ActivedBrokerException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	protected ErrorResponse noActivedBrokerExceptionHandler(ActivedBrokerException ex, WebRequest request) {
		
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.NOT_ACCEPTABLE.value(),
				new Date(),
				ex.getMessage(),
				request.getDescription(false)		
				);
		return errorResponse;
	}
}
