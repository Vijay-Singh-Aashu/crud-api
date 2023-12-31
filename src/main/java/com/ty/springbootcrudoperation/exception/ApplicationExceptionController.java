package com.ty.springbootcrudoperation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.springbootcrudoperation.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionController {

	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noIdExceptionHandler(IdNotFoundException exception){
		
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMsg("NO Data Found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
}
