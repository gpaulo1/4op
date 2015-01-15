package org.dev_module.service.impl;

import java.util.Date;
import java.util.List;

import javassist.NotFoundException;

import javax.annotation.Resource;

import org.dev_module.dto.FluxoDeDadosDTO;
import org.dev_module.enumerator.MensagensEnum;
import org.dev_module.model.Fluxo;
import org.dev_module.query.FluxoQuery;
import org.dev_module.repository.FluxoRepository;
import org.dev_module.service.FluxoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.types.Predicate;

public class FluxoServiceImpl implements FluxoService {

	private FluxoRepository repository;

	private FluxoQuery fluxoQuery;

	public List<Fluxo> buscarTodos() throws NotFoundException {

		List<Fluxo> retorno = repository.findAll();

		if (retorno.size() == 0) {
			throw new NotFoundException(
					MensagensEnum.NOT_FOUND_DATA.getMessage());
		}

		return retorno;

	}

	public List<Fluxo> buscarTodos(Predicate condicao) throws NotFoundException {
		List<Fluxo> retorno = repository.findAll();

		if (retorno.size() == 0) {
			throw new NotFoundException(
					MensagensEnum.NOT_FOUND_DATA.getMessage());
		}
		return retorno;
	}

	public Fluxo salvar(Fluxo fluxo) throws Exception {

		if (fluxo == null) {
			throw new Exception("Valor do objeto está nulo");
		}

		fluxo.setData(new Date());

		Fluxo retornoFluxo = repository.save(fluxo);

		return retornoFluxo;
	}

	public void remover(Long id) {
		// TODO Auto-generated method stub

	}

	public Fluxo buscarRegistro(Fluxo fluxo) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public Fluxo buscarRegistro(Predicate condicao) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FluxoDeDadosDTO> buscar30UltimosFluxosDeCaixa(Long pIdCaixa)
			throws NotFoundException {

		if (pIdCaixa == null) {
			throw new NotFoundException("O ID de caixa não pode ser nulo!");
		}

		return fluxoQuery.buscar30UltimosFluxosDeCaixa(pIdCaixa);

	}

}
