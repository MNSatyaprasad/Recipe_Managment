package com.recipe.exception;

public class RecipeNotFoundException extends Exception {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RecipeNotFoundException() {}
	
	public RecipeNotFoundException(String message) {
		super(message);
	}
	public RecipeNotFoundException(Exception e) {
		super(e);
	}
	public RecipeNotFoundException(String message, Exception e) {
		super(message, e);
	}
}
