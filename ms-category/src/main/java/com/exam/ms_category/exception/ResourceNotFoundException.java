package com.exam.ms_category.exception;

public class ResourceNotFoundException extends RuntimeException {

	String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public ResourceNotFoundException(String message) {
		this.message = message;
	}
}
