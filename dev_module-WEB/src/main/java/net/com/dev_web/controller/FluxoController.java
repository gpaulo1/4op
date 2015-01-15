package net.com.dev_web.controller;

import org.dev_module.model.Fluxo;
import org.dev_module.service.FluxoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FluxoController {
	
	private FluxoService fluxoService;

	@RequestMapping(value = "fluxo/salvar-registro", method = RequestMethod.POST)
	public @ResponseBody Fluxo salvarRegistro(@RequestBody Fluxo fluxo){
		System.out.println("Fluxo value: " + fluxo.getId());
		
		Fluxo fluxoRetorno = new Fluxo();
		
		try {
			fluxoRetorno = fluxoService.salvar(fluxo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fluxoRetorno;
	}
	
}
