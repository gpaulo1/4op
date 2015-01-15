package org.dev_module.predicate;

import org.dev_module.model.QUser;

import com.mysema.query.types.Predicate;

public class UserPredicate {

	public static Predicate buscarPorUsername(String username) {
		QUser predicate = QUser.user;
		return predicate.username.eq(username);
	}

}
