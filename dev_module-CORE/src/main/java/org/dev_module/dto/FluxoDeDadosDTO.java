package org.dev_module.dto;

public class FluxoDeDadosDTO {

	private Long id;
	private String descricao;
	private Double valor;
	private Double saldoFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(Double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

}
