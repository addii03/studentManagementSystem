package com.SpringBoot.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResorceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resorceName;
	private String fieldName;
	private Object fieldValue;
	public ResorceNotFoundException(String resorceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s' ", fieldName,resorceName,fieldValue));
		this.resorceName = resorceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public String getresorceName()
	{
	
		return resorceName;
	}
	public String getfieldName()
	{
		return fieldName;
		
	}
	public Object getfieldValue()
	{
		return fieldValue;
	}
}
