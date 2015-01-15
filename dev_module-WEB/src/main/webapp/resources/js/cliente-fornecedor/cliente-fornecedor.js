//IP - Informações Pessoais
//fd - Field
$(document).ready(function() {
	var active = false
	
	$("#fd-cpf-endereco").hide();
	
	$(".form-cliene-fornecedor").hide();

	$(".fl-cnpj-IP").show();
	$(".fl-insc.estadual-IP").show();
	
	$(".fl-cpf-IP").hide();
	$(".fl-rg-IP").hide();
	$(".fild-fisico_01").hide();

	//exibir - esconder funcionalidades de enderecos
	$("#endereco_button").click(function() {
		if (active == false) {
			$(".form-cliene-fornecedor").show(200);
			
			//deslizar pagina ao expandir
			$('html, body').animate({
			    scrollTop: $(this).offset().top
			  }, 200);
			//end
			
			active = true;
		}else if(active == true){
			$(".form-cliene-fornecedor").hide(200);
			active = false;
		}
	});
	//end
	
	//add row tabela de enderecos
	var t = $('#tbl_enderecos').DataTable();
    var counter = 1;
 
    $('#add-row').on( 'click', function () {
        t.row.add( [
            $("#tp-endereco").val(),
            tpPessoa(),
            $("#inp-endereco-end").val() + ", " + $("#inp-numero-endereco").val() + " " + $("#inp-complemento-endereco").val() + " - " + $("#inp-bairro-endereco").val() + ", CEP: " + $("#inp-cep-endereco").val() + " - " + $("#inp-cidade-endereco").val() + "/" + $("#slc-estado-endereco").val(),
            "<div class='mini ui primary icon button remove-row'>" +
            	"<i class='trash icon'></i>" +
            "</div>",
        ] ).draw();
 
        counter++;
    } );
    //end	
    
    //remove row 
    var table = $('#tbl_enderecos').DataTable();
    
    $('#tbl_enderecos tbody').on( 'click', '.remove-row', function () {
        table
            .row( $(this).parents('tr') )
            .remove()
            .draw();
    } );
    //end
    
    //Procurar CEP
    $("#find-cep").click(function(){
    	$.ajax({
    		  url: 'http://cep.s1mp.net/' + $("#inp-cep").val(),
    		  dataType: 'jsonp',
    		  crossDomain: true,
    		  jsonpCallback: 'getCep',
    		  success: function(response){
    		    console.log("alkff: " + JSON.stringify(response.data.cidade));
    		    $("#inp-cidade").val(response.data.cidade);
    		    $("#inp-endereco").val(response.data.logradouro);
    		    $("#inp-bairro").val(response.data.bairro);
    		    $("#inp-complemento").val(response.data.tp_logradouro);
    		    $("#slc-estado").val("sp");
    		  }
    		})
    });
    //END
    
    //Procurar CEP | Endereços
    $("#find-cep-end").click(function(){
    	$.ajax({
    		  url: 'http://cep.s1mp.net/' + $("#inp-cep-endereco").val(),
    		  dataType: 'jsonp',
    		  crossDomain: true,
    		  jsonpCallback: 'getCep',
    		  success: function(response){
    		    $("#inp-cidade-endereco").val(response.data.cidade);
    		    $("#inp-endereco-endereco").val(response.data.logradouro);
    		    $("#inp-bairro-endereco").val(response.data.bairro);
    		    $("#inp-complemento-endereco").val(response.data.tp_logradouro);
    		    $("#slc-estado").val("sp");
    		  }
    		})
    });
    //END
    
    //Definir tp pessoa (enderecos)
    $("#slc-tp-pessoa-endereco").change(function(){
    	console.log("testando")
    	var tpPessoa = $("#slc-tp-pessoa-endereco").val();
    	
    	if(tpPessoa == "CPF"){
    		$("#fd-cpf-endereco").show();
    		$("#fd-cnpj-endereco").hide();
    	}else if(tpPessoa == "CNPJ"){
    		$("#fd-cpf-endereco").hide();
    		$("#fd-cnpj-endereco").show();
    	}
    	
    });
    
    //definir tp pessoa (CNPJ/CPF)
    $("#slc-tp-pessoa").change(function(){
    	var tpPessoa = $("#slc-tp-pessoa").val();
    	
    	if(tpPessoa == "FISICA"){
    		$(".fl-cnpj-IP").hide();
    		$(".fl-cpf-IP").show();
    		
    		$(".fl-insc_estadual-IP").hide();
    		$(".fl-rg-IP").show();
    		
    		$(".fild-juridico_01").hide();
    		$(".fild-fisico_01").show();
    		
    	}else if(tpPessoa == "JURIDICA"){
    		$(".fild-juridico_01").show();
    		$(".fild-fisico_01").hide();
    		
    		$(".fl-cnpj-IP").show();
    		$(".fl-cpf-IP").hide();
    		
    		$(".fl-insc_estadual-IP").show();
    		$(".fl-rg-IP").hide();
    		
    	}
    });
    //END
    
});

function clearAllInputs(){
	$("#inp-cnpj").val("");
	$("#inp-cpf").val("");
	$("#inp-inscricao-estadual").val("");
	$("#inp-rg").val("");
	$("#inp-razao-social").val("");
	$("#inp-fantasia").val("");
	$("#inp-inscricao-municipal").val("");
	$("#inp-nome").val("");
	$("#inp-email").val("");
	$("#inp-telefone").val("");
	$("#inp-bairro").val("");
	$("#inp-cont-nome").val("");
	$("#inp-cont-telefone").val("");
	$("#inp-cont-ramal").val("");
	$("#inp-cont-fax").val("");
	$("#inp-cont-celular").val("");
	$("#inp-cont-email").val("");
	$("#inp-cont-site").val("");
	$("#inp-bairro").val("");
	$("#inp-cidade").val("");
	$("#inp-cep").val("");
	$("#inp-endereco").val("");
	$("#inp-numero").val("");
	$("#inp-estado").val("");
	
	var table = $('#tbl_enderecos').DataTable();
	 
	table
	    .clear()
	    .draw();
	
}

function tpPessoa(){
	if($("#slc-tp-pessoa-endereco").val() == 'CPF'){
		return "(PF) - " + $("#inp-cpf-endereco").val();
	}else if($("#slc-tp-pessoa-endereco").val() == 'CNPJ'){
		console.log("entoeroei");
		return "(PJ) - " + $("#inp-cnpj-endereco").val();
	}
}