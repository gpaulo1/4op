package com.dev_module.service;

import java.util.List;

import javassist.NotFoundException;

import com.dev_module.model.User;
import com.mysema.query.types.Predicate;

public interface UserService {

	List<User> findAll();
	
	List<User> findAll(Predicate condition);
	
	User findLoginUser(Predicate condition) throws NotFoundException;
	
	Boolean registerUser(Predicate condition);

	User save(User user) throws Exception;
	
}
