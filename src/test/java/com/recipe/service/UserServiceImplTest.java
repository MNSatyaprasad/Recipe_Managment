package com.recipe.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.recipe.entity.Recipes;
import com.recipe.entity.Users;
import com.recipe.repo.IUsersRepo;
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

	
	@Mock
	private IUsersRepo userRepo;
	
	@InjectMocks
	private UserServiceImpl userservice;
	
	@Test
	public void testAddUser() throws Exception{
		
		Users actual = new Users();
		when(userRepo.save(actual)).thenReturn(actual);
		
		Users expected = userservice.addUser(actual);
		assertEquals(expected, actual);
	}
	@Test
	public void testGetRecipeByIngrediant() throws Exception {
		String ingredients_name = "Potato";
		
		List<Users> users = new ArrayList<>();
		when(userRepo.getPersonsIngredient(ingredients_name)).thenReturn(users);
		
		assertEquals(userservice.getRecipeByIngrediant("Potato"), users);
		
		
	}
	



}
