package org.dev_module.dto;

public class findSummaryAccountsDTO {

	private Long contaaAReceber;
	private Long reciboAtrasado;
	private Long reciboParaHohe;
	private Long recebimentoFuturo;
	private Float totalAReceber;

	public Long getContaaAReceber() {
		return contaaAReceber;
	}

	public void setContaaAReceber(Long contaaAReceber) {
		this.contaaAReceber = contaaAReceber;
	}

	public Long getReciboAtrasado() {
		return reciboAtrasado;
	}

	public void setReciboAtrasado(Long reciboAtrasado) {
		this.reciboAtrasado = reciboAtrasado;
	}

	public Long getReciboParaHohe() {
		return reciboParaHohe;
	}

	public void setReciboParaHohe(Long reciboParaHohe) {
		this.reciboParaHohe = reciboParaHohe;
	}

	public Long getRecebimentoFuturo() {
		return recebimentoFuturo;
	}

	public void setRecebimentoFuturo(Long recebimentoFuturo) {
		this.recebimentoFuturo = recebimentoFuturo;
	}

	public Float getTotalAReceber() {
		return totalAReceber;
	}

	public void setTotalAReceber(Float totalAReceber) {
		this.totalAReceber = totalAReceber;
	}

}
