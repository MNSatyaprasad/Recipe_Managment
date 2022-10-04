package com.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.entity.Users;
import com.recipe.repo.IUsersRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUsersRepo userrepo;
	@Override
	public Users addUser(Users user) {
		Users saveUser = userrepo.save(user);
		return saveUser;
	}

}
