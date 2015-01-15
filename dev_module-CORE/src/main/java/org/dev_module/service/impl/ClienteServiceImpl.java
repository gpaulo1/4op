package org.dev_module.service.impl;

import java.util.Date;
import java.util.List;

import javassist.NotFoundException;

import javax.annotation.Resource;

import org.dev_module.BO.FormatarClienteFornecedorBO;
import org.dev_module.dto.ClienteFindMainDTO;
import org.dev_module.dto.FindClienteByNameDTO;
import org.dev_module.model.Cliente;
import org.dev_module.query.ClienteQuery;
import org.dev_module.repository.ClienteRepository;
import org.dev_module.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository repository;

	@Autowired
	private ClienteQuery clienteQuery;

	public List<Cliente> buscarTodos() throws NotFoundException {

		return repository.findAll();

	}

	public List<Cliente> buscarTodos(Predicate condicao)
			throws NotFoundException {

		if (condicao == null) {
			throw new NotFoundException(
					"Condição de busco do cliente está nullo!");
		}

		return repository.findAll();
	}
	
	public Cliente salvar(Cliente cliente) throws Exception {

		if (cliente == null) {
			throw new Exception("Objeto cliente está nullo!");
		}

		cliente.setDataCadastro(new Date());
		cliente.setStatus(true);

		return repository.save(FormatarClienteFornecedorBO
				.formatInputs(cliente));

	}

	public void excluir(Long id) throws NotFoundException {

		if (id == null) {
			throw new NotFoundException("Identificador do cliente está nullo!");
		}

		Cliente retorno = this.buscasRegistro(id);
		retorno.setStatus(false);

		repository.save(retorno);

	}

	public Cliente buscasRegistro(Long idCliente) throws NotFoundException {
		if (idCliente == null) {
			throw new NotFoundException(
					"O identificador do cliente está nullo!");
		}

		return repository.findOne(idCliente);

	}

	public Cliente buscasRegistro(Predicate condicao) throws NotFoundException {

		if (condicao == null) {
			throw new NotFoundException(
					"A condição de busca do cliente está nullo!");
		}

		return repository.findOne(condicao);
	}

	public List<ClienteFindMainDTO> buscarClientesToShow()
			throws NotFoundException {
		return clienteQuery.findLast10Clientes();
	}

	public List<ClienteFindMainDTO> filterAllClientes()
			throws NotFoundException {

		return clienteQuery.filterAllClientes();

	}

	public List<ClienteFindMainDTO> filterAllEmpresas()
			throws NotFoundException {
		return clienteQuery.filterAllEmpresas();
	}

	public List<FindClienteByNameDTO> filterByName(String value) throws NotFoundException {
		return clienteQuery.findByName(value);
	}
	
}
