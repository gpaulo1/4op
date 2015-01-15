package net.com.dev_web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dev_module.dto.ClientMainInfoDTO;
import com.dev_module.model.Client;
import com.dev_module.model.User;
import com.dev_module.service.ClientService;

@Controller
public class ClientController {

	private static final String RETURN_NEW_CLIENTE = "new-client";

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/new-client")
	public ModelAndView index(HttpSession session) {

		ModelAndView view = new ModelAndView();
		view.addObject("clients", clientService.findMainInfo(Long.parseLong(String.valueOf(session.getValue("idV")))));

		return view;

	}

	@RequestMapping(value = "client/save", method = RequestMethod.POST)
	public @ResponseBody Client save(@RequestBody Client client, HttpSession session) {

		User user = new User();
		
		user.setId(Long.parseLong(String.valueOf(session.getValue("idV"))));
		client.setUser(user);
		Client regress = clientService.save(client);

		return regress;

	}
	
	@RequestMapping(value = "client/refresh")
	public @ResponseBody List<ClientMainInfoDTO> refresh(HttpSession session){
		
		return clientService.findMainInfo(Long.parseLong(String.valueOf(session.getValue("idV"))));
		
	}
	
}
