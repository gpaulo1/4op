package net.com.dev_web.controller;

import java.util.ArrayList;
import java.util.List;

import javassist.NotFoundException;

import org.dev_module.dto.FluxoDeDadosDTO;
import org.dev_module.model.Caixa;
import org.dev_module.model.Fluxo;
import org.dev_module.service.CaixaService;
import org.dev_module.service.FluxoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanejamentoFinanceiroController {

	private static final String RETURN_PLANEJAMENTO = "planejamento";

	private CaixaService caixaService;

	private FluxoService fluxoService;

	@RequestMapping(value = "/planejamento")
	public ModelAndView planejamentoFinanceiro() {
		ModelAndView view = new ModelAndView(RETURN_PLANEJAMENTO);

		System.out.println("Entrou!");

		try {
			view.addObject("caixas", caixaService.buscarTodos());
			view.addObject("fluxos", fluxoService.buscarTodos());
		} catch (Exception e) {

		}

		return view;
	}

	@RequestMapping(value = "/planejamento/novo-caixa", method = RequestMethod.POST)
	public @ResponseBody Caixa novoCaixa(@RequestBody Caixa caixa) {

		Caixa retorno = new Caixa();

		System.out.println("ajdnfijadfihi: afjaoidjf");

		try {
			caixa.setEnabled(true);
			retorno = caixaService.salvar(caixa);
		} catch (Exception e) {
		}
		return retorno;
	}

	@RequestMapping(value = "/planejamento/novo-registro", method = RequestMethod.POST)
	public @ResponseBody Fluxo novoRegistro(@RequestBody Fluxo fluxo) {

		Fluxo retorno = new Fluxo();
		try {
			retorno = fluxoService.salvar(fluxo);
		} catch (Exception e) {
		}
		return retorno;

	}

	@RequestMapping(value = "/planejamento/buscar-fluxo/{id}")
	public @ResponseBody List<FluxoDeDadosDTO> getFluxo(
			@RequestBody @PathVariable("id") Long id) throws NotFoundException {
		System.out.println("entrou: " + id);

		List<FluxoDeDadosDTO> retorno = new ArrayList<FluxoDeDadosDTO>();

		retorno = fluxoService.buscar30UltimosFluxosDeCaixa(id);

		return retorno;

	}

}
