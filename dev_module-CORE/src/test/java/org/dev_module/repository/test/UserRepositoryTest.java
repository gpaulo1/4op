package org.dev_module.repository.test;

import java.util.List;

import javassist.NotFoundException;

import org.dev_module.configuration.AplicationContextTeste;
import org.dev_module.enumerator.MensagensEnum;
import org.dev_module.model.Fluxo;
import org.dev_module.service.impl.FluxoServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AplicationContextTeste.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class UserRepositoryTest {

	private Fluxo fluxo;

	@Autowired
	private FluxoServiceImpl fluxoService;

	public UserRepositoryTest() {
		fluxo = new Fluxo();
	}

	@Test(expected = NotFoundException.class)
	public void teste() throws NotFoundException {

		List<Fluxo> retorno = fluxoService.buscarTodos();
		Assert.assertEquals(MensagensEnum.NOT_FOUND_DATA.getMessage(),
				retorno);

	}

}
