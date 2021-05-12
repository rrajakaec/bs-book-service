package com.mycompany.bs.bookservice.exception;

import static java.time.Instant.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(value = NOT_FOUND)
	public ErrorMessage noSuchElementException(NoSuchElementException ex, WebRequest web) {
		return new ErrorMessage(NOT_FOUND.value(), ex.getMessage(), now());
	}
}
