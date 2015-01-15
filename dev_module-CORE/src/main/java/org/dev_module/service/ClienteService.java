package org.dev_module.service;

import java.util.List;

import javassist.NotFoundException;

import org.dev_module.dto.ClienteFindMainDTO;
import org.dev_module.dto.FindClienteByNameDTO;
import org.dev_module.model.Cliente;

import com.mysema.query.types.Predicate;

public interface ClienteService {

	List<Cliente> buscarTodos() throws NotFoundException;

	List<ClienteFindMainDTO> buscarClientesToShow() throws NotFoundException;
	
	List<ClienteFindMainDTO> filterAllClientes() throws NotFoundException;
	
	List<ClienteFindMainDTO> filterAllEmpresas() throws NotFoundException;
	
	List<FindClienteByNameDTO> filterByName(String value) throws NotFoundException;

	List<Cliente> buscarTodos(Predicate condicao) throws NotFoundException;

	Cliente salvar(Cliente cliente) throws Exception;

	void excluir(Long id) throws NotFoundException;

	Cliente buscasRegistro(Long idCliente) throws NotFoundException;

	Cliente buscasRegistro(Predicate condicao) throws NotFoundException;

}


