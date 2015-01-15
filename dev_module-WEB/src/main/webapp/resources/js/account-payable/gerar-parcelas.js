$(document).ready(function(){
	
	var mo = moment($("#inp-vencimento").val()).format("DD/MM/YYYY");
	
	mo2 = moment(mo).add(1, 'month').calendar();
	
	console.log("moemnt: " + moment(mo2).format("DD/MM/YYYY"));
	
	$("#inp-parcelas").keyup(function(){
		
		$("#div-listar-parcelas").show(150);
		
		if($("#inp-parcelas").val() == "" || $("#inp-parcelas").val() == null || $("#inp-parcelas").val() == undefined){
			$("#div-listar-parcelas").hide(150);
		}
		
		$("#tbl-parcelas > tbody").html("");
		
		var qntParcelas = $("#inp-parcelas").val();
		
		var valorParcela = $("#inp-valor").val() / qntParcelas;
		
		for(var i = 1; i <= qntParcelas; i++){
			$("#tbl-parcelas > tbody:last").append("<tr>" +
					"<td>" + i + "</td>" +
					"<td><input type='text' id='inp-data-" + i + "' value = '" + gerarDataParcelas($("#inp-vencimento").val(), i) + "' /></td>" +
					"<td> <input type='text' id='inp-valor-" + i + "'  class='mini' value = '" + (Math.round(valorParcela * 100)/100).toFixed(2) + "'/> </td>" +
					"<td> " + createFormaPagamento(i) + "</td>" + 

			"</tr>")
		}
		
		
	});
	
});

function gerarDataParcelas(data,indice){
	
	var dataFormatada =  moment(data).add(indice, "months");
	
	console.log("***************************");
	
	return moment(dataFormatada).format("DD/MM/YYYY");
}

function createFormaPagamento(i){
	
	var selectField = "<select id='inp-pagamento-" + i + "'>";
	selectField += "<option value='NO_SELECTED'></option>";
	selectField += "<option value='BANCO'>Banco</option>";
	selectField += "<option value='BNDES'>BNDES</option>";
	selectField += "<option value='BOLETO'>Boleto</option>";
	selectField += "<option value='CARTAO_DE_CREDITO'>Cartão de Crédito</option>";
	selectField += "<option value='CARTAO_DE_DEBITO'>Cartão de Débito</option>";
	selectField += "<option value='CH_DESCONTADO'>CH Descontado</option>";
	selectField += "<option value='CHEQUE'>Cheque</option>";
	selectField += "<option value='DDA'>DDA</option>";
	selectField += "<option value='DEBITO_AUTOMATICO'>Débito Automático</option>";
	selectField += "<option value='DEPOSITO_EM_CONTA_CORRENTE'>Depósito em C/C</option>";
	selectField += "<option value='DEPOSITO_IDENTIFICADO'>Depósito Identificado</option>";
	selectField += "<option value='DINHEIRO'>Dinheiro</option>";
	selectField += "<option value='DOC'>DOC</option>";
	selectField += "<option value='DP_DESCONTADA'>DP Descontada</option>";
	selectField += "<option value='DUPLICATA_MERCA'>Duplicata Merca</option>";
	selectField += "<option value='FATURADO'>Faturado</option>";
	selectField += "<option value='FATURAR'>Faturar</option>";
	selectField += "<option value='LOTERICA'>Lotérica</option>";
	selectField += "<option value='OUTROS'>Outros</option>";
	selectField += "<option value='PAGAMENTO_ONLINE'>Pagamento Online</option>";
	selectField += "<option value='PERMUTA'>Permuta</option>";
	selectField += "<option value='TED'>Ted</option>";
	selectField += "<option value='TRANSFERENCIA'>Transferência</option>";
	selectField += "</select>";
	
	return selectField;
	
}












