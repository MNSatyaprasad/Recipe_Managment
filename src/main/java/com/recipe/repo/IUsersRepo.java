package com.recipe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.entity.Users;

public interface IUsersRepo extends JpaRepository<Users, Integer>{

	 
}
