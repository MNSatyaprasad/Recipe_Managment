package com.recipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.entity.Recipes;
import com.recipe.service.IRecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipesController {
	
	
	@Autowired
	private IRecipeService recipeservicerepo;
	
	@PostMapping("/save")
	public ResponseEntity<Recipes> addRecipe(@RequestBody Recipes recipe){
		Recipes saveRecipe = recipeservicerepo.addRecipe(recipe);
	return new ResponseEntity<Recipes>(saveRecipe,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Recipes> updateRecipe(@RequestBody Recipes recipe,@PathVariable("id") Integer id){
		Recipes updateRecipe = recipeservicerepo.updateRecipe(recipe, id);
	return new ResponseEntity<Recipes>(updateRecipe,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<Recipes> deleteAllRecipe() {
		
		ResponseEntity<Recipes> response= new ResponseEntity<Recipes>(HttpStatus.OK);
		try {
			recipeservicerepo.deleteAllRecipes();
		}catch(Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<Recipes>(HttpStatus.OK);
		}
		return response;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Recipes> deleteRecipeByid(@PathVariable("id") Integer id) {
		
		ResponseEntity<Recipes> response= new ResponseEntity<Recipes>(HttpStatus.OK);
		try {
			recipeservicerepo.deleteRecipeById(id);
		}catch(Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<Recipes>(HttpStatus.OK);
		}
		return response;
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Recipes>> getRecipeByid(@PathVariable("id") Integer id){
		Optional<Recipes> recipes = recipeservicerepo.getRecipeById(id);
		return new ResponseEntity<Optional<Recipes>>(recipes,HttpStatus.OK);	
	}
	@GetMapping("/all")
	public ResponseEntity<List<Recipes>> getAllRecipes(){
		List<Recipes> allrecipes = recipeservicerepo.getAllRecipes();
	return new 	ResponseEntity<List<Recipes>>(allrecipes,HttpStatus.OK);
	}
	@GetMapping("/{type}")
	public ResponseEntity<List<Recipes>> getTypeOfRecipes(@PathVariable("type") String type){
		List<Recipes> typeofrecipes = recipeservicerepo.getTypeOfRecipes(type);
	return new 	ResponseEntity<List<Recipes>>(typeofrecipes,HttpStatus.OK);
	}
}
