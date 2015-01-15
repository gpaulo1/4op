<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="<c:url value="/js/mask.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/mascaras.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/account-receivable/validator.js" />"></script>

<form:form action="/dev_module-WEB/account-receivable/save" id="form-id"
	method="POST" modelAttribute="account">
	<div class="ui form segment">

		<div class="ui form">
			<div class="ui fluid accordion">

				<div class="active title" id="bar-one">
					<i class="dropdown icon"></i> Informações da Conta
				</div>
				<div class="active content">
					<div class="fields">
						<div class="eight wide field" id="class-descricao-receita">
							<label>Nome do Registro</label>
							<div class="ui mini left icon input">
								<form:input type="text" placeholder="Descrição da receita"
									name="first-name" id="inp-descricao-receita" path="descricao"></form:input>
								<i class="info icon"></i>
								<form:hidden path="id" id="inp-id" />
								<form:hidden path="tipoConta" id="inp-id" />
							</div>

						</div>

						<div class="four wide field">

							<label>Conta Bancária</label>
							<div class="ui fluid selection dropdown">
								<div class="text">Caixinha</div>
								<i class="dropdown icon"></i> <input type="hidden" name="gender"
									id="slc-conta-bancaria"></input>
								<div class="menu">
									<div class="item" data-value="CAIXINHA">Caixinha</div>
								</div>
							</div>

						</div>

						<div class="four wide field">
							<label>Categoria</label>
							<div class="ui fluid selection dropdown">
								<div class="text">Caixinha</div>
								<i class="dropdown icon"></i>
								<form:input type="hidden" name="gender" value="Ajuste Caixa"
									path="categoria" id="slc-categoria"></form:input>
								<div class="menu">
									<div class="item" data-value="Ajuste Caixa">Ajuste Caixa</div>
									<div class="item" data-value="Aplicações Financeiras">Aplicações
										Financeiras</div>
									<div class="item" data-value="Devolução de Adiantamento">Devolução
										de Adiantamento</div>
									<div class="item" data-value="Financiamentos e Investimentos">Financiamentos
										e Investimentos</div>
									<div class="item" data-value="Outras Receitas">Outras
										Receitas</div>
									<div class="item" data-value="Saldo Inícial">Saldo
										Inícial</div>
									<div class="item" data-value="Serviços">Serviços</div>
									<div class="item" data-value="Tranferência de Entrada">Tranferência
										de Entrada</div>
									<div class="item" data-value="Vendas">Vendas</div>
								</div>
							</div>
						</div>
					</div>


					<div class="field">
						<label>Cliente</label>
						<div class="ui mini left icon input">
							<form:input type="text"
								placeholder="Digite as iniciais do cliente" path="cliente.nome"></form:input>
							<i class="user icon"></i>
						</div>


					</div>

					<!-- third row -->
					<div class="fields">
						<div class="five wide field" id="class-vencimento">

							<label>Data de Vencimento</label>
							<div class="ui mini left icon input">
								<form:input type="text" class="date" id="inp-vencimento"
									placeholder="Data de vencimento da receita"
									value="${dataVencimento}" path="dataVencimento"></form:input>
								<i class="calendar icon"></i>
							</div>

						</div>

						<div class="five wide field" id="class-valor">

							<label>Valor</label>
							<div class="ui mini left icon input">
								<form:input type="text" placeholder="Valor da receita"
									class="money" id="inp-valor" path="valor"></form:input>
								<i class="dollar icon"></i>
							</div>

						</div>

						<div class="six wide field">
							<label>Tipo de Registro</label>
							<div class="ui fluid selection dropdown">
								<div class="text">Caixinha</div>
								<i class="dropdown icon"></i>
								<form:input type="hidden" name="gender" value="Conta"
									path="tipoRegistro" id="slc-tp-registro"></form:input>
								<div class="menu">
									<div class="item" data-value="CONTA">Conta</div>
									<div class="item" data-value="BOLETO">Boleto</div>
									<div class="item" data-value="DUPLICATA">Duplicata</div>
								</div>
							</div>
						</div>
					</div>

				</div>


				<div class="title">
					<i class="dropdown icon"></i> Detalhes da Receita
				</div>
				<div class="content">


					<div class="fields">
						<div class="eight wide field">

							<label>Data de Emissão</label>
							<div class="ui mini left icon input">
								<form:input type="text" placeholder="Descrição da receita"
									value="${dataAtual}" class="date" id="inp-data-emissao"
									path="dataEmissao"></form:input>
								<i class="calendar icon"></i>
							</div>

						</div>

						<div class="four wide field">

							<label>Número do Documento</label>
							<div class="ui mini left icon input">
								<form:input type="text" placeholder="Número do documento"
									id="inp-numero-documento" path="numeroDocumento"></form:input>
								<i class="info icon"></i>
							</div>

						</div>

						<div class="four wide field">
							<label>Forma de Pagamento</label>
							<div class="ui fluid selection dropdown">
								<div class="text">Banco</div>
								<i class="dropdown icon"></i>
								<form:input type="hidden" name="gender" path="formaPagamento"
									id="slc-forma-pagamento"></form:input>
								<div class="menu">
									<div class="item" data-value="BNDES">BNDES</div>
									<div class="item" data-value="Boleto">Boleto</div>
									<div class="item" data-value="Cartão de Crédito">Cartão
										de Crédito</div>
									<div class="item" data-value="Cartão de Débit">Cartão de
										Débito</div>
									<div class="item" data-value="CH Descontado">CH
										Descontado</div>
									<div class="item" data-value="Cheque">Cheque</div>
									<div class="item" data-value="DDA">DDA</div>
									<div class="item" data-value="Débito Automático">Débito
										Automático</div>
									<div class="item" data-value="Depósito em C/C">Depósito
										em C/C</div>
									<div class="item" data-value="Depósito Identificado">Depósito
										Identificado</div>
									<div class="item" data-value="Dinheiro">Dinheiro</div>
									<div class="item" data-value="DOC">DOC</div>
									<div class="item" data-value="DP Descontada">DP
										Descontada</div>
									<div class="item" data-value="Duplicata Mercantil">Duplicata
										Mercantil</div>
									<div class="item" data-value="Faturado">Faturado</div>
									<div class="item" data-value="Faturar">Faturar</div>
									<div class="item" data-value="Lotérica">Lotérica</div>
									<div class="item" data-value="Outros">Outros</div>
									<div class="item" data-value="Pagamento Online">Pagamento
										Online</div>
									<div class="item" data-value="Permuta">Permuta</div>
									<div class="item" data-value="Ted">Ted</div>
									<div class="item" data-value="Transferência">Transferência</div>
								</div>
							</div>
						</div>
					</div>
					<div class="fields">
						<div class="nine wide field">
							<div class="ui form">
								<div class="field">
									<label>Observações</label>
									<form:textarea path="observacao" id="inp-obs"></form:textarea>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

			</br>

			<div class="ui center aligned three column grid">
				<div class="ui teal button" id="validate-send">
					<i class="save icon"></i> Salvar Registro
				</div>
			</div>

			<!-- END UI FORM-->
		</div>

	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(function() {

		$('.ui.accordion').accordion();

		$(".money").maskMoney({
			prefix : 'R$ ',
			allowNegative : true,
			thousands : '.',
			decimal : '.',
			affixesStay : false
		});
	});
</script>


