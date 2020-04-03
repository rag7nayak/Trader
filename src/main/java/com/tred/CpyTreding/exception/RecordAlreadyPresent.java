package com.tred.CpyTreding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecordAlreadyPresent extends RuntimeException {

	public RecordAlreadyPresent(String message) {
		super(message);
	}

	
	
}
