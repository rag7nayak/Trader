package com.tred.CpyTreding.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController

public class TradeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecordAlreadyPresent.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(RecordAlreadyPresent ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		CustomErrorEcxeption error = new CustomErrorEcxeption(new Date(), ex.getMessage(), ex.getCause().getMessage());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	protected ResponseEntity<Object> handleResourceNotFountException(ResourceNotFoundException ex, WebRequest request) {
		CustomErrorEcxeption error = new CustomErrorEcxeption(new Date(), ex.getMessage(), "");
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomErrorEcxeption message= new CustomErrorEcxeption(new Date(),ex.getMessage(),"Validation Failed");
		return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
	}
}
