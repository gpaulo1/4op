package com.dev_module.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev_module.dto.ClientMainInfoDTO;
import com.dev_module.model.Client;
import com.dev_module.query.ClientQuery;
import com.dev_module.repository.ClientRepository;
import com.dev_module.service.ClientService;
import com.mysema.query.types.Predicate;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientQuery ClientQuery;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public List<Client> findAll(Predicate predicate) {
		return (List<Client>) clientRepository.findAll(predicate);
	}

	public Client save(Client pClient) {
		
		pClient.setDateRegistration(new Date());
		pClient.setStatus("a");
		
		return clientRepository.save(pClient);
	}

	public Client findOne(Long id) {
		return clientRepository.findOne(id);
	}

	public Client findOne(Predicate condition) {
		return clientRepository.findOne(condition);
	}

	public List<ClientMainInfoDTO> findMainInfo(Long idUser) {
		return ClientQuery.findMainInformationOrderByDate(idUser);
	}

}
