package com.alpha.hospital.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.hospital.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler  {

	@ExceptionHandler(exception = DoctorNotFoundException.class)
	public ResponseStructure<String> DoctorNotFoundHandler()
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Doctor NOT FOUND");
		rs.setData("Doctor NOT FOUND");
		return rs;
	}
	
	@ExceptionHandler(DoctorFoundException.class)
	public ResponseStructure<String> doctorFoundExceptionHandler()
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.CONFLICT.value());
		rs.setMessage("Doctor Already Present");
		rs.setData("Doctor Already Present");
		return rs;
	}

	@ExceptionHandler(exception = IllegalArgumentException.class)
	public ResponseStructure<String> IllegalArgumentException()
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("Invalid ID");
		rs.setData("Invalid ID");
		return rs;
	}
	
	@ExceptionHandler(exception = InvalidDataException.class)
	public ResponseStructure<String> InvalidDataException()
	{
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatuscode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("Invalid Data");
		rs.setData("Invalid Data");
		return rs;
	}

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseStructure<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)
	{
		Map<String,String> errormap = new HashMap<>();
		List<ObjectError> objerror = ex.getAllErrors();
		
		for (ObjectError objectError : objerror) {
			System.err.println(objectError.getDefaultMessage());
			
			FieldError fr = (FieldError) objectError;
			
			System.err.println(fr.getField());
			
			errormap.put(objectError.getDefaultMessage(),fr.getField());
		}
		
		ResponseStructure<Map<String,String>> rs = new ResponseStructure<Map<String,String>>();
		rs.setStatuscode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("VALIDATION FAILED");
		rs.setData(errormap);
		return rs;
	}
}
