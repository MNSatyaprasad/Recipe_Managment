package com.recipe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.recipe.entity.Recipes;
import com.recipe.exception.ResourceNotFound;
import com.recipe.repo.IRecipeRepo;

@ExtendWith(SpringExtension.class)
class RecipeServiceImplTest {
	
	@InjectMocks
	private RecipeServiceImpl recipeservice;
	
	@Mock
	private IRecipeRepo repo;
	
	 @Test
	public void testGetTypeOfRecipes() {
		String type ="vegetrain";
		
		List<Recipes> actual = new ArrayList<>();
		
		when(repo.findByType(type)).thenReturn(actual);
		List<Recipes> expected = recipeservice.getTypeOfRecipes("vegetrain");
		assertEquals(expected, actual);
		verify(repo).findByType(type);
	}
	@Test
	public void testAddRecipe() {
		 Recipes actual = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		when(repo.save(ArgumentMatchers.any(Recipes.class))).thenReturn(actual);
		Recipes expected = recipeservice.addRecipe(actual);
		assertEquals(expected, actual);
		verify(repo).save(expected);
	}
	@Test
	public void testUpdateRecipe() throws ResourceNotFound {
		
		 Recipes recipe = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
	
		  when(repo.findById(10)).thenThrow(ResourceNotFound.class);
		  recipe.setIngredients_name("Fish");	
		  when(repo.save(ArgumentMatchers.any(Recipes.class))).thenReturn(recipe);
		 assertEquals(recipeservice.updateRecipe(recipe, 10), recipe);
		
		}
		
	
	  @Test
	  public void testGetAllRecipes() {
		  Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		  Recipes recipe2 = new Recipes(11,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		  List<Recipes> list = Arrays.asList(recipe1,recipe2);
		 when(repo.findAll()).thenReturn(list);
		  List<Recipes> expected =recipeservice.getAllRecipes();
		  assertEquals(expected, list);
	  }
	  @Test
	  public void testGetRecipeById() {
		   Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		  
		when(repo.findById(10)).thenReturn(Optional.of(recipe1));
		  assertNotEquals(recipeservice.getRecipeById(10), recipe1);
	  }
//	@Test
//	public void testDeleteAllRecipes() {
//
//		
//		
//		Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
//		 when(repo.findById(recipe1.getId())).thenReturn(Optional.of(recipe1));
//		 verify(repo).deleteById(recipe1.getId());
//		 
//	}
}
