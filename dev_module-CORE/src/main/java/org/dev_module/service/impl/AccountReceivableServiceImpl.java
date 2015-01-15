package org.dev_module.service.impl;

import java.util.List;

import org.dev_module.dto.AccountReceivableDTO;
import org.dev_module.dto.findSummaryAccountsDTO;
import org.dev_module.model.AccountReceivable;
import org.dev_module.query.AccountReceivableQuery;
import org.dev_module.repository.AccountReceivableRepository;
import org.dev_module.service.AccountReceivableService;
import org.dev_module.service.GerarParcelasI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

public class AccountReceivableServiceImpl implements AccountReceivableService {

	private AccountReceivableRepository repository;

	private GerarParcelasI gerarParcelas;
	
	private AccountReceivableQuery accountQuery;

	public List<AccountReceivable> buscarTodos() throws Exception {

		List<AccountReceivable> retornos = repository.findAll();

		if (retornos.size() < 1) {
			throw new Exception(
					"AccountReceivable não escontrou nenhum registro!");
		}

		return retornos;

	}

	public List<AccountReceivableDTO> buscarTodosOrderById(String tipoConta) throws Exception {

		List<AccountReceivableDTO> returns = accountQuery
				.findAllAccountsOrdeByIdDesc(tipoConta);

		if (returns.size() == 0) {
			throw new Exception(
					"AccountReceivable não escontrou nenhum registro!");
		}

		return returns;

	}

	public List<AccountReceivableDTO> findFilterAccount(String value)
			throws Exception {
		
		List<AccountReceivableDTO> returns = accountQuery
				.findFilterAccount(value);

		if (returns.size() == 0) {
			throw new Exception(
					"AccountReceivable não escontrou nenhum registro!");
		}

		return returns;
	}
	
	
	public List<findSummaryAccountsDTO> findSummaryAccounts() throws Exception {

		List<findSummaryAccountsDTO> retorno = accountQuery
				.findSummaryAccounts();

		if (retorno.size() < 1) {
			throw new Exception(
					"AccountReceivableSummary não escontrou nenhum registro!");
		}

		return retorno;

	}

	public List<AccountReceivable> buscarTodos(Predicate condicao)
			throws Exception {

		List<AccountReceivable> retornos = (List<AccountReceivable>) repository
				.findAll(condicao);

		if (retornos.size() < 1) {
			throw new Exception(
					"AccountReceivable não escontrou nenhum registro!");
		}

		return retornos;

	}

	public AccountReceivable salvar(AccountReceivable account) throws Exception {

		if (account == null) {
			throw new Exception("Não é possível salvar um objeto nullo!");
		}
		
		if(account.getCliente().getId() == null){
			account.setCliente(null);
		}
		
		if(account.getOcorrencia().equals("PARCELADO")){
			gerarParcelas.gerarParcelas(account.getValor(), account.getDataVencimento(), account.getQuantidadeParcela());
		}

		account.setStatus("EM_ABERTO");

		return repository.save(account);

	}

	public void remover(Long id) throws Exception {

		if (id == null) {
			throw new Exception("Identificador do objeto está nullo!");
		}

		repository.delete(id);

	}

	public AccountReceivable buscarRegistro(Long account) throws Exception {

		if (account == null) {
			throw new Exception("Objeto de pesquisa está nulo!");
		}

		return repository.findOne(account);

	}

	public AccountReceivable buscarRegistro(Predicate condicao)
			throws Exception {

		if (condicao == null) {
			throw new Exception("Objeto de pesquisa está nulo!");
		}

		return repository.findOne(condicao);
	}

}
