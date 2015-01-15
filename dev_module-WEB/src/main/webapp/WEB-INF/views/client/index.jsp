<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>


<script type="text/javascript"
	src="<c:url value="/bootstrap/js/client/register_client.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/bootstrap/js/mask.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/bootstrap/js/mascaras.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/bootstrap/js/client/manager_client.js" />"></script>

<!-- Data tables -->
<script type="text/javascript"
	src="<c:url value="/bootstrap/js/jquery.dataTables.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/bootstrap/css/jquery.dataTables.css" />" />

<div class="main">

	<div class="main-inner">

		<div class="container">

			<div class="row">

				<div class="span12">

					<div class="widget ">

						<div class="widget-header">
							<i class="icon-user"></i>
							<h3>Genrenciar Clientes</h3>
						</div>
						<!-- /widget-header -->



						<div class="widget-content">

							<div class="alert alert-success" id="alert_success_save_client">
								<strong>Sucesso!</strong> Cliente salvo com sucesso no sistema.
							</div>

							<div class="tabbable">
								<ul class="nav nav-tabs">
									<li id="panel_novo_cliente"><a id="link_novo_cliente"
										href="#formcontrols" data-toggle="tab">Novo Cliente</a></li>
									<li id="panel_cliente" class="active"><a id="link_cliente"
										href="#jscontrols" data-toggle="tab">Cliente</a></li>
								</ul>

								<br>

								<div class="tab-content">
									<div class="tab-pane" id="formcontrols">
										<form id="edit-profile" class="form-horizontal">
											<fieldset>

												<div class="control-group">
													<label class="control-label" for="firstname">Nome
														do cliente</label>
													<div class="controls">
														<input type="text" class="span6" id="client_name" value=""
															placeholder="Nome do cliente">
													</div>
													<button type="button" id="btn_complementary_information"
														value="hidden" onclick="hideShowButton(this.value)"
														style="margin-left: 14%; margin-top: 5px;"
														class="btn btn-primary btn-xs">Informações
														Adicionais</button>
												</div>

												<!-- Infromações complementares -->

												<div id="complementary_information">

													<div class="control-group">
														<label class="control-label" for="radiobtns">Tipo
															de Pessoa</label>

														<div class="controls">
															<select class="selectpicker" id="slc_tp_people">
																<option value="FISICA">Fisica</option>
																<option value="JURIDICA">Juridica</option>
															</select>
														</div>
														<!-- /controls -->
													</div>

													<div id="complementary_information_physical">

														<div class="control-group">
															<label class="control-label" for="lastname">CPF</label>
															<div class="controls">
																<input type="text" class="span6 msk-cpf"
																	id="client_physical_cpf"
																	placeholder="Cadastro de Pessoa Fisica">
															</div>
															<!-- /controls -->
														</div>
														<!-- control-group !-->


														<div class="control-group">
															<label class="control-label" for="lastname">RG</label>
															<div class="controls">
																<input type="text" class="span6" id="client_physical_rg"
																	placeholder="Registro Geral">
															</div>
															<!-- /controls -->
														</div>

														<div class="control-group">
															<label class="control-label" for="lastname">E-mail</label>
															<div class="controls">
																<input type="text" class="span6"
																	id="client_physical_email"
																	placeholder="Endereço de Email">
															</div>
															<!-- /controls -->
														</div>

														<div class="control-group">
															<label class="control-label" for="lastname">Telefone
																Comercial</label>
															<div class="controls">
																<input type="text" class="span6 msk-homephone"
																	id="client_physical_workPhone"
																	placeholder="Telefone Comercial">
															</div>
															<!-- /controls -->
														</div>

														<div class="control-group">
															<label class="control-label" for="lastname">Telefone
																Celular</label>
															<div class="controls">
																<input type="text" class="span6 msk-cel"
																	id="client_physical_homePhone"
																	placeholder="Telefone Celular">
															</div>
															<!-- /controls -->
														</div>

														<div class="control-group">
															<label class="control-label" for="lastname">Data
																de Nascimento</label>
															<div class="controls">
																<input type="text" class="span2 msk-date" id="lastname">
															</div>
															<!-- /controls -->
														</div>

														<div class="control-group">
															<label class="control-label" for="lastname">Obervações</label>
															<div class="controls">
																<textarea class="form-control span6" rows="3"
																	id="client_physical_observation"
																	placeholder="Observações gerais"></textarea>
															</div>
															<!-- /controls -->
														</div>

													</div>





													<!-- Infromações complementares Juridica-->

													<div id="complementary_information_juridic">

														<div class="control-group">
															<label class="control-label" for="lastname">CNPJ</label>
															<div class="controls">
																<input type="text" class="span6 msk-cnpj"
																	id="client_juridic_cnpj"
																	placeholder="Cadastro Nacional da Pessoa Jurídica">
															</div>
															<!-- /controls -->
														</div>
														<!-- c  <input type="checkbox"> Option 01
														ontrol-group !-->


														<div class="control-group">
															<label class="control-label" for="lastname">Razão
																Social</label>
															<div class="controls">
																<input type="text" class="span6"
																	id="client_juridic_corporateName"
																	placeholder="Número da Razão Social">
															</div>
															<!-- /controls -->
														</div>

														<div class="control-group">
															<label class="control-label" for="lastname">Inscrição
																Estadual</label>
															<div class="controls">
																<input type="text" class="span6"
																	id="client_juridic_stateRegistration"
																	placeholder="Número da Inscrição Estadual">
															</div>
															<!-- /controls -->
														</div>

														<div class="control-group">
															<label class="control-label" for="lastname">Email</label>
															<div class="controls">
																<input type="text" class="span6"
																	id="client_juridic_email"
																	placeholder="Email de contato">
															</div>
															<!-- /controls -->
														</div>

														<div class="control-group">
															<label class="control-label" for="lastname">Telefone
																Comercial</label>
															<div class="controls">
																<input type="text" class="span6 msk-homephone"
																	id="client_juridic_workPhone"
																	placeholder="Telefone Comercial">
															</div>
															<!-- /controls -->
														</div>

														<div class="control-group">
															<label class="control-label" for="lastname">Telefone
																Celular</label>
															<div class="controls">
																<input type="text" class="span6 msk-cel"
																	id="client_juridic_homePhone"
																	placeholder="Telefone Celular">
															</div>
															<!-- /controls -->
														</div>


														<div class="control-group">
															<label class="control-label" for="lastname">Obervações</label>
															<div class="controls">
																<textarea class="form-control span6" rows="3"
																	id="client_juridic_observation"
																	placeholder="Observações gerais"></textarea>
															</div>
															<!-- /controls -->
														</div>

													</div>
												</div>


												<div class="accordion-group active">
													<div class="accordion-heading">
														<a class="accordion-toggle" data-toggle="collapse"
															data-parent="#accordion2" href="#collapseOne">
															Adicionar Contato (Opcional) </a>
													</div>
													<div id="collapseOne" class="accordion-body collapse"">

														<div class="control-group">
															<table class="table table-hover span8"
																id="tbl_add_contact">
																<thead>
																	<tr>
																		<th></th>
																		<th>Nome</th>
																		<th>Email</th>
																		<th>Fone</th>
																		<th>Cargo</th>
																	</tr>
																</thead>
																<tbody>
																	<tr>
																		<td><button type="button" id="remove_1"
																				class="btn btn-default btn-xs">-</button></td>
																		<td><input id="name_1" type="text"></td>
																		<td><input id="mail_1" type="text"></td>
																		<td><input id="fone_1" type="text"></td>
																		<td><input id="cargo_1" type="text"></td>
																	</tr>
																</tbody>
															</table>
														</div>

														<div class="control-group">
															<button type="button" id="btn_add_contact" value="hidden"
																onclick="tableAddContact()"
																style="margin-left: 80%; margin-top: -30px;"
																class="btn btn-primary btn-xs">Novo Contato</button>
														</div>

													</div>
												</div>




												<div class="accordion-group">
													<div class="accordion-heading">
														<a class="accordion-toggle" data-toggle="collapse"
															data-parent="#accordion2" href="#collapseTwo">
															Adicionar Endereço (Opcional) </a>
													</div>
													<div id="collapseTwo" class="accordion-body collapse">
														<br>
														<div class="control-group">
															<label class="control-label" for="lastname">Cep</label>
															<div class="controls">
																<input type="text" class="span6 msk-cep"
																	id="address_cep" placeholder="Número do Cep">
															</div>
															<!-- /controls -->
														</div>
														<div class="control-group">
															<label class="control-label" for="lastname">Endereço</label>
															<div class="controls">
																<input type="text" class="span6" id="address_address"
																	placeholder="Endereço">
															</div>
															<!-- /controls -->
														</div>
														<div class="control-group">
															<label class="control-label" for="lastname">Número</label>
															<div class="controls">
																<input type="text" class="span3" id="address_number"
																	placeholder="Número do endereço">
															</div>
															<!-- /controls -->
														</div>
														<div class="control-group">
															<label class="control-label" for="lastname">Complemento</label>
															<div class="controls">
																<input type="text" class="span6" id="address_complement"
																	placeholder="Complemento">
															</div>
															<!-- /controls -->
														</div>
														<div class="control-group">
															<label class="control-label" for="lastname">Bairro</label>
															<div class="controls">
																<input type="text" class="span6"
																	id="address_neighborhood" placeholder="Bairro">
															</div>
															<!-- /controls -->
														</div>
														<div class="control-group">
															<label class="control-label" for="lastname">Cidade</label>
															<div class="controls">
																<input type="text" class="span6" id="address_city"
																	placeholder="Cidade">
															</div>
															<!-- /controls -->
														</div>

													</div>
												</div>

												<div class="control-group">
													<div class="modal-footer">
														<button type="button" class="btn" id="0"
															data-dismiss="modal" onclick="saveClient(this.id)"
															aria-hidden="true">Salvar e cadastrar outro</button>
														<button type="button" id="1" class="btn btn-success"
															onclick="saveClient(this.id)">Salvar</button>
													</div>
												</div>

											</fieldset>
										</form>
									</div>

									<div class="tab-pane active" id="jscontrols">
										<form id="edit-profile2" class="form-vertical">
											<fieldset>

												<div class="control-group">
													<div class="well text-center">
														<button type="button"
															class="btn btn-danger text-uppercase btn-lg">Remover</button>
														<button type="button"
															class="btn btn-sunny text-uppercase btn-lg">Exportar
															Contatos</button>
															
															<input class="span2 m-wrap" placeholder="Buscar cliente" style="margin-top: 10px; margin-left: 62%;" id="appendedInputButton"
																type="text">
													</div>
												</div>

												<div class="control-group">
													<table class="table table-hover" id="tbl_show_contacts">
														<thead>
															<tr>
																<th></th>
																<th>Nome</th>
																<th>CNPJ/CPF</th>
																<th>Email</th>
																<th>telefone Comercial</th>
																<th>Criado em</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${clients}" var="client">
																<tr>
																	<td><input type="checkbox"></td>
																	<td>${client.name}</td>
																	<td>${client.cpfCnpj}</td>
																	<td>${client.email}</td>
																	<td>${client.workPhone}</td>
																	<td><fmt:formatDate pattern="dd/MM/yyyy"
																			value="${client.dateRegistration}" /></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
													<!-- /controls -->
												</div>
												<!-- /control-group -->
											</fieldset>
										</form>
									</div>

								</div>


							</div>





						</div>
						<!-- /widget-content -->

					</div>
					<!-- /widget -->

				</div>
				<!-- /span8 -->
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$("#client_name").focus();

	});
</script>

