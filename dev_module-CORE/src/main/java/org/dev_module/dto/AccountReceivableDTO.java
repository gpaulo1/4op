package org.dev_module.dto;

import java.util.Date;

public class AccountReceivableDTO {

	private Long id;
	private Date dataVencimento;
	private Double valor;
	private String descricao;
	private String formaPagamento;
	private Long contasAReceber;

	public Long getContasAReceber() {
		return contasAReceber;
	}

	public void setContasAReceber(Long contasAReceber) {
		this.contasAReceber = contasAReceber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
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

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}
