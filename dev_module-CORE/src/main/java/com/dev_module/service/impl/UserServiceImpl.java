package com.dev_module.service.impl;

import java.util.Date;
import java.util.List;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev_module.model.User;
import com.dev_module.repository.UserRepository;
import com.dev_module.service.UserService;
import com.mysema.query.types.Predicate;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll(Predicate condition) {

		return (List<User>) userRepository.findAll(condition);

	}

	public Boolean registerUser(Predicate condition) {

		List<User> regress = (List<User>) userRepository.findAll(condition);

		if (regress.size() <= 0) {
			return false;
		}

		return true;

	}

	public User save(User user) throws Exception {

		user.setDateRegister(new Date());
		user.setStatus('t');
		
		User regress = null;

		try {
			regress = userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return regress;

	}

	public User findLoginUser(Predicate condition) throws NotFoundException {

		User regress = userRepository.findOne(condition);

		if (regress == null) {
			throw new NotFoundException("Usuário não cadastrado no sistema");
		}

		return regress;

	}

}
