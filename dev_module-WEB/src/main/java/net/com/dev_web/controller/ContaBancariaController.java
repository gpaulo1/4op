package net.com.dev_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContaBancariaController {

	private static final String RETURN_CONTA_BANCARIA = "conta-bancaria";
	
	@RequestMapping(value = "conta-bancaria")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView(RETURN_CONTA_BANCARIA);
		
		return view;
	}
	
	@RequestMapping(value = "conta-bancaria/nova")
	public ModelAndView nova() {
		
		ModelAndView view = new ModelAndView();
		
		
		return view;
		
	}
	
}
