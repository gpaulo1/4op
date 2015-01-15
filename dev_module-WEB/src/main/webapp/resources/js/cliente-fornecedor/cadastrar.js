var Cliente = new Object();

$(document).ready(function() {

	$("#inp-nome").click(function(){
		$("#class-inp-nome").removeClass("error");
	});
	$("#inp-razao-social").click(function(){
		$("#class-inp-razao-social").removeClass("error");
	});
	
	$("#btn-salvar-registro").click(function() {
		
		if($("#inp-nome").val() == "" && $("#slc-tp-pessoa").val() == "FISICA"){
			$("#class-inp-nome").addClass("error");
			$("#inp-nome").focus();
			$("html, body").animate({ scrollTop: 0 }, "slow");
		}else if($("#inp-razao-social").val() == "" && $("#slc-tp-pessoa").val() == "JURIDICA"){
			$("#class-inp-razao-social").addClass("error");
			$("#inp-razao-social").focus();
			$("html, body").animate({ scrollTop: 0 }, "slow");
		}else{
			cadastrar();
		}
	});
});

function cadastrar(){
	$.blockUI({ css: { 
	    border: 'none', 
	    padding: '10px', 
	    backgroundColor: '#000', 
	    '-webkit-border-radius': '5px', 
	    '-moz-border-radius': '5px', 
	    opacity: .5, 
	    color: '#fff' 
	} });
	
	Cliente.tipoPessoa = $("#slc-tp-pessoa").val();
	Cliente.cnpj = $("#inp-cnpj").val();
	Cliente.cpf = $("#inp-cpf").val();
	Cliente.inscricaoEstadual = $("#inp-inscricao-estadual").val();
	Cliente.rg = $("#inp-rg").val();
	Cliente.razaoSocial = $("#inp-razao-social").val();
	Cliente.fantasia = $("#inp-fantasia").val();
	Cliente.inscricaoMunicipal = $("#inp-inscricao-municipal").val();
	Cliente.nome = $("#inp-nome").val();
	Cliente.email = $("#inp-email").val();
	Cliente.telefone = $("#inp-telefone").val();
	Cliente.localizacao = { 
		bairro : $("#inp-bairro").val(),
		cidade : $("#inp-cidade").val(),
		cep : $("#inp-cep").val(),
		logradouro : $("#inp-endereco").val(),
		numero : $("#inp-numero").val(),
		estado : $("#slc-estado").val(),
	};
	Cliente.contato = {
		pessoaContato : $("#inp-cont-nome").val(),
		dataNascimento : $("#inp-cont-data-nascimento").val(),
		telefone : $("#inp-cont-telefone").val(),
		ramal : $("#inp-cont-ramal").val(),
		fax : $("#inp-cont-fax").val(),
		celular : $("#inp-cont-celular").val(),
		email : $("#inp-cont-email").val(),
		webPage : $("#inp-cont-site").val()
	};
	// add information about contact

	$('#example tbody').on('td', function() {
		alert(table.cell(this).data());
	});

	getValuesTable();
	
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(Cliente),
		url : '/dev_module-WEB/cliente/salvar',
		statusCode : {
			200 : function(data) {
				window.location.href ="/dev_module-WEB/cliente/listar";
			},
			404 : function(data) {
				$("html, body").animate({ scrollTop: 0 }, "slow");
				$("#message-error").show(200);
				$.unblockUI();
			},
			400 : function(data) {
				$("html, body").animate({ scrollTop: 0 }, "slow");
				$("#message-error").show(200);
				$.unblockUI();
			},
			500 : function(data) {
				$("html, body").animate({ scrollTop: 0 }, "slow");
				$("#message-error").show(200);
				$.unblockUI();
			}
		}
	}).done(function() {

	});
}

function getValuesTable() {

	var itens = [];
	
	var table = $('#tbl_enderecos').DataTable();
	var data = table.rows().data();
	for (var i = 0; i < data.length; i++) {
			var d = table.row(i).data();
			itens.push({tipoEndereco : d[0],
					tipoPessoa : d[1],
					endereco : d[2]
			});
	}
	Cliente.endContatos = itens;
}
