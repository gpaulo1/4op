package org.dev_module.dto;

public class NovoCaixaDTO {

	private Long idCaixa;
	private Long idFluxo;
	private String fluxoDescricao;
	private Double fluxoValor;
	private String urlIcone;
	private String caixaNome;

	public Long getIdFluxo() {
		return idFluxo;
	}

	public void setIdFluxo(Long idFluxo) {
		this.idFluxo = idFluxo;
	}

	public Long getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(Long idCaixa) {
		this.idCaixa = idCaixa;
	}

	public String getFluxoDescricao() {
		return fluxoDescricao;
	}

	public void setFluxoDescricao(String fluxoDescricao) {
		this.fluxoDescricao = fluxoDescricao;
	}

	public Double getFluxoValor() {
		return fluxoValor;
	}

	public void setFluxoValor(Double fluxoValor) {
		this.fluxoValor = fluxoValor;
	}

	public String getUrlIcone() {
		return urlIcone;
	}

	public void setUrlIcone(String urlIcone) {
		this.urlIcone = urlIcone;
	}

	public String getCaixaNome() {
		return caixaNome;
	}

	public void setCaixaNome(String caixaNome) {
		this.caixaNome = caixaNome;
	}

}
