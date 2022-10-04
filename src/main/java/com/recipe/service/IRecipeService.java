package com.recipe.service;

import java.util.List;
import java.util.Optional;

import com.recipe.entity.Recipes;

public interface IRecipeService {

	
	public Recipes addRecipe(Recipes recipe);
	
	 public Recipes updateRecipe(Recipes recipe,Integer id);
	 
	 public void  deleteAllRecipes();
	 
	 public void deleteRecipeById(Integer id);
	 
	 public Optional<Recipes> getRecipeById(Integer id);
	 
	 public List<Recipes> getAllRecipes();
	 
	 public List<Recipes> getTypeOfRecipes(String type);
}
