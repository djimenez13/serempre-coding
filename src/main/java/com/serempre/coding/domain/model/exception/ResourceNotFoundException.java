package com.serempre.coding.domain.model.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -2467566258178939743L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
