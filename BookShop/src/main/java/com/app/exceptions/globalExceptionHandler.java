/**
 * 
 */
package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.DTOs.APIResponce;

/**
 * @author Sourabh
 *
 */
@RestControllerAdvice
public final class globalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> HandeException(Exception e){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIResponce(e.getMessage()));
		
	}
}
