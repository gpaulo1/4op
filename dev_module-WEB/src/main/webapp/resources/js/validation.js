var id;
var saldoId;
var buttonEntradaSaida = true;
var caixaId;

var Fluxo = new Object();
var Caixa = new Object();

$(document).ready(function() {

	$('.ui.slider').checkbox();
	
	$("#unique-id").change(function(){
		
		console.log($("#checkk").is(":checked"));
	});
	
	
	// aceitar apenas numeros
	jQuery('.numbersOnly').keyup(function() {
		this.value = this.value.replace(/[^0-9\.]/g, '');
	});

	// mascara de moeda
	$("#valor-registro").maskMoney();
});

function cadastrarRegistro() {

	//objeto para gravar novo registro
	var Fluxo = {
			"descricao" : $("#descricao-registro").val(),
			"valor" : $("#valor-registro").val(),
			"tpEntrada" : buttonEntradaSaida,
			"caixa" : {"id" : id},
			"saldo" : {"id" : saldoId}
		};
	console.log("id do caixa: " + Fluxo.caixa.id);
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(Fluxo),
		url : 'planejamento/novo-registro',
		statusCode : {
			200 : function(data) {
				addNewRowRegistro(data);
				console.log("fjojsdof: " + JSON.stringify(data.id));
				$("#msg-novo-registro").show(150);
				$('.modal-entrada').modal('hide');
				atualizarResumoFinanceiro(data);
			},
			404 : function(data) {
				alert(JSON.stringify(data));
			}
		}
	});
};

//funcao de selecionar caixa
function getRegistrosCaixaSelecionado(id){
	$('#table_id').DataTable().clear().draw();
	$.ajax({
		url : 'planejamento/buscar-fluxo/'+ id,
		statusCode : {
			200 : function(data) {

				var t = $('#table_fluxo').DataTable();
			    var counter = 1;

			    t.clear().draw();
			    
				console.log("entrou!: " + data.length);
				
				for(var i = 0; i < data.length; i++){
					console.log("Dados: " + data[i].id);
					
					t.row.add( [
				                data[i].valor,
				                data[i].descricao,
				                data[i].valor,
				                data[i].valor,
				            ] ).draw();
					
				}
				
				saldoId = data.id;
			},
			404 : function(data) {
			}
		}
	});
}

function atualizarResumoFinanceiro(data){
	$(".saldo-credito").text("R$ " + data.saldo.saldoCredito);
	$(".saldo-debito").text("R$ " + data.saldo.saldoDebito);
	$(".saldo-disponivel").text("R$ " + data.saldo.saldoDisponivel);
}

function getIdCaixa(idFluxo){
	disabledButtonClicked();
	id = idFluxo;
	activeButtonClicked();
	getRegistrosCaixaSelecionado(id);
	//id para salvar o fluxo com caixa
	caixaId = id;
	console.log("idCaixa: " + caixaId);
};

function activeButtonClicked(){
	$("#"+id).addClass("disabled").removeClass("positive").addClass("orange").text("Ativo");
}

function disabledButtonClicked(){
	$("#"+id).removeClass("disabled").removeClass("orange").addClass("positive").text("Fluxo");
}

function botaotpRegistro(id){
	if(id == 'btn-entrada'){
		$("#btn-saida").removeClass("active");
		$("#btn-entrada").addClass("active");
		
		buttonEntradaSaida = true;
		console.log("fjsofaij: " + buttonEntradaSaida);
	}else if(id == 'btn-saida'){
		$("#btn-entrada").removeClass("active");
		$("#btn-saida").addClass("active");
		buttonEntradaSaida = false;
	}
};

function inserirRegistroTabela(id){
	
Caixa.id = caixaId;
Fluxo.caixa = Caixa;
Fluxo.descricao = $("#descricao-registro").val();
Fluxo.valor = $("#valor-registro").val();

$.ajax({
	type : "post",
	dataType : "json",
	contentType : "application/json",
	data : JSON.stringify(Fluxo),
	url : 'fluxo/salvar-registro',
	statusCode : {
		200 : function(data) {
			var t = $('#table_fluxo').DataTable();
		
			t.row.add( [
		                data.data,
		                data.descricao,
		                data.valor,
		                data.valorFinal,
		            ] ).draw();
			
		},
		404 : function(data) {
			alert(JSON.stringify(data));
		}
	}
});
	
}
