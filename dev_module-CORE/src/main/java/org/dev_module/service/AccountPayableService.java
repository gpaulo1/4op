package org.dev_module.service;

import java.util.List;

import org.dev_module.dto.AccountReceivableDTO;

public interface AccountPayableService {

	List<AccountReceivableDTO> findLast10RegisterActive() throws Exception;
	
}
