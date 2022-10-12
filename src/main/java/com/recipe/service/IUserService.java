package com.recipe.service;

import java.util.List;

import com.recipe.entity.Users;

public interface IUserService {

	public Users addUser(Users user);
	
	public List<Users> getRecipeByIngrediant(String ingredients_name);
}
