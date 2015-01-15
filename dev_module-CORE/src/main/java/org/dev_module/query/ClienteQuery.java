package org.dev_module.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dev_module.dto.ClienteFindMainDTO;
import org.dev_module.dto.FindClienteByNameDTO;
import org.dev_module.model.QCliente;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

@Service
public class ClienteQuery {

	@PersistenceContext
	private EntityManager em;

	public List<ClienteFindMainDTO> findLast10Clientes() {
		QCliente condition = QCliente.cliente;

		JPAQuery query = new JPAQuery(em);

		return query
				.from(condition)
				.orderBy(condition.id.desc())
				.where(condition.status.eq(true))
				.limit(10)
				.list(Projections.fields(ClienteFindMainDTO.class,
						condition.cnpj, condition.cpf, condition.tipoPessoa,
						condition.nome, condition.fantasia, condition.telefone,
						condition.id));

	}

	public List<ClienteFindMainDTO> filterAllClientes() {

		QCliente condition = QCliente.cliente;

		JPAQuery query = new JPAQuery(em);

		return query
				.from(condition)
				.orderBy(condition.id.desc())
				.where(condition.tipoPessoa.eq("FISICA"))
				.list(Projections.fields(ClienteFindMainDTO.class,
						condition.cnpj, condition.cpf, condition.tipoPessoa,
						condition.nome, condition.fantasia, condition.telefone,
						condition.id));

	}

	public List<ClienteFindMainDTO> filterAllEmpresas() {

		QCliente condition = QCliente.cliente;

		JPAQuery query = new JPAQuery(em);

		return query
				.from(condition)
				.orderBy(condition.id.desc())
				.where(condition.tipoPessoa.eq("JURIDICA"))
				.list(Projections.fields(ClienteFindMainDTO.class,
						condition.cnpj, condition.cpf, condition.tipoPessoa,
						condition.nome, condition.fantasia, condition.telefone,
						condition.id));

	}

	public List<FindClienteByNameDTO> findByName(String value) {
		QCliente condition = QCliente.cliente;

		value = "%" + value + "%";

		JPAQuery query = new JPAQuery(em);

		return query
				.from(condition)
				.orderBy(condition.id.desc())
				.where(condition.nome.like(value).or(
						condition.fantasia.like(value).or(
								condition.razaoSocial.like(value))))
				.list(Projections.fields(FindClienteByNameDTO.class,
				condition.nome, condition.id));

	}

}
