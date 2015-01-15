package net.com.dev_web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

	private static final String RETURN_DASHBOARD = "dashboard";
	private static final String REDIRECT_REGISTER_PAGE = "redirect:register-page";

	@RequestMapping(value = "/dashboard")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		ModelAndView view = new ModelAndView(RETURN_DASHBOARD);
		
		return view;
	}

}
