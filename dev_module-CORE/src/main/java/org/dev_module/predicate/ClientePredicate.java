package org.dev_module.predicate;

import org.dev_module.model.QCliente;

import com.mysema.query.types.Predicate;

public class ClientePredicate {

	public static Predicate findByName(String value) {
		QCliente condition = QCliente.cliente;

		return condition.nome.eq("%" + value)
				.or(condition.razaoSocial.eq("%" + value))
				.or(condition.fantasia.eq("%" + value));

	}

}
