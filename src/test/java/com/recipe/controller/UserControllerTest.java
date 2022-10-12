package com.recipe.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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
import com.recipe.entity.Users;
import com.recipe.service.UserServiceImpl;
@WebMvcTest(value = UserController.class)
class UserControllerTest {
	
	@MockBean
	private UserServiceImpl userService;
	@Autowired
	private MockMvc mockmvc;

	@Test
	public void testAddUser() throws Exception{
		
		Users users = new Users();
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(users);
		
		MockHttpServletRequestBuilder requestbulider =MockMvcRequestBuilders.post("/user/save")
								.contentType(MediaType.APPLICATION_JSON)
								.content(userJson);
		
		 ResultActions perform =  mockmvc.perform(requestbulider);
		        
		 MvcResult andReturn = perform.andReturn();
	     MockHttpServletResponse response =   andReturn.getResponse();
	     int status =  response.getStatus();
		 assertEquals(200, status);  
		
	}
	@Test
	public void testGetPersonWithRecipeOfIngrediant() throws Exception{
		Users users = new Users();
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(users);
		
		MockHttpServletRequestBuilder requestbulider =MockMvcRequestBuilders.get("/user/Chicken")
								.contentType(MediaType.APPLICATION_JSON)
								.content(userJson);
		
		 ResultActions perform =  mockmvc.perform(requestbulider);
		        
		 MvcResult andReturn = perform.andReturn();
	     MockHttpServletResponse response =   andReturn.getResponse();
	     int status =  response.getStatus();
		 assertEquals(200, status);  
		
	}

}
