package com.dev_module.service;

import java.util.List;

import com.dev_module.dto.ClientMainInfoDTO;
import com.dev_module.model.Client;
import com.mysema.query.types.Predicate;

public interface ClientService {

	List<Client> findAll();
	
	List<Client> findAll(Predicate predicate);
	
	List<ClientMainInfoDTO> findMainInfo(Long idUser);
	
	Client save(Client pClient);
	
	Client findOne(Long id);
	
	Client findOne(Predicate condition);
	
}
