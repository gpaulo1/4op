package org.dev_module.query;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dev_module.dto.AccountReceivableDTO;
import org.dev_module.dto.findSummaryAccountsDTO;
import org.dev_module.model.QAccountReceivable;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

@Service
public class AccountReceivableQuery {

	@PersistenceContext
	private EntityManager em;

	public List<AccountReceivableDTO> findAllAccountsOrdeByIdDesc(String tipoConta) {

		QAccountReceivable predicate = QAccountReceivable.accountReceivable;

		JPAQuery query = new JPAQuery(em);

		return query
				.from(predicate)
				.orderBy(predicate.dataVencimento.desc())
				.limit(10)
				.where(predicate.tipoConta.eq(tipoConta))
				.list(Projections.fields(AccountReceivableDTO.class,
						predicate.id, predicate.dataVencimento,
						predicate.valor, predicate.descricao,
						predicate.formaPagamento));

	}

	public List<AccountReceivableDTO> findFilterAccount(String value)
			throws ParseException {

		QAccountReceivable predicate = QAccountReceivable.accountReceivable;

		JPAQuery query = new JPAQuery(em);

		value = "%" + value + "%";

		return query
				.from(predicate)
				.orderBy(predicate.dataVencimento.desc())
				.limit(10)
				.where(predicate.descricao.like(value).or(
						predicate.formaPagamento.like(value)))
				.list(Projections.fields(AccountReceivableDTO.class,
						predicate.id, predicate.dataVencimento,
						predicate.valor, predicate.descricao,
						predicate.formaPagamento));

	}

	public List<findSummaryAccountsDTO> findSummaryAccounts() {

		QAccountReceivable predicate = QAccountReceivable.accountReceivable;
		QAccountReceivable subquery = new QAccountReceivable("new");

		JPAQuery query = new JPAQuery(em);
		JPASubQuery subQuery = new JPASubQuery();

		subQuery.from(predicate).list(predicate.id);

		return query
				.from(predicate)
				.where(predicate.status.eq("EM_ABERTO"))
				.list(Projections.fields(findSummaryAccountsDTO.class,
						predicate.valor.sum().as("Value one"), predicate
								.count().as("Value two")));

	}
}
