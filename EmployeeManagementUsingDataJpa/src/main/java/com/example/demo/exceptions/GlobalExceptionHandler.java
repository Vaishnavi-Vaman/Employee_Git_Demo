package com.example.demo.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception=EmployeeNotFound.class)
	public ResponseEntity<ExceptionResponse> employeeNotFound(EmployeeNotFound ex) {
		    //for status code                                     //exception name
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDate.now(),404);
		return new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
	}
	
@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
			StringBuilder errors = new StringBuilder();
			ex.getBindingResult().getFieldErrors().forEach(
					error -> errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; "));
			return new ResponseEntity<>("Validation error(s): " + errors.toString(), HttpStatus.BAD_REQUEST);
		}
	
	@ExceptionHandler(exception=Exception.class)
	public ResponseEntity<ExceptionResponse> validationException(Exception ex) {
		    //for status code                                     //exception name
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDate.now(),404);
		return new ResponseEntity<ExceptionResponse>(exception,HttpStatus.NOT_FOUND);
	}
}
