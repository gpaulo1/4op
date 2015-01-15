package net.com.dev_web.controller;

import org.dev_module.enumerator.PropriedadeSistema;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static final String RETURN_LOGIN = "login";
	
	@RequestMapping(value = "/login")
	public ModelAndView login(){
		
		ModelAndView view = new ModelAndView(RETURN_LOGIN);
		view.addObject("nomeSistema", PropriedadeSistema.nomeSistema);
		return view;
		
	}
	
}
