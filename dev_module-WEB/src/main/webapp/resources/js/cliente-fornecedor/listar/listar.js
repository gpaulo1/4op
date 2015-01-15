$(document).ready(function() {

	var urlSolution = "/dev_module-WEB"; 
	
$("#choice-1").click(function(){
	
	ajaxRequestFunc("get", urlSolution+"/cliente/find-all");
	
});
	
$("#choice-2").click(function(){
		
	ajaxRequestFunc("get", urlSolution+"/cliente/find-clientes", "user");
		
});
	
	
$("#choice-3").click(function(){
	
	ajaxRequestFunc("get", urlSolution+"/cliente/find-empresas", "building");
		
});
	
$("#btn-find-by-name").click(function(){
	
	console.log("entrou");
	
	ajaxRequestFunc("get", urlSolution+"/cliente/find-by-name/"+ $("#inp-value-find").val(), null);
	

});

	$(".desativar").click(function() {

		console.log("ksdnjsdfn");
		
		hideMsgs();
		
		$("#tbl-main").block({ message: "Carregando..." });
		
		var idRow;
		var table = $('#tbl-main').DataTable();

		$('#tbl-main tbody').on('click', 'tr', function() {
			idRow = table.row(this).index();
		});

		var id = $(this).attr('id');

		disableRegistry(id);

	});
	
	$(".editar").click(function() {

		$("#tbl-main").block({ message: "Carregando..." });
		
		var idRow;
		var table = $('#tbl-main').DataTable();

		$('#tbl-main tbody').on('click', 'tr', function() {
			idRow = table.row(this).index();
		});

		var id = $(this).attr('id');

		$.ajax({
			type : "get",
			url : '/cliente/editar/' + id,
		})

	});
	
});

function hideMsgs(){
	$("#message-success").hide();
	$("#message-error").hide();
}
 
function identifierTypeOfTpPessoa(data){
	if(data.tipoPessoa == "FISICA"){
    	return "<i class='user icon popup' data-content='Pessoa Fisíca'></i>"
    };
    if(data.tipoPessoa == "JURIDICA"){
    	return "<i class='building icon popup' data-content='Pessoa Jurídica'></i>"
    };
    return null;
}

function showModalRemove(link) { 
	var id =  $(link).attr("idcliente");
	
	$("#inp-idcliente-mdl").val(id);
	
	$('#modal-remove-rgt')
	  .modal('show')
	;
	
	$("#lbl-msg-modal").text("Você tem certeza que deseja desativar este registro ?");

	disableRegistry(id);
	
}

//request to disable registry
function disableRegistry(id){
	$.ajax({
		type : "get",
		url : '/dev_module-WEB/cliente/desativar/' + id,
		statusCode : {
			200 : function(data) {
				table.row(idRow).remove().draw();
				$('#tbl-main').unblock(); 
				$("#message-success").text("Registro desativado com sucesso!").show(200);
			},
			404 : function(data) {
				$('#tbl-main').unblock(); 
				$("#message-error").text("Ocorreu um erro ao desativar o registro!").show(200);
			},
			400 : function(data) {
				$('#tbl-main').unblock(); 
				$("#message-error").text("Ocorreu um erro ao desativar o registro!").show(200);
			},
			500 : function(data) {
				$('#tbl-main').unblock(); 
				$("#message-error").text("Ocorreu um erro no servidor ao desativar o registro!").show(200);
			}
		}
	}).done(function() {

	});
}

function checkTypeOfRegistry(data){
	if(data.tipoPessoa == 'FISICA'){
		return data.nome;
	}else if(data.tipoPessoa == 'JURIDICA'){
		return data.fantasia;
	}
}

function checkTypeOfDocument(data){
	if(data.tipoPessoa == 'FISICA'){
		return data.cpf;
	}else if(data.tipoPessoa == 'JURIDICA'){
		return data.cnpj;
	}
}

function ajaxRequestFunc(type, url, icon){
	
	hideMsgs();
	
	$("#tbl-main").block({ message: "Carregando..." });
	
	$.ajax({
		type : type,
		url : url ,
		statusCode : {
			200 : function(data) {
				var t = $('#tbl-main').DataTable();
				t.clear().draw();
				
				for(var i = 0; i < data.length; i++){
						
				        t.row.add( [
				            "<i class='"+ icon +" icon popup' data-content='Pessoa Jurídica'></i>",
				            checkTypeOfRegistry(data[i]),
				            checkTypeOfDocument(data[i]), 
				            data[i].telefone,
							"<a href='/dev_module-WEB/cliente/editar/"+ data[i].id +"'' class='ui twitter mini right pointing dropdown icon button'>"+
							"<i class='hide icon'></i>"	+ 
							"</a>",
							"<a href='#' class='ui mini primary right pointing dropdown icon button'>" +
							"<i class='remove icon'></i>"+
							"</a>"
				        ] ).draw();
				};
				$('#tbl-main').unblock(); 
				
				
			},
			404 : function(data) {
				$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
				$("#message-error").show(200);
			},
			400 : function(data) {
				$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
				$("#message-error").show(200);
			},
			500 : function(data) {
				$("#message-error").text("Ocorreu um problema no servidor ao pesquisar registros recentes!")
				$("#message-error").show(200);
			}
		}
	}).done(function() {

	});
	
}


