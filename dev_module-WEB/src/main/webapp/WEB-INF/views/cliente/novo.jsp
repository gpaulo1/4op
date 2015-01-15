<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript" src="<c:url value="/js/mask.js" />"></script>

<script type="text/javascript" src="<c:url value="/js/block-UI.js" />"></script>

<script type="text/javascript" src="<c:url value="/js/mascaras.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/js/cliente-fornecedor/cadastrar.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/js/cliente-fornecedor/cliente-fornecedor.js" />"></script>

<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/jquery.dataTables.css" />" />

<!-- DataTables -->
<script type="text/javascript"
	src="<c:url value="/js/jquery.dataTables.js" />"></script>

<div class="ui form segment">

	<div class="ui green message" id="message-success"
		style="display: none;">
		<i class="close icon"></i>Registro cadastrado com sucesso no sistema!
	</div>
	<div class="ui red message" style="display: none;" id="message-error">
		<i class="close icon"></i>Ocorreu um problema ao cadastrar o registro!
	</div>
	<div class="one field">
		<div class="field">
			<h4 class="ui inverted teal block header">Informações Pessoais</h4>
		</div>
	</div>
	<form:form action="/scai_projectV-web/aluno-cadastrar/" method="POST"
		modelAttribute="cliente" class="form-horizontal" id="form-main"
		name="userForm">
		<div class="three fields">
			<div class="field">
				<label>Tipo de pessoa</label>
				<div class="ui fluid selection dropdown ">
					<div class="text" data-value="JURIDICA">Jurídica</div>
					<i class="dropdown icon"></i> <input type="hidden" name="gender"
						value="JURIDICA" id="slc-tp-pessoa"></input>
					<div class="menu ">
						<div class="item" data-value="JURIDICA">Jurídica</div>
						<div class="item" data-value="FISICA">Física</div>
					</div>
				</div>
			</div>
			<div class="field fl-cpf-IP">

				<form:label path="cpf">CPF</form:label>
				<div class="ui mini left labeled icon input">
					<form:input type="text" placeholder="Cadastro de pessoa fisíca" path="cpf"
						class="inp-cpf" id="inp-cpf"></form:input> <i class="info letter icon"></i>
				</div>
			</div>

			<div class="field fl-cnpj-IP">

				<form:label path="cnpj">CNPJ</form:label>
				<div class="ui mini left labeled icon input">
					<form:input type="text" placeholder="Cadastro de CNPJ"
						class="inp-cnpj" id="inp-cnpj" path="cnpj"></form:input>
					<i class="info letter icon"></i>
				</div>
			</div>

			<div class="field fl-insc_estadual-IP">

				<form:label path="inscricaoEstadual">Inscrição Estadual</form:label>
				<div class="ui mini left labeled icon input">
					<form:input type="text" placeholder="Inscrição Estadual" path="inscricaoEstadual"
						class="inp-inscricao-estadual"></form:input> <i
						class="info letter icon"></i>
				</div>
			</div>
			<div class="field fl-rg-IP">

				<form:label path="rg">RG</form:label>
				<div class="ui mini left labeled icon input">
					<form:input type="text" id="inp-rg" placeholder="Registro Geral" path="rg"></form:input>
					<i class="info letter icon"></i>
				</div>
			</div>
		</div>
	</form:form>

	<!-- ********************************* INICIO | INFORMAÇÕES PESSOAIS (PESSOA JURIDICA - ROW 02) ********************************* -->


	<div class="three fields fild-juridico_01">
		<div class="field fl-razao_social-IP">

			<label>Razão Social</label>
			<div class="ui mini left labeled icon input"
				id="class-inp-razao-social">
				<input type="text" placeholder="Razão social" id="inp-razao-social"
					class="inp-inscricao-estadual"></input> <i class="info letter icon"></i>
			</div>
		</div>
		<div class="field fl-fantasia-IP">

			<label>Fantasia</label>
			<div class="ui mini left labeled icon input">
				<input type="text" value="${cliente.nome}" id="inp-fantasia"
					placeholder="Nome do cliente"></input> <i class="info letter icon"></i>
				<div class="ui corner label">
					<i class="icon asterisk"></i>
				</div>
			</div>
		</div>
		<div class="field fl-insc_estadual-IP">

			<label>Inscrição Municipal</label>
			<div class="ui mini left labeled icon input">
				<input id="inp-inscricao-municipal" type="text"
					value="${cliente.nome}" placeholder="Numero da inscrição municipal"></input>
				<i class="info letter icon"></i>
				<div class="ui corner label">
					<i class="icon asterisk"></i>
				</div>
			</div>
		</div>

	</div>

	<!-- ********************************* FIM | INFORMAÇÕES PESSOAIS (PESSOA JURIDICA - ROW 02) ********************************* -->


	<!-- ********************************* INICIO | INFORMAÇÕES PESSOAIS (PESSOA FISICA - ROW 02) ********************************* -->


	<div class="one field fild-fisico_01">
		<div class="field fl-nome-IP">

			<label>Nome</label>
			<div class="ui mini left labeled icon input" id="class-inp-nome">
				<input type="text" placeholder="Nome completo" id="inp-nome"
					class="inp-inscricao-estadual"></input> <i class="info letter icon"></i>
			</div>
		</div>

	</div>

	<!-- ********************************* FIM | INFORMAÇÕES PESSOAIS (PESSOA FISICA - ROW 02) ********************************* -->



	<div class="two fields">
		<div class="field">
			<label>CEP</label>
			<div class="ui mini action input">
				<input type="text" class="inp-cep" id="inp-cep"
					placeholder="Informar ou localizar CEP">
				<div class="ui mini icon teal button" id="find-cep">
					<i class="search icon"></i>
				</div>
			</div>
		</div>
	</div>
	<div class="two fields">
		<div class="field">
			<label>Endereço</label>
			<div class="ui mini left labeled icon input">
				<input type="text" placeholder="Logradouro" id="inp-endereco"></input>
				<i class="location arrow icon"></i>
			</div>
		</div>
		<div class="field">
			<label>Número</label>
			<div class="ui mini left labeled icon input">
				<input type="text" placeholder="Número do logradouro"
					id="inp-numero"></input> <i class="location arrow icon"></i>
			</div>
		</div>
	</div>

	<div class="two fields">
		<div class="field">
			<label>Bairro</label>
			<div class="ui mini left labeled icon input">
				<input type="text" placeholder="Logradouro" id="inp-bairro"></input>
				<i class="location arrow icon"></i>
			</div>
		</div>
		<div class="field">
			<label>Complemento</label>
			<div class="ui mini left labeled icon input">
				<input type="text" placeholder="Número do logradouro"
					id="inp-complemento"></input> <i class="location arrow icon"></i>
			</div>
		</div>
	</div>

	<div class="two fields">
		<div class="field">
			<label>Cidade</label>
			<div class="ui mini left labeled icon input">
				<input type="text" placeholder="Cidade" id="inp-cidade"></input> <i
					class="location arrow icon"></i>
			</div>
		</div>
		<div class="field">
			<label>Estado</label>
			<div class="ui fluid selection dropdown">
				<div class="text">Selecione</div>
				<i class="dropdown icon"></i> <input type="hidden" name="gender"
					id="slc-estado"></input>
				<div class="menu">
					<div class="item" data-value="AC">Acre</div>
					<div class="item" data-value="AL">Alagos</div>
					<div class="item" data-value="AP">Amapá</div>
					<div class="item" data-value="AM">Amazonas</div>
					<div class="item" data-value="BA">Bahia</div>
					<div class="item" data-value="CE">Ceará</div>
					<div class="item" data-value="DF">Distrito Federal</div>
					<div class="item" data-value="ES">Espírito Santo</div>
					<div class="item" data-value="GO">Goiás</div>
					<div class="item" data-value="MA">Maranhão</div>
					<div class="item" data-value="MG">Mato Grosso</div>
					<div class="item" data-value="MS">Mato Grosso do Sul</div>
					<div class="item" data-value="MG">Minas Gerais</div>
					<div class="item" data-value="PA">Pará</div>
					<div class="item" data-value="PA">Paraíba</div>
					<div class="item" data-value="PR">Paraná</div>
					<div class="item" data-value="PB">Pernambuco</div>
					<div class="item" data-value="PI">Piauí</div>
					<div class="item" data-value="RJ">Rio de Janeiro</div>
					<div class="item" data-value="RN">Rio Grande do Norte</div>
					<div class="item" data-value="RS">Rio Grande do Sul</div>
					<div class="item" data-value="RD">Rondônia</div>
					<div class="item" data-value="RO">Roraima</div>
					<div class="item" data-value="SC">Santa Catarina</div>
					<div class="item" data-value="sp">São Paulo</div>
					<div class="item" data-value="SG">Sergipe</div>
					<div class="item" data-value="TO">Tocantins</div>
				</div>
			</div>
		</div>
	</div>

	<div class="two fields">
		<div class="field">
			<label>E-mail</label>
			<div class="ui mini left labeled icon input">
				<input type="text" placeholder="Email principal" id="inp-email"></input>
				<i class="mail icon"></i>
			</div>
		</div>
		<div class="field">
			<label>Telefone</label>
			<div class="ui mini left labeled icon input">
				<input type="text" placeholder="Telefone principal" class="inp-tel"
					id="inp-telefone"></input> <i class="phone icon"></i>
			</div>
		</div>
	</div>



	<!-- ********************************* FIM | INFORMAÇÕES PESSOAIS (PESSOA FISICA) ********************************* -->



	<div class="field">
		<h4 class="ui inverted purple block header">Informações de
			Contato</h4>
		<div class="two fields">
			<div class="field">
				<label>Nome do Contato</label>
				<div class="ui mini left labeled icon input">
					<input type="text" placeholder="Pessoa de contato"
						id="inp-cont-nome"></input> <i class="user icon"></i>
				</div>
			</div>
			<div class="field">

				<label>Data de Nascimento</label>
				<div class="ui mini left labeled icon input">
					<input type="text" placeholder="Data de nascimento" class="date"
						id="inp-cont-data-nascimento"></input> <i class="info letter icon"></i>
				</div>
			</div>
		</div>
		<div class="three fields">
			<div class="field">
				<label>Telefone</label>
				<div class="ui mini left labeled icon input">
					<input type="text" placeholder="Telefone de contato"
						id="inp-cont-telefone" class="inp-tel"></input> <i
						class="phone icon"></i>
				</div>
			</div>
			<div class="field">

				<label>Ramal</label>
				<div class="ui mini left labeled icon input">
					<input type="text" placeholder="Ramal de contato"
						id="inp-cont-ramal"></input> <i class="phone icon"></i>
				</div>
			</div>
			<div class="field">

				<label>Fax</label>
				<div class="ui mini left labeled icon input">
					<input type="text" placeholder="Fax de contato" id="inp-cont-fax"
						class="inp-tel"></input> <i class="phone icon"></i>
				</div>
			</div>
		</div>
		<div class="two fields">
			<div class="field">
				<label>Celular</label>
				<div class="ui mini left labeled icon input">
					<input type="text" placeholder="Celular de contato"
						id="inp-cont-celular" class="inp-tel"></input> <i
						class="mobile icon"></i>
				</div>
			</div>
			<div class="field">

				<label>Email</label>
				<div class="ui mini left labeled icon input">
					<input type="text" placeholder="Email de contato"
						id="inp-cont-email"></input> <i class="mail icon"></i>
				</div>
			</div>
		</div>
		<div class="one field">
			<div class="field">
				<label>Web Site</label>
				<div class="ui mini left labeled icon input">
					<input type="text" placeholder="ex: www.empresaexemplo.com.br"
						id="inp-cont-site"></input> <i class="url icon"></i>
				</div>
			</div>
		</div>
		<h4 class="ui inverted blue block header">
			Endereço
			<div class="circular ui icon small button" id="endereco_button">
				<i class="add icon" id="icon-form"></i>
			</div>
		</h4>
		<div class="form-cliene-fornecedor">
			<div class="one field">
				<div class="field">
					<table class="ui table segment" id="tbl_enderecos">
						<thead>
							<tr>
								<th width="20%">Tipo</th>
								<th width="20%">Doc.</th>
								<th width="50%">Endereço</th>
								<th width="10%"></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<br>
				</div>
			</div>
			<div class="five fields">
				<div class="field">
					<label>Tipo de endereço</label>
					<div class="ui fluid selection dropdown">
						<i class="dropdown icon"></i>
						<div class="text">Selecione</div>
						<input type="hidden" name="gender" id="tp-endereco"></input>
						<div class="menu">
							<div class="item" data-value="Retirada">Retirada</div>
							<div class="item" data-value="Entrega">Entrega</div>
							<div class="item" data-value="Cobrança">Cobrança</div>
						</div>
					</div>
				</div>
				<div class="field">
					<label>Tipo de Pessoa</label>
					<div class="ui fluid selection dropdown">
						<i class="dropdown icon"></i>
						<div class="text" data-value="CNPJ">CNPJ</div>
						<input type="hidden" name="gender" id="slc-tp-pessoa-endereco"></input>
						<div class="menu">
							<div class="item" data-value="CNPJ">CNPJ</div>
							<div class="item" data-value="CPF">CPF</div>
						</div>
					</div>
				</div>
				<div class="field" id="fd-cnpj-endereco">

					<label>CNPJ</label>
					<div class="ui mini left labeled icon input">
						<input type="text" placeholder="Número do CNPJ" class="inp-cnpj"
							id="inp-cnpj-endereco"></input> <i class="info letter icon"></i>
					</div>
				</div>
				<div class="field" id="fd-cpf-endereco">

					<label>CPF</label>
					<div class="ui mini left labeled icon input">
						<input type="text" placeholder="Número do CPF" class="inp-cpf"
							id="inp-cpf-endereco"></input> <i class="info letter icon"></i>
					</div>
				</div>
				<div class="field">
					<label>CEP</label>
					<div class="ui mini action input">
						<input type="text" class="inp-cep" id="inp-cep-endereco"
							placeholder="Informar ou localizar CEP">
						<div class="ui mini icon teal button" id="find-cep-end">
							<i class="search icon"></i>
						</div>
					</div>
				</div>
				<div class="field">

					<label>Endereco</label>
					<div class="ui mini left labeled icon input">
						<input type="text" placeholder="Logradouro" id="inp-endereco-end"></input>
						<i class="location arrow icon"></i>
					</div>
				</div>
			</div>
			<div class="five fields form-cliene-fornecedor">
				<div class="field">

					<label>Bairro</label>
					<div class="ui mini left labeled icon input">
						<input type="text" placeholder="Bairro" id="inp-bairro-endereco"></input>
						<i class="location arrow icon"></i>
					</div>
				</div>
				<div class="field">

					<label>Número</label>
					<div class="ui mini left labeled icon input">
						<input type="text" placeholder="Número do logradouro"
							id="inp-numero-endereco"></input> <i class="location arrow icon"></i>
					</div>
				</div>
				<div class="field">

					<label>Complemento</label>
					<div class="ui mini left labeled icon input">
						<input type="text" placeholder="Complemento"
							id="inp-complemento-endereco"></input> <i
							class="location arrow icon"></i>
					</div>
				</div>
				<div class="field">
					<label>Estado</label>
					<div class="ui fluid selection dropdown">
						<div class="text">Selecione</div>
						<i class="dropdown icon"></i> <input type="hidden" name="gender"
							id="slc-estado-endereco"></input>
						<div class="menu">
							<div class="item" data-value="AC">Acre</div>
							<div class="item" data-value="AL">Alagos</div>
							<div class="item" data-value="AP">Amapá</div>
							<div class="item" data-value="AM">Amazonas</div>
							<div class="item" data-value="BA">Bahia</div>
							<div class="item" data-value="CE">Ceará</div>
							<div class="item" data-value="DF">Distrito Federal</div>
							<div class="item" data-value="ES">Espírito Santo</div>
							<div class="item" data-value="GO">Goiás</div>
							<div class="item" data-value="MA">Maranhão</div>
							<div class="item" data-value="MG">Mato Grosso</div>
							<div class="item" data-value="MS">Mato Grosso do Sul</div>
							<div class="item" data-value="MG">Minas Gerais</div>
							<div class="item" data-value="PA">Pará</div>
							<div class="item" data-value="PA">Paraíba</div>
							<div class="item" data-value="PR">Paraná</div>
							<div class="item" data-value="PB">Pernambuco</div>
							<div class="item" data-value="PI">Piauí</div>
							<div class="item" data-value="RJ">Rio de Janeiro</div>
							<div class="item" data-value="RN">Rio Grande do Norte</div>
							<div class="item" data-value="RS">Rio Grande do Sul</div>
							<div class="item" data-value="RD">Rondônia</div>
							<div class="item" data-value="RO">Roraima</div>
							<div class="item" data-value="SC">Santa Catarina</div>
							<div class="item" data-value="SP">São Paulo</div>
							<div class="item" data-value="SG">Sergipe</div>
							<div class="item" data-value="TO">Tocantins</div>
						</div>
					</div>
				</div>
				<div class="field">

					<label>Cidade</label>
					<div class="ui mini left labeled icon input">
						<input type="text" placeholder="Cidade" id="inp-cidade-endereco"></input>
						<i class="location arrow icon"></i>
					</div>
				</div>
			</div>
			<div class="ui teal button entrada" id="add-row">
				<i class="add sign box icon"></i> Adicionar
			</div>
		</div>
	</div>
	<div class="ui section divider"></div>
	<div class="ui center aligned three column grid">
		<div class="ui teal button entrada" id="btn-salvar-registro">
			<i class="save icon"></i> Salvar Cliente
		</div>
	</div>
</div>
<script type="text/javascript">
	$("#send-form").click(function() {
		$("#form-cliente").submit();
	});

	$(document).ready(function() {

		$('.message .close').on('click', function() {
			$(this).closest('.message').fadeOut();
		});

		$('#tbl_enderecos').DataTable();
	});
</script>