package org.dev_module.BO;

public class CalculosBO {

	private static CalculosBO instance;
	
	private CalculosBO(){}
	
	public static CalculosBO getInstance(){
		if(instance == null){
			instance = new CalculosBO();
		}
		return instance;
	}
	
	public void calcularSaldoCredito(Double valorCredito, Double valorFluxo){
		
	}
	
}
