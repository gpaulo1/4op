package org.dev_module.dto;

import java.util.Date;

public class SaldoFluxoDTO {

	private Double saldoCredito;
	private Double saldoDebito;
	private Double saldoDisponivel;
	private Date data;
	private Double valor;
	private String descricao;

	public Double getSaldoCredito() {
		return saldoCredito;
	}

	public void setSaldoCredito(Double saldoCredito) {
		this.saldoCredito = saldoCredito;
	}

	public Double getSaldoDebito() {
		return saldoDebito;
	}

	public void setSaldoDebito(Double saldoDebito) {
		this.saldoDebito = saldoDebito;
	}

	public Double getSaldoDisponivel() {
		return saldoDisponivel;
	}

	public void setSaldoDisponivel(Double saldoDisponivel) {
		this.saldoDisponivel = saldoDisponivel;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
