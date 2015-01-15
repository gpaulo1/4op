package org.dev_module.BO.test;

import org.dev_module.BO.CalculosBO;
import org.dev_module.configuration.AplicationContextTeste;
import org.dev_module.model.Caixa;
import org.dev_module.model.Fluxo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AplicationContextTeste.class)
public class CalculosBOTest {
	
	private Caixa caixa;
	private Fluxo fluxo;
	
	public CalculosBOTest(){
		caixa = new Caixa();
//		caixa.setSaldoDisponivel(100.00);
		
		fluxo = new Fluxo();
	}
	
//	@Test
//	public void deveTestarSaldoDisponivel(){
//		Assert.assertEquals(caixa.getSaldoDisponivel().toString(), "100.0");
//		
//		fluxo.setEntrada(true);
//		fluxo.setDescricao("Testando o calculo de entrada");
//		fluxo.setValor(50.0);
//		
////		caixa.setSaldoCredito(saldoCredito);
//		
//	}
	
	
	
}
