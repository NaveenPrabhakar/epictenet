package com.epic.epictenet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class DataNotFoundException extends RuntimeException {
	
	@ExceptionHandler(value = DataNotFoundException.class)
	
	public ResponseEntity<Object> exception(DataNotFoundException exception){
		
		return new ResponseEntity<>("",HttpStatus.NOT_FOUND);
		
	}

}
