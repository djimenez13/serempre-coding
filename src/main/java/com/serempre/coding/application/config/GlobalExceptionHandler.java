package com.serempre.coding.application.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.serempre.coding.domain.model.common.Response;
import com.serempre.coding.domain.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ ResourceNotFoundException.class })
	protected ResponseEntity<Response> handleNotFoundConflict(RuntimeException exception, WebRequest request) {
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(
						Response.builder()
						.message(exception.getMessage())
						.build());
	}
	
	@ExceptionHandler({ RuntimeException.class })
	protected ResponseEntity<Response> handleUnexpectedConflict(RuntimeException exception, WebRequest request) {
		exception.printStackTrace();
		
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(
						Response.builder()
							.message("Unexpected error")
							.build());
	}
	
	

}
