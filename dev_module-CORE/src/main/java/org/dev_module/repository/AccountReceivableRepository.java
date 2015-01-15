package org.dev_module.repository;

import org.dev_module.model.AccountReceivable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AccountReceivableRepository extends JpaRepository<AccountReceivable, Long>, QueryDslPredicateExecutor<AccountReceivable>{

	
	
}
