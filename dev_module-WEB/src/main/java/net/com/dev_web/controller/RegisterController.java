package net.com.dev_web.controller;

import javassist.NotFoundException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.com.dev_web.mail.SendMailRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dev_module.model.User;
import com.dev_module.predicate.UserPredicate;
import com.dev_module.service.UserService;

@Controller
public class RegisterController extends WebMvcConfigurerAdapter {

	private static final String RETURN_REGISTER_PAGE = "bootstrap.definition";
	private static final String REDIRECT_REGISTER_PAGE = "redirect:/register-page";
	private static final String REDIRECT_DASHBOARD = "redirect:dashboard";
	
	@Autowired
	private UserService userService;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@RequestMapping(value = "register-page")
	public ModelAndView index() {

		ModelAndView view = new ModelAndView(RETURN_REGISTER_PAGE);
		view.addObject("user", new User());
		
		return view;

	}

	@RequestMapping(value = "create-user", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("user") @Valid User user,
			RedirectAttributes redirect, BindingResult result, HttpSession session) {
		ModelAndView view = new ModelAndView(REDIRECT_DASHBOARD);

		Boolean regressUsername = userService.registerUser(UserPredicate
				.findByUser(user.getUserName()));
		Boolean regressEmail = userService.registerUser(UserPredicate
				.findByEmail(user.getEmail()));

		User regressUserSave = new User();
		
		if (regressEmail && regressUsername) {
			view = new ModelAndView(RETURN_REGISTER_PAGE);
			view.addObject("statusMsg", "/unavaible");
			view.addObject("msg", "Usuário e email já cadastrado no sistema.");

			user.setPassword(null);
			view.addObject("user", user);

			return view;
		}

		if (regressUsername) {
			view = new ModelAndView(RETURN_REGISTER_PAGE);
			view.addObject("statusMsg", "unavaible");
			view.addObject("msg", "Usuário já cadastrado no sistema.");

			user.setPassword(null);
			view.addObject("user", user);

			return view;
		}

		if (regressEmail) {
			view = new ModelAndView(RETURN_REGISTER_PAGE);
			view.addObject("statusMsg", "unavaible");
			view.addObject("msg", "Email já cadastrado no sistema.");

			user.setPassword(null);
			view.addObject("user", user);

			return view;
		}

		try {
			
			regressUserSave = userService.save(user);
			
		} catch (Exception e) {
			
			view = new ModelAndView(REDIRECT_REGISTER_PAGE);
			view.addObject("msg","Ocorreu um erro no sistema");
			return view;
			
		}

		SendMailRegister email = new SendMailRegister();
		email.send(user);
		
		session.setAttribute("user", regressUserSave.getUserName());
		session.setMaxInactiveInterval(60*30);
		session.setAttribute("idV", regressUserSave.getId());
		
		return view;
	}
	

	@RequestMapping(value = "request-login/{email}/{password}")
	public @ResponseBody String login(@RequestBody @PathVariable("email") String email, @PathVariable("password") String password, HttpSession session) {

		User userRegress = null;
		
		try {
			
			userRegress = userService.findLoginUser(UserPredicate.findUserLogin(email, password));
			
		} catch (NotFoundException e) {
			
			e.printStackTrace();
			return "denied";
			
		}

		session.setAttribute("user", userRegress.getUserName());
		session.setAttribute("idV", userRegress.getId());
		session.setMaxInactiveInterval(60*30);
		
		return "accepted";

	}

	@RequestMapping(value = "logout")
	public ModelAndView logout(HttpSession session){
		
		ModelAndView view = new ModelAndView(REDIRECT_REGISTER_PAGE);
		session.setAttribute("user", null);
		return view;
	}
	
}
