package org.dev_module.service;

import java.util.List;

import javassist.NotFoundException;

import org.dev_module.model.Caixa;

import com.mysema.query.types.Predicate;

public interface CaixaService {

	List<Caixa> buscarTodos() throws NotFoundException;

	List<Caixa> buscarTodos(Predicate condicao) throws NotFoundException;

	Caixa salvar(Caixa caixa)throws Exception ;

	void remover(Long id) throws NotFoundException;

	Caixa buscarRegistro(Caixa caixa) throws NotFoundException;

	Caixa buscarRegistro(Predicate condicao) throws NotFoundException;

}
