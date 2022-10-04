package com.recipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.entity.Recipes;
import com.recipe.exception.ResourceNotFound;
import com.recipe.repo.IRecipeRepo;

@Service
public class RecipeServiceImpl implements IRecipeService {

	@Autowired
	private IRecipeRepo reciperepo;

	@Override
	public Recipes addRecipe(Recipes recipe) {
		
		return reciperepo.save(recipe);
	}

	@Override
	public Recipes updateRecipe(Recipes recipe, Integer id) {
		 Recipes exstingrecipe = reciperepo.findById(id).orElseThrow(
				 ()-> new ResourceNotFound("Revipes","id",id));
		 exstingrecipe.setName(recipe.getName());
		 exstingrecipe.setType(recipe.getType());
		 exstingrecipe.setNumberofServings(recipe.getNumberofServings());
		 exstingrecipe.setIngredients(recipe.getIngredients());
		 exstingrecipe.setIngredients_name(recipe.getIngredients_name());
		 reciperepo.save(exstingrecipe);
		return exstingrecipe;
	}

	@Override
	public void deleteAllRecipes() {
		reciperepo.deleteAll();
		
	}

	@Override
	public void deleteRecipeById(Integer id) {
		reciperepo.deleteById(id);
		
	}

	@Override
	public Optional<Recipes> getRecipeById(Integer id) {
		// TODO Auto-generated method stub
		return reciperepo.findById(id);
	}

	@Override
	public List<Recipes> getAllRecipes() {
		// TODO Auto-generated method stub
		return reciperepo.findAll();
	}

	@Override
	public List<Recipes> getTypeOfRecipes(String type) {
		
		return reciperepo.findByType(type);
	}

	
	

}
