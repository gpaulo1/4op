package org.dev_module.repository;

import org.dev_module.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface CaixaRepository extends JpaRepository<Caixa, Long>,
		QueryDslPredicateExecutor<Caixa> {

}
