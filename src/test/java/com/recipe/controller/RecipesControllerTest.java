package com.recipe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.entity.Recipes;
import com.recipe.service.RecipeServiceImpl;
@WebMvcTest(value = RecipesController.class)
class RecipesControllerTest {
	@MockBean
	private RecipeServiceImpl recipeservice;
	@Autowired
	private MockMvc mokmvc;
	
	@Test
	public void testaddRecipe() throws Exception {
		Recipes recipes = new Recipes();
		when(recipeservice.addRecipe(ArgumentMatchers.any())).thenReturn(recipes);
		
		Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		ObjectMapper mapper = new ObjectMapper();
		String recipejson = mapper.writeValueAsString(recipe1);
		
		          MockHttpServletRequestBuilder requestbulider =MockMvcRequestBuilders.post("/recipe/save")
								.contentType(MediaType.APPLICATION_JSON)
								.content(recipejson);
		        ResultActions perform =  mokmvc.perform(requestbulider);
		        
		        MvcResult andReturn = perform.andReturn();
		     MockHttpServletResponse response =   andReturn.getResponse();
		   int status =  response.getStatus();
		   assertEquals(201, status);   
	}
	@Test
	public void testUpdateRecipe() throws Exception{
		
		Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		ObjectMapper mapper = new ObjectMapper();
		String recipejson = mapper.writeValueAsString(recipe1);
		
		          MockHttpServletRequestBuilder requestbulider =MockMvcRequestBuilders.put("/recipe/update/10")
								.contentType(MediaType.APPLICATION_JSON)
								.content(recipejson);
		        ResultActions perform =  mokmvc.perform(requestbulider);
		        
		        MvcResult andReturn = perform.andReturn();
		     MockHttpServletResponse response =   andReturn.getResponse();
		   int status =  response.getStatus();
		   assertEquals(201, status);  
	}
	@Test
	public void testGetAllRecipes() throws Exception{
		Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		Recipes recipe2 = new Recipes(11,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		List<Recipes> list = Arrays.asList(recipe1,recipe2);
		ObjectMapper mapper = new ObjectMapper();
		String recipejson = mapper.writeValueAsString(list);
		
		          MockHttpServletRequestBuilder requestbulider =MockMvcRequestBuilders.get("/recipe/all")
								.contentType(MediaType.APPLICATION_JSON)
								.content(recipejson);
		        ResultActions perform =  mokmvc.perform(requestbulider);
		        
		        MvcResult andReturn = perform.andReturn();
		     MockHttpServletResponse response =   andReturn.getResponse();
		   int status =  response.getStatus();
		   assertEquals(200, status);  
	}
	@Test
	public void testGetRecipeByid() throws Exception{
		
		Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		
		
		ObjectMapper mapper = new ObjectMapper();
		String recipejson = mapper.writeValueAsString(recipe1);
		
		          MockHttpServletRequestBuilder requestbulider =MockMvcRequestBuilders.get("/recipe/id/100")
								.contentType(MediaType.APPLICATION_JSON)
								.content(recipejson);
		        ResultActions perform =  mokmvc.perform(requestbulider);
		        
		        MvcResult andReturn = perform.andReturn();
		     MockHttpServletResponse response =   andReturn.getResponse();
		   int status =  response.getStatus();
		   assertEquals(200, status);  
	}
	@Test
	public void testGetTypeOfRecipes() throws Exception{
			Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		
		ObjectMapper mapper = new ObjectMapper();
		String recipejson = mapper.writeValueAsString(recipe1);
		
		MockHttpServletRequestBuilder requestbulider =MockMvcRequestBuilders.get("/recipe/NON-VEG")
								.contentType(MediaType.APPLICATION_JSON)
								.content(recipejson);
		ResultActions perform =  mokmvc.perform(requestbulider);
		        
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response =   andReturn.getResponse();
		int status =  response.getStatus();
		assertEquals(200, status);
		
	}
	@Test
	public void testDeleteRecipeByid() throws Exception{
	Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		
		ObjectMapper mapper = new ObjectMapper();
		String recipejson = mapper.writeValueAsString(recipe1);
		
		MockHttpServletRequestBuilder requestbulider =MockMvcRequestBuilders.delete("/recipe/delete/400")
								.contentType(MediaType.APPLICATION_JSON)
								.content(recipejson);
		ResultActions perform =  mokmvc.perform(requestbulider);
		        
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response =   andReturn.getResponse();
		int status =  response.getStatus();
		assertEquals(200, status);
	}
	@Test
	public void testDeleteAllRecipe() throws Exception{
	Recipes recipe1 = new Recipes(10,"Curry","NON-VEG","4",true,"potato","Order is Ready");
		
		ObjectMapper mapper = new ObjectMapper();
		String recipejson = mapper.writeValueAsString(recipe1);
		
		MockHttpServletRequestBuilder requestbulider =MockMvcRequestBuilders.delete("/recipe/deleteAll")
								.contentType(MediaType.APPLICATION_JSON)
								.content(recipejson);
		ResultActions perform =  mokmvc.perform(requestbulider);
		        
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response =   andReturn.getResponse();
		int status =  response.getStatus();
		assertEquals(200, status);
	}
}
