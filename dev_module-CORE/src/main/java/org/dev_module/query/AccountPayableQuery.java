package org.dev_module.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dev_module.dto.AccountReceivableDTO;
import org.dev_module.model.QAccountReceivable;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

@Service
public class AccountPayableQuery {

	@PersistenceContext
	private EntityManager em;

	public List<AccountReceivableDTO> findAllAccountsOrdeByIdDesc() {

		QAccountReceivable predicate = QAccountReceivable.accountReceivable;

		JPAQuery query = new JPAQuery(em);

		return query
				.from(predicate)
				.orderBy(predicate.dataVencimento.desc())
				.limit(10)
				.where(predicate.status.eq("EM_ABERTO"), predicate.tipoConta.eq("A_PAGAR"))
				.list(Projections.fields(AccountReceivableDTO.class,
						predicate.id, predicate.dataVencimento,
						predicate.valor, predicate.descricao,
						predicate.formaPagamento));

	}
	
}
