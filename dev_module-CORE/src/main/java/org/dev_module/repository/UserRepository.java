package org.dev_module.repository;

import org.dev_module.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long>,
		QueryDslPredicateExecutor<User> {

}
