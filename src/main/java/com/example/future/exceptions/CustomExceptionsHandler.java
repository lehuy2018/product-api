package com.example.future.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.future.response.ErrorMessage;

@ControllerAdvice
public class CustomExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorMessage> handleExceptions(Exception ex, WebRequest request) {
		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null) {
			errorMessageDescription = ex.toString();
		}
		ErrorMessage error = new ErrorMessage(new Date(), errorMessageDescription);
		return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { NullPointerException.class, ProductExceptionsHandler.class })
	public ResponseEntity<ErrorMessage> handleNullPointerExceptions(Exception ex, WebRequest request) {
		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null) {
			errorMessageDescription = ex.toString();
		}
		ErrorMessage error = new ErrorMessage(new Date(), errorMessageDescription);
		return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
