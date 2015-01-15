<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<div class="ui teal large menu">
	<a class="active item" href="/dev_module-WEB/test"> <i
		class="home icon"></i> Home
	</a>

	<div class="ui dropdown item">
		Cadastros <i class="dropdown icon"></i>
		<div class="menu">
			<a class="item" href="<c:url value="/conta-bancaria" />">Contas Bancárias</a> <a
				class="item" href="<c:url value="/cliente/listar" />">Consultar</a>
		</div>
	</div>
	<a class="item" href="/dev_module-WEB/planejamento"> <i
		class="mail icon"></i> Planejamento
	</a>
	<div class="ui dropdown item">
		Cliente <i class="dropdown icon"></i>
		<div class="menu">
			<a class="item" href="<c:url value="/cliente/novo" />">Novo</a> <a
				class="item" href="<c:url value="/cliente/listar" />">Consultar</a>
		</div>
	</div>
	<div class="ui dropdown item">
		Financeiro <i class="dropdown icon"></i>
		<div class="menu">
			<a class="item" href="<c:url value="/account-payable" />">Contas
				a Pagar</a> <a class="item" href="<c:url value="/account-receivable" />">Contas
				a Receber</a>
		</div>
	</div>
	<div class="right menu">
		<div class="item">
			<div class="ui icon input">
				<input type="text" placeholder="Search..."> <i
					class="search link icon"></i>
			</div>
		</div>
		<div class="ui dropdown item">
			Language <i class="dropdown icon"></i>
			<div class="menu">
				<a class="item">English</a> <a class="item">Russian</a> <a
					class="item">Spanish</a>
			</div>
		</div>
		<div class="item">
			<div class="ui teal button">Sign Up</div>
		</div>
	</div>
</div>