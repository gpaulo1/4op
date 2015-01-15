$(document).ready(function() {

	$("#validate-send").click(function() {

		var con1 = $("#inp-descricao-receita").val();
		var con2 = $("#inp-vencimento").val();
		var con3 = $("#inp-valor").val();

		var op = false;

		if (con1.length == 0) {
			$("#class-descricao-receita").addClass("error");
			op = false;
		} else {
			$("#class-descricao-receita").removeClass("error");
			op = true;
		}

		if (con2.length == 0) {
			$("#class-vencimento").addClass("error");
			op = false;
		} else {
			$("#class-vencimento").removeClass("error");
			op = true;
		}

		if (con3.length == 0) {
			$("#class-valor").addClass("error");
			op = false;
		} else {
			$("#class-valor").removeClass("error");
			op = true;
		}

		if (op == true) {
			createAccountObject();
//			$("#form-id").submit();
		} else {
			$("#bar-one").addClass("active");
		}

	});

});

function createAccountObject() {
	
	getParcelas();
	
	var Account = new Object();
	var Cliente = new Object();

	Account.descricao = $("#inp-descricao-receita").val();
	Account.id = $("#inp-id").val();
	Account.dataVencimento = "2012-11-11";
	Account.valor = $("#inp-valor").val();
	console.log("Data emissao : " + $("#inp-data-emissao").val());
//	var data = $('#inp-data-emissao').val();
//	today = $('#inp-data-emissao').val();
//	var dateString = today.format("dd-m-yy");
//	console.log("data: " + dateString);
//	Account.dataEmissao = dateString;
	Account.numeroDocumento = $("#inp-numero-documento").val();
	Account.formaPagamento = $("#slc-forma-pagamento").val();
	Account.observacao = $("#inp-obs").val();
	Account.categoria = $("#slc-categoria").val();
	console.log("aojfoiajioj: " + $("#slc-tp-registro").val());
	Account.tipoRegistro = $("#slc-tp-registro").val();
	Account.ocorrencia = $("#slc-ocorrencia").val();
	Account.quantidadeParcela = $("#inp-parcelas").val();

	Cliente.id = $('input[data-type="id-cliente"]').val();
	Account.cliente = Cliente;
		
	Account.parcelas = getParcelas(Account);

	console.log("etnrioajfd2 2222': " + JSON.stringify(Account));
	console.log(" aqui : " + $("#tbl-parcelas tr").length);

	Account.tipoConta = $("#inp-tipoConta").val();
	
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(Account),
		url : '/dev_module-WEB/account-receivable/save',
		statusCode : {
			200 : function(data) {
				window.location.href = "/dev_module-WEB/cliente/listar";
			},
			404 : function(data) {
				$("html, body").animate({
					scrollTop : 0
				}, "slow");
				$("#message-error").append("Erorrrrrrrrrrrrrrr").show(200);
			},
			400 : function(data) {
				$("html, body").animate({
					scrollTop : 0
				}, "slow");
				$("#message-error").append("Ocorreu um erro ao salvar o registro. Verifique sua conexão com a internet ! ");
				$("#message-error").show("200");
			},
			500 : function(data) {
				$("html, body").animate({
					scrollTop : 0 
				}, "slow");
				$("#message-error").show(200);
				$.unblockUI();
			}
		}
	}).done(function() {

	});
 
}	

function getParcelas(Account){
	
	var indexTableRow = $("#tbl-parcelas > tbody > tr").length;

	var jsonObject = []; 
	
	for(var i = 1; i <= indexTableRow; i++){
		
		var parcelas = {};
//		$("#inp-data-" + i).val()
		parcelas["status"] = "ativa";
//		parcelas["vencimento"] = "2012-10-10";
		parcelas["valor"] = ($("#inp-valor-" + i).val());
		parcelas["formaPagamento"] = ($("#inp-pagamento-" + i).val());
		
		jsonObject.push(parcelas);
		
	}
	
	return jsonObject; 
	
}
