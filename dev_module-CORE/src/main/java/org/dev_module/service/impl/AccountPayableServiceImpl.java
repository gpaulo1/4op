package org.dev_module.service.impl;

import java.util.List;

import org.dev_module.dto.AccountReceivableDTO;
import org.dev_module.query.AccountPayableQuery;
import org.dev_module.service.AccountPayableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class AccountPayableServiceImpl implements AccountPayableService {
	private AccountPayableQuery query;

	public List<AccountReceivableDTO> findLast10RegisterActive()
			throws Exception {

		List<AccountReceivableDTO> retorno = query.findAllAccountsOrdeByIdDesc();

		if (retorno.size() == 0) {
			throw new Exception("A busca não retornou nenhum registro!");
		}

		return retorno;

	}

}
