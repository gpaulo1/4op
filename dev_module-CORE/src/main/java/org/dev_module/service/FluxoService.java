package org.dev_module.service;

import java.util.List;

import javassist.NotFoundException;

import org.dev_module.dto.FluxoDeDadosDTO;
import org.dev_module.model.Fluxo;

import com.mysema.query.types.Predicate;

public interface FluxoService {

	List<Fluxo> buscarTodos() throws NotFoundException;

	List<Fluxo> buscarTodos(Predicate condicao) throws NotFoundException;
	
	List<FluxoDeDadosDTO> buscar30UltimosFluxosDeCaixa(Long pIdCaixa) throws NotFoundException;

	Fluxo salvar(Fluxo fluxo) throws Exception;

	void remover(Long id);

	Fluxo buscarRegistro(Fluxo fluxo) throws NotFoundException;

	Fluxo buscarRegistro(Predicate condicao) throws NotFoundException;

}
