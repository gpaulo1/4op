package org.dev_module.service;

import org.dev_module.model.User;

public interface UserService {

	User findByUserName(String username);
	
}
