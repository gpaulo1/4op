package net.com.dev_web.controller;

import java.util.List;

import javassist.NotFoundException;

import org.dev_module.dto.ClienteFindMainDTO;
import org.dev_module.enumerator.MensagensEnum;
import org.dev_module.model.Cliente;
import org.dev_module.model.User;
import org.dev_module.predicate.ClientePredicate;
import org.dev_module.query.ClienteQuery;
import org.dev_module.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.ls.LSInput;

@Controller
public class ClienteController {

	private static final String RETURN_NOVO_CLIENTE = "novo-cliente";
	private static final String RETURN_LISTAR_CLIENTE = "listar-cliente";
	private static final String REDIRECT_NOVO_CLIENTE = "redirect:/cliente/novo";
	private static final String REDIRECT_LISTAR_CLIENTE = "redirect:/cliente/listar";
	
	private ClienteService clienteService;

	@RequestMapping(value = "cliente/novo")
	public ModelAndView novoCliente() {
		ModelAndView view = new ModelAndView(RETURN_NOVO_CLIENTE);
		view.addObject("cliente", new Cliente());
		return view;
	}

	@RequestMapping(value = "cliente/salvar", method = RequestMethod.POST)
	public @ResponseBody ModelAndView salvar(@RequestBody Cliente cliente,
			RedirectAttributes redirect) {
		ModelAndView view = new ModelAndView(REDIRECT_NOVO_CLIENTE);

		System.out.println("passou cliente salvar");
		
		try {
			clienteService.salvar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return view;
	}

	@RequestMapping(value = "cliente/find-clientes")
	public @ResponseBody List<ClienteFindMainDTO> listarCliente() throws NotFoundException {

		List<ClienteFindMainDTO> clientes = clienteService.filterAllClientes();

		return clientes;
	}
	
	@RequestMapping(value = "cliente/find-empresas")
	public @ResponseBody List<ClienteFindMainDTO> listarEmpresas() throws NotFoundException {

		List<ClienteFindMainDTO> clientes = clienteService.filterAllEmpresas();

		return clientes;
	}
	
	@RequestMapping(value = "cliente/find-all")
	public @ResponseBody List<ClienteFindMainDTO> listarTodos() throws NotFoundException {

		List<ClienteFindMainDTO> clientes = clienteService.buscarClientesToShow();
		System.out.println("telefone: " + clientes.get(0).getTelefone());

		return clientes;
	}
	
	@RequestMapping(value = "cliente/listar")
	public ModelAndView listar() throws NotFoundException {
		ModelAndView view = new ModelAndView(RETURN_LISTAR_CLIENTE);

		view.addObject("clientes", clienteService.buscarClientesToShow());

		return view;
	}

	@RequestMapping(value = "cliente/desativar/{id}")
	public @ResponseBody void remover(@RequestBody @PathVariable("id") Long id,
			RedirectAttributes redirect) {

		try {
			clienteService.excluir(id);
		} catch (NotFoundException e) {
			redirect.addFlashAttribute("msg",
					MensagensEnum.MSG_ERROR.getMessage());
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "cliente/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id,
			RedirectAttributes redirect) throws NotFoundException {
		ModelAndView view = new ModelAndView(RETURN_NOVO_CLIENTE);
		view.addObject("cliente", clienteService.buscasRegistro(id));
		return view;
	}
	
	@RequestMapping(value = "cliente/find-by-name/{value}")
	public @ResponseBody List<ClienteFindMainDTO> findByName(@RequestBody @PathVariable("value") String value) throws NotFoundException{
		
//		List<ClienteFindMainDTO> teste = clienteService.filterByName(value);
		
//		System.out.println("aofoaf: " + teste.get(0).getNome());
		
		return null;
		
	}

}
