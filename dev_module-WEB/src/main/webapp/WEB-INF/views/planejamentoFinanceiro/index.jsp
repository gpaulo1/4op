<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="js/ajax/planejamento_financeiro.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript"
	src="js/planejamento-financeiro/fluxo-caixa.js"></script>

<div class="ui form segment">
	<div class="ui celled grid">
		<div class="seven wide middle column">

			<div class="ui green message" id="msg-success-plan">Caixa
				criado com sucesso!</div>
			<div class="ui ribbon teal label">Planejamento Financeiro</div>

			<div class="ui divided list list-caixas">
				<c:forEach items="${caixas}" var="caixa">
					<div class="item">
						<input type="hidden" value="${caixa.id}" id="caixa_id">
						<div class="right floated positive mini ui button"
							id="${caixa.id}" onclick="getIdCaixa(this.id)">Fluxo</div>
						<img class="ui avatar image" src="<c:url value="${caixa.urlIcone}"/>">
						<div class="content">
							<div class="header">${caixa.nome}</div>
							<p>Ver</p>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="ui section divider"></div>
			<div class="ui left pointing dropdown icon teal button">
				<i class="add icon"></i>
				<div class="menu">
					<div class="item">
						<i class="edit icon"></i>Carteira
					</div>
					<div class="item">
						<i class="delete icon"></i>Caixa
					</div>
					<div class="item conta-banco">
						<i class="hide icon"></i>Conta Bancária
					</div>
					<div class="item">
						<i class="hide icon"></i>Fiado
					</div>
				</div>
			</div>

		</div>
		<div class="nine wide right column">
			<div class="ui icon message">
				<i class="dollar icon"></i>
				<div class="content">
					<div class="header">Fluxo de caixa referente ao Banco do
						Brasil</div>
					<p>
						Lançamentos dos último 30 dias. Para ver mais lançamentos clique <a
							href="#">aqui</a>.
					</p>
				</div>
			</div>
			<table class="ui basic table">
				<thead>
					<tr>
						<th>Resumo</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Crédito</td>
						<td class="positive saldo-credito" width="50%">R$
							${caixa.saldo.saldoCredito}</td>
					</tr>
					<tr>
						<td>Débito</td>
						<td class="negative saldo-debito" width="50%">R$
							${caixa.saldoDebito}</td>
					</tr>
					<tr>
						<td><b>Saldo</b></td>
						<td class="positive saldo-disponivel" width="50%">R$
							${caixa.saldosaldoDisponivel}</td>
					</tr>
				</tbody>
			</table>

			<div class="ui horizontal divider">
				<i class="ellipsis horizontal icon"></i>
			</div>

			<div class="ui green message" id="msg-novo-registro">Registro
				inserido com sucesso!</div>

			<table class="ui sortable table segment hover" id="table_fluxo">
				<thead>
					<tr>
						<th>Data</th>
						<th>Descrição</th>
						<th>Valor</th>
						<th>Saldo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${fluxos}" var="fluxo">
						<tr>
							<td>${fluxo.data}</td>
							<td>${fluxo.descricao }</td>
							<td id="registro-column" class="positive">${fluxo.valor}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="ui fitted divider"></div>
			<br>
			<div class="ui center aligned three column grid">
				<div class="ui teal button entrada">
					<i class="dollar icon "></i> Inserir Registro
				</div>
			</div>
			<form action="logout" method="post">
				<input type="submit" value="sair"><input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</div>


	<!-- ***************************** MODAL PARA ADCIONAR NOVA AGENCIA BANCARIA ***************************** -->


	<div class="ui modal modal-banco">
		<i class="close icon"></i>
		<div class="header">Adicionar Registro de Caixa</div>
		<div class="content">
			<div class="ui form segment">
				<div class="two fields">
					<div class="field">
						<label>Agência Bancária</label>
						<div class="ui fluid selection dropdown nome_agencia_bancaria">
							<div class="text">Selecione</div>
							<i class="dropdown icon"></i> <input type="hidden" name="gender">
							<div class="menu">
								<div class="item" data-value="BANCO_DO_BRASIL">
									<img class="circular ui image"
										src="<c:url value="/images/bancos/brasil.jpg" />">Banco
									do Brasil
								</div>
								<div class="item" data-value="BRADESCO">
									<img class="circular ui image" src="images/bancos/bradesco.jpg">Bradesco
								</div>
								<div class="item" data-value="ITAU">
									<img class="circular ui image" src="images/bancos/itau.jpg">Itaú
								</div>
								<div class="item" data-value="CAIXA">
									<img class="circular ui image" src="images/bancos/caixa.png">Caixa
									Federal
								</div>
								<div class="item" data-value="BANCO_RURAL">
									<img class="circular ui image" src="images/bancos/rural.png">Banco
									Rural
								</div>
							</div>
						</div>
					</div>
					<div class="field">
						<label>Descrição da Conta</label>
						<div class="ui left icon input">
							<input type="text" placeholder="Nome da conta bancária"
								id="descricao-conta"> <i class="building icon"></i> <i
								class="info icon"></i>
						</div>
					</div>
				</div>
				<div class="fields">
					<div class="six wide field">
						<label>Agência</label>
						<div class="ui left icon input">
							<input type="text" placeholder="Nome da conta bancária"
								id="agencia-banco"> <i class="info icon"></i> <i
								class="info icon"></i>
						</div>
					</div>
					<div class="six wide field">
						<label>Conta</label>
						<div class="ui left icon input">
							<input type="text" placeholder="Nome da conta bancária"
								id="conta-banco"> <i class="info icon"></i> <i
								class="info icon"></i>
						</div>
					</div>
					<div class="four wide field">
						<label>Data</label>
						<div class="ui left icon input">
							<input type="text" placeholder="Data do saldo inicial"
								id="conta-banco"> <i class="info icon"></i> <i
								class="info icon"></i>
						</div>
					</div>
				</div>
				<div class="ui fitted divider"></div>
				<br>
				<div class="two fields">
					<div class="field">
						<label>Saldo disponível em conta</label>
						<div class="ui left icon input">
							<input type="text" id="saldo-banco"> <i
								class="money icon"></i> <i class="info icon"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="actions">
			<div class="ui buttons">
				<div class="ui button">Cancelar</div>
				<div class="or"></div>
				<div class="ui positive button" id="novo_caixa">Salvar</div>
			</div>
		</div>
	</div>
	<!--***************************** FIM ***************************** -->

	<!-- ***************************** MODAL PARA ADCIONAR NOVO REGISTRO DE ENTRADA ***************************** -->
	<div class="ui modal modal-entrada">
		<i class="close icon"></i>
		<div class="header">
			<i class="dollar icon"></i>Adicionar fluxo de caixa - Conta Bancâria
		</div>
		<div class="content">
			<div class="ui form">

				<div class="ui slider checkbox" id="unique-id">
					<input type="checkbox" name="newsletter" id="checkk"> <label
						id="laveu"><span id="spanteste"></span></label>
				</div>

			</div>
			<div class="ui form segment">
				<div class="two fields">
					<div class="field">
						<label>Descrição</label>
						<div class="ui input">
							<input placeholder="Descriçãoo do novo registro"
								name="reg-descricao" id="descricao-registro" type="text">
						</div>
					</div>
					<div class="field">
						<label>Valor</label>
						<div class="ui input">
							<input placeholder="Valor do novo registro" class="numbersOnly"
								name="reg-valor money" type="text" id="valor-registro">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="actions">
				<div class="ui positive button" onclick="inserirRegistroTabela()"><i class="save icon"></i>Salvar</div>
		</div>
	</div>
</div>
<!--***************************** FIM ***************************** -->
<script>
	$(".conta-banco").click(function() {
		$('.modal-banco').modal('show');
	});

	$(".entrada").click(function() {
		$('.modal-entrada').modal('show');
	});

	$(document).ready(function() {
		$('#table_id').DataTable({

		});
	});
</script>
