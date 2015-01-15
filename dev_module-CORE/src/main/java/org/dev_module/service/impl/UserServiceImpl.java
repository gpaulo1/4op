package org.dev_module.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dev_module.model.User;
import org.dev_module.predicate.UserPredicate;
import org.dev_module.repository.UserRepository;
import org.dev_module.service.UserService;
import org.springframework.stereotype.Service;

public class UserServiceImpl implements UserService {

	private UserRepository repository;

	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		
		users = (List<User>) repository.findAll(UserPredicate.buscarPorUsername(username));

		System.out.println("teste: " + users.get(0).getUserRole().size());
		
		return users.get(0);
	}

}
