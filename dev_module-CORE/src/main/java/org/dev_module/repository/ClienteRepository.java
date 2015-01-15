package org.dev_module.repository;

import org.dev_module.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, QueryDslPredicateExecutor<Cliente>{

}
