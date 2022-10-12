package com.recipe.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recipe.entity.Users;

public interface IUsersRepo extends JpaRepository<Users, Integer>{
	
    @Query("select u From Users u join u.recipes r where r.ingredients_name = :ingredients_name")
	 List<Users> getPersonsIngredient(String ingredients_name);
}
