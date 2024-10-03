package com.mph.sprbootdemo.exception;


public class DepartmentNotFoundException extends RuntimeException {

	public DepartmentNotFoundException() {
		super();
	}

	public DepartmentNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public DepartmentNotFoundException(String message) {
		super(message);

	}

}
