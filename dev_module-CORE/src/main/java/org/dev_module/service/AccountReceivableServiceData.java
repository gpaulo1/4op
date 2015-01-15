package org.dev_module.service;

import org.dev_module.dto.findSummaryAccountsDTO;
import org.dev_module.model.AccountReceivable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface AccountReceivableServiceData extends CrudRepository<AccountReceivable, Long>{

	@Query("SELECT SUM(valor c.id FROM Cliente c WHERE LOWER(c.telefone) = LOWER (:telefone)")
	findSummaryAccountsDTO findSummaryAccoutnInformation();
	
}
