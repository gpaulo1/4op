package com.dev_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.dev_module.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>, QueryDslPredicateExecutor<Client> {

}
