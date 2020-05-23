package com.gcil.cms.app.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GcilCmsControllerAdvice {

	// method to handle resource not found exception
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound(final CustomerNotFoundException exception,
			final HttpServletRequest request) {
		System.out.println("inside controller advice");
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getLocalizedMessage());
		error.setRequestedURI(request.getRequestURI());
		return error;
	}

	@ExceptionHandler(GcilServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleServiceException(final GcilServiceException exception,
			final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getLocalizedMessage());
		error.setRequestedURI(request.getRequestURI());
		System.out.println("inside gecil service exception" + exception.getMessage());
		return error;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleAllException(final Exception exception,
			final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getLocalizedMessage());
		error.setRequestedURI(request.getRequestURI());
		System.out.println("inside general exception class" + exception.getMessage());
		return error;
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleUserNotFoundException(final UserNotFoundException exception,
			final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getLocalizedMessage());
		error.setRequestedURI(request.getRequestURI());
		System.out.println(exception.getMessage());
		return error;
	}

	@ExceptionHandler(CustomerExistsException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public @ResponseBody ExceptionResponse handleCustomerExistsExceptionException(
			final CustomerExistsException exception, final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getLocalizedMessage());
		error.setRequestedURI(request.getRequestURI());
		System.out.println(exception.getMessage());
		return error;
	}

	@ExceptionHandler(RequestNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleRequestNotFoundException(final RequestNotFoundException exception,
			final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getLocalizedMessage());
		error.setRequestedURI(request.getRequestURI());
		System.out.println(exception.getMessage());
		return error;
	}

}
