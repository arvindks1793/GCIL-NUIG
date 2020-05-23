package com.gcil.cms.app.exception;

public class CustomerExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerExistsException() {

		super();
	}

	public CustomerExistsException(String message) {

		super(message);
	}

}
