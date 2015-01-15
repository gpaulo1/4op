package net.com.dev_web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.dev_module.model.AccountReceivable;
import org.dev_module.service.AccountPayableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountPayableController {

	private static final String RETURN_ACCOUNT_PAYABLE = "account-payable";
	private static final String RETURN_ACCOUNT_PAYABLE_NEW = "account-payable-new";

	private AccountPayableService accountService;

	@RequestMapping(value = "account-payable")
	public ModelAndView view() {

		ModelAndView view = new ModelAndView(RETURN_ACCOUNT_PAYABLE);

		try {
			view.addObject("accounts",
					accountService.findLast10RegisterActive());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return view;

	}

	@RequestMapping(value = "account-payable/new")
	public ModelAndView newAccount() {

		ModelAndView view = new ModelAndView(RETURN_ACCOUNT_PAYABLE_NEW);

		AccountReceivable account = new AccountReceivable();
		account.setTipoConta("A_PAGAR");

		view.addObject("account", account);
		view.addObject("dataAtual",
				new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(calendar.DAY_OF_MONTH, +10);

		view.addObject("dataVencimento",
				new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));

		return view;

	}

	@RequestMapping(value = "accout-payable/list")
	public ModelAndView list() {

		ModelAndView view = new ModelAndView(RETURN_ACCOUNT_PAYABLE);

		try {
			view.addObject("accounts",
					accountService.findLast10RegisterActive());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return view;
	}

}
