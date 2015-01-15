package net.com.dev_web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javassist.NotFoundException;

import org.dev_module.dto.AccountReceivableDTO;
import org.dev_module.dto.FindClienteByNameDTO;
import org.dev_module.model.AccountReceivable;
import org.dev_module.query.AccountReceivableQuery;
import org.dev_module.service.AccountReceivableService;
import org.dev_module.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccountReceivableController {

	private static final String RETURN_ACCOUNT_RECEIVABLE = "account-receivable";
	private static final String RETURN_NEW_ACCOUNT_RECEIVABLE = "new-account-receivable";
	private static final String REDIRECT_ACCOUNT_RECEIVABLE = "redirect:/account-receivable";
	private static final String REDIRECT_ACCOUNT_RECEIVABLE_NEW = "redirect:/account-receivable/new";
	private static final String REDIRECT_ACCOUNT_PAYABLE = "redirect:/account-payable";

	private AccountReceivableService accountService;

	private ClienteService clienteService;

	private AccountReceivableQuery accountQuery;

	@RequestMapping(value = "/account-receivable", method = RequestMethod.GET)
	public ModelAndView summary() {

		ModelAndView view = new ModelAndView(RETURN_ACCOUNT_RECEIVABLE);

		try {
			view.addObject("accounts", accountService.buscarTodosOrderById("A_RECEBER"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return view;
	}

	@RequestMapping(value = "account-receivable/new")
	public ModelAndView newAccount(RedirectAttributes redirect) {
		ModelAndView view = new ModelAndView(RETURN_NEW_ACCOUNT_RECEIVABLE);

		AccountReceivable account = new AccountReceivable();
		account.setTipoConta("A_RECEBER");
		
		view.addObject("account", account);
		view.addObject("dataAtual",
				new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(calendar.DAY_OF_MONTH, +10);

		view.addObject("dataVencimento",
				new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));

		return view;

	}

	@RequestMapping(value = "account-receivable/save", method = RequestMethod.POST)
	public ModelAndView salvar(@RequestBody AccountReceivable account,
			RedirectAttributes redirect) {

		ModelAndView view = new ModelAndView();
		
		if (account.getTipoConta().equals("A_PAGAR")) {
			view = new ModelAndView(REDIRECT_ACCOUNT_PAYABLE);
		} else {
			view = new ModelAndView(REDIRECT_ACCOUNT_RECEIVABLE);
		}

		if (account.getId() == null) {
			redirect.addFlashAttribute("msg",
					"Registro cadastrado com sucesso!");
		} else {
			redirect.addFlashAttribute("msg",
					"Registro editado com sucesso!");
		}
		
		try {
			accountService.salvar(account);

		} catch (Exception e) {

			// view.addObject(RETURN_NEW_ACCOUNT_RECEIVABLE);
			// view.addObject("msg",
			// "Ocorreu um erro ao salvar registro de entrada!");
			e.printStackTrace();

		}
		return view;

	}

	@RequestMapping(value = "account-receivable/buscar-cliente/{nome}")
	public @ResponseBody List<FindClienteByNameDTO> buscarCliente(
			@RequestBody @PathVariable("nome") String nome) {

		List<FindClienteByNameDTO> clientes = new ArrayList<FindClienteByNameDTO>();

		try {

			clientes = clienteService.filterByName(nome);
			System.out.println("Cliente id: " + clientes.get(0).getId());
		} catch (NotFoundException e) {

			e.printStackTrace();

		}
		return clientes;
	}

	@RequestMapping(value = "account-receivable/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id,
			RedirectAttributes redirect) {

		ModelAndView view = new ModelAndView();

		
		
		return view;

	}

	@RequestMapping(value = "account-receivable/search/{value}")
	public @ResponseBody List<AccountReceivableDTO> searchAccount(
			@PathVariable("value") String value) {

		List<AccountReceivableDTO> retorno = new ArrayList<AccountReceivableDTO>();

		try {
			retorno = accountService.findFilterAccount(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retorno;

	}

	@RequestMapping(value = "account-receivable/listar/{id}")
	public ModelAndView listar(@PathVariable("id") Long id,
			RedirectAttributes redirect) {

		ModelAndView view = new ModelAndView(RETURN_NEW_ACCOUNT_RECEIVABLE);

		AccountReceivable retorno = new AccountReceivable();

		try {

			retorno = accountService.buscarRegistro(id);

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		view.addObject("account", retorno);

		return view;
	}

}
