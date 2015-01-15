package com.dev_module.predicate;

import com.dev_module.model.QUser;
import com.mysema.query.types.Predicate;

public class UserPredicate {

	public static Predicate findByUser(String username) {
		QUser predicate = QUser.user;
		return predicate.userName.eq(username);
	}

	public static Predicate findByEmail(String email){
		QUser predicate = QUser.user;
		return predicate.email.eq(email);
	}
	
	public static Predicate findUserLogin(String email, String password){
		QUser predicate = QUser.user;
		return predicate.email.eq(email).and(predicate.password.eq(password));
	}
	
}
