package org.dev_module.repository;

import org.dev_module.model.Fluxo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface FluxoRepository extends JpaRepository<Fluxo, Long>,
		QueryDslPredicateExecutor<Fluxo> {

}
