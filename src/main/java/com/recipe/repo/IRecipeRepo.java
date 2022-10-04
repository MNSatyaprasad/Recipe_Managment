package com.recipe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.entity.Recipes;

public interface IRecipeRepo extends JpaRepository<Recipes, Integer>{

	public List<Recipes> findByType(String type);
	
}
