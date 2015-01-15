<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Quatro Operações</title>

<!-- jQuery -->
<script type="text/javascript" src="<c:url value="/bootstrap/js/jquery-1.11.2.min.js" />"></script>
 

<!-- Validator -->
<script type="text/javascript"
	src="<c:url value="/bootstrap/js/bootstrapValidator.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/bootstrap/js/field_validation/registerpage_validation.js" />"></script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/bootstrap/css/bootstrapValidator.min.css" />" />

<!-- login requests -->
<script type="text/javascript"
	src="<c:url value="/bootstrap/js/login/request_login.js" />"></script>

<!-- Bootstrap Core JavaScript -->
<script type="text/javascript"
	src="<c:url value="/bootstrap/js/bootstrap.min.js" />"></script>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/bootstrap/css/register-page/bootstrap.min.css" />" /> 

<!-- Custom CSS -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/bootstrap/css/portfolio-item.css" />" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">4OP SysAdmin</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">Sobre</a></li>
				<li><a href="#">Quem somos ?</a></li>
			</ul>
			<button type="button" class="btn btn-primary navbar-btn pull-right"
				data-toggle="modal" id="logar-btn" data-target="#myModal">Já sou
				cadastrado</button>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Content -->
	<div class="container">

		<!-- Portfolio Item Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					4 Operações <small>Sistema de Controle Financeiro</small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Portfolio Item Row -->
		<div class="row">

			<div class="col-md-8">
				<img class="img-responsive"
					src="<c:url value="/bootstrap/img/register-page/finance[register_page].jpg"/>"
					alt="">
			</div>

			<div class="col-md-4">
				<h3>Seja bem vindo ao 4OP</h3>
				<p>Você está preste a fazer parte do nosso sistema! O sistema
					4OP foi desenvolvido com a intenção de auxilia-lo em suas finanças
					com o maor nível de simplicidade, para que possa obter o máximo de
					resultado e transparência no final do mês.</p>
				<p>Não perca mais tempo, se cadastre e comprove a eficiência de
					nosso sistema.</p>
				<h3>Cadastro</h3>

				<c:if test="${statusMsg == 'unavaible'}">
					<div class="alert alert-danger" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> <span class="sr-only">Error:</span>
						${msg }
					</div>
				</c:if>

				<form:form action="create-user" id="create-user-id"
					commandName="registerUser" class="registerForm"
					modelAttribute="user">


					<div class="form-group">
						<label for="username">Usuário</label>
						<form:input type="text" class="form-control" id="username"
							path="userName" placeholder="Nome de usuário" />
					</div>

					<div class="form-group">
						<label for="email">Email</label>
						<form:input type="email" class="form-control" path="email"
							placeholder="Endereço de email" />
					</div>

					<div class="form-group">
						<label for="password">Senha</label>
						<form:input type="password" class="form-control" path="password"
							placeholder="Senha de acesso" />
					</div>

					<button type="submit" class="btn btn-primary pull-right">Cadastrar</button>


				</form:form>

			</div>

		</div>
		<!-- /.row -->

		<hr>

		<!-- Footer -->
		<footer>
		<div class="row">
			<div class="col-lg-12">
				Oferta de teste do sistema limitada á 30 dias. Após esse período
				será cobrado uma taxa de acordo com o plano escolhido pelo cliente.
				Caso o mesmo não queira assinar após o períodos de teste, a conta
				será inativada.
				<p>Todos os direitos reservados &copy; 4op.com 2015</p>
			</div>
		</div>
		<!-- /.row --> </footer>

	</div>
	<!-- /.container -->

	<!-- Modal of login-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Logar no 4OP</h4>
				</div>
				<div class="modal-body" id="modal-body">

					<form>
						<div class="form-group">
							<label for="exampleInputEmail1">Email</label> <input
								type="text" class="form-control" id="email-login"
								placeholder="Email cadastrado">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Senha</label> <input
								type="password" class="form-control" id="password-login"
								placeholder="Senha de acesso">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					<button type="button" id="login-btn" class="btn btn-primary" data-loading-text="Loading...">Entrar</button>
				</div>
			</div>
		</div>
	</div>
	<!--.modal-->

<script>
  $('#login-btn').on('click', function () {
    var $btn = $(this).button('loading')
  })
</script>

</body>

</html>