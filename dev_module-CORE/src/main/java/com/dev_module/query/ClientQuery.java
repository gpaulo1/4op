package com.dev_module.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.dev_module.dto.ClientMainInfoDTO;
import com.dev_module.model.QClient;
import com.dev_module.model.QUser;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

@Service
public class ClientQuery {

	@PersistenceContext
	private EntityManager em;

	public List<ClientMainInfoDTO> findMainInformationOrderByDate(Long idUser) {

		QClient predicate = QClient.client;
		QUser userPredicate = QUser.user;

		JPAQuery query = new JPAQuery(em);

		return query
				.from(predicate)
				.innerJoin(predicate.user, userPredicate)
				.orderBy(predicate.id.desc())
				.where(predicate.user.id.eq(idUser).and(
						predicate.status.eq("a")))
				.limit(10)
				.list(Projections.fields(ClientMainInfoDTO.class, predicate.id,
						predicate.email, predicate.cpfCnpj, predicate.name,
						predicate.workPhone, predicate.dateRegistration));

	}

}
