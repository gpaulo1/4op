package net.com.dev_web.controller;

import org.dev_module.CORE.App;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IntegrationController {

	private static final String RETURN_OFERTA = "oferta";
	
	@RequestMapping(value = "/test")
	public ModelAndView index() {
		ModelAndView  view = new ModelAndView("index");
		
		System.out.println("aquuuuuuuuuuu");
		
		App app = new App();
		view.addObject("App", app);
		return view;
	}
	
	@RequestMapping(value = "oferta", method = RequestMethod.POST)
	public ModelAndView oferta(@ModelAttribute("app") App app, BindingResult result){
		ModelAndView view = new ModelAndView(RETURN_OFERTA);
		view.addObject("oferta", app);
		return view;
	}
	
}
