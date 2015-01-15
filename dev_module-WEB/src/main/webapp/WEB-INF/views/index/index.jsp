<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<div class="ui success message">
	<i class="close icon"></i>
	<div class="header">Registro inserido com sucesso!</div>
</div>

<div class="ui form segment">
	<div class="ui ribbon label">Dados pessoais</div>
	<div class="one field">
		<div class="field">
			<div id="container" style="width: 100%; height: 400px;"></div>
		</div>
	</div>
	<div class="two fields">
		<div class="field">
			<div id="container1" style="width: 100%; height: 400px;"></div>
		</div>
		<div class="field">
			<div id="container2" style="width: 100%; height: 400px;"></div>
		</div>
	</div>
	<div class="ui ribbon label">Dados profissionais</div>
	<div class="ui form">
		<div class="date field">
			<label>Birthday</label> <input type="text" placeholder="xx/xx/xxxx">
		</div>
	</div>
	<div class="field">
		<label>Gender</label>
		<div class="ui fluid selection dropdown">
			<div class="text">Select</div>
			<i class="dropdown icon"></i> <input type="hidden" name="gender">
			<div class="menu">
				<div class="item" data-value="male">Male</div>
				<div class="item" data-value="female">Female</div>
			</div>
		</div>
	</div>
	<div class="field">
		<label>Username</label> <input placeholder="Username" type="text">
	</div>

	<div class="ui red vertical demo sidebar menu">
		<a class="item"> <i class="home icon"></i> Home
		</a> <a class="active item"> <i class="heart icon"></i> Current
			Section
		</a> <a class="item"> <i class="facebook icon"></i> Like us on
			Facebook
		</a>
		<div class="item">
			<b>More</b>
			<div class="menu">
				<a class="item">About</a> <a class="item">Contact Us</a>
			</div>
		</div>
	</div>

	<div class="field">
		<label>Password</label> <input type="password">
	</div>
	<div class="inline field">
		<div class="ui checkbox">
			<input type="checkbox"> <label>I agree to the Terms
				and Conditions</label>
		</div>
	</div>
	<div class="ui blue submit button">Submit</div>
</div>

<script type="text/javascript">
	
</script>

<script type="text/javascript">
	$('.ui.dropdown').dropdown();
</script>