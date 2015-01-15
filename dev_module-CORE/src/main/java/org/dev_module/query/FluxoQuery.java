package org.dev_module.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dev_module.dto.FluxoDeDadosDTO;
import org.dev_module.model.Caixa;
import org.dev_module.model.Fluxo;
import org.dev_module.model.QFluxo;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;

@Service
public class FluxoQuery {

	@PersistenceContext
	private EntityManager em;

	public List<FluxoDeDadosDTO> buscar30UltimosFluxosDeCaixa(Long pCaixaId) {

		JPAQuery query = new JPAQuery(em);

		QFluxo fluxoP = QFluxo.fluxo;

		return query
				.from(fluxoP)
				.where(fluxoP.caixa.id.eq(pCaixaId))
				.list(Projections.fields(FluxoDeDadosDTO.class, fluxoP.id,
						fluxoP.descricao, fluxoP.valor, fluxoP.valorFinal));

	}

}
