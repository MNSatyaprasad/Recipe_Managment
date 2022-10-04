package com.recipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private Object fieldvalue;
	
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldvalue() {
		return fieldvalue;
	}
	public void setFieldvalue(Object fieldvalue) {
		this.fieldvalue = fieldvalue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ResourceNotFound(String resourceName, String fieldName, Object fieldvalue) {
		super(String.format("%s Student not found %s",resourceName,fieldName,fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}
	public ResourceNotFound() {
		super();
	}
	
	

}
