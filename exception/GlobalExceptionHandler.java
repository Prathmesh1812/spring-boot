package com.bank.sb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleTeacherException
	(CustomerIdNotFoundException ex, WebRequest request){
		ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	}
	
	@ExceptionHandler(CustomertIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleDepartmentException
	(CustomerIdNotFoundException ex, WebRequest request){
		ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	}
	
}
