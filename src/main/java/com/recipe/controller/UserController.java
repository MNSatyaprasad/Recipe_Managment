package com.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.entity.Users;
import com.recipe.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userservice;
	
	@PostMapping("/save")
	public ResponseEntity<Users> addUser(@RequestBody Users user){
		Users adduser = userservice.addUser(user);
		return new ResponseEntity<Users>(adduser,HttpStatus.OK);
	}
}
