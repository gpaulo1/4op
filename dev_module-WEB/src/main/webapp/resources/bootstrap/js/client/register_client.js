$(document).ready(function() {

	$("#complementary_information").hide();
	$("#complementary_information_juridic").hide();
	$("#alert_success_save_client").hide();

	// hide complementary informations
	$('#slc_tp_people').on('change', function() {
		if (this.value === 'FISICA') {
			$("#complementary_information_juridic").hide();
			$("#complementary_information_physical").show();
		} else if (this.value === 'JURIDICA') {
			$("#complementary_information_physical").hide();
			$("#complementary_information_juridic").show();
		}

	});

});

function tableAddContact() {
	
	var index = $("#tbl_add_contact tr:visible").length; 
	
	$("#tbl_add_contact > tbody")
			.append(
					"<tr id='row_"  + index + "'>" 
							+"<td><button type='button' id='remove_"  + index + "' class='btn btn-default btn-xs' onclick='deleteSelectedRow(this.id)'>-</button></td>"
							+ "<td><input id='name_"  + index + "' type='text' ></td>"
							+ "<td><input id='mail_"  + index + "' type='text' ></td>"
							+ "<td><input id='fone_"  + index + "' type='text' ></td>"
							+ "<td><input id='cargo_" + index + "' type='text' ></td>"
			      + "</tr>");
}

function deleteSelectedRow(row){
	
	$("#"+row).closest('tr').remove();
	
}

function hideShowButton(value) {

	if (value === 'hidden') {

		$("#complementary_information").show(150);
		$("#btn_complementary_information").attr("value", "displayed");

	} else if (value === 'displayed') {

		$("#complementary_information").hide(150);
		$("#btn_complementary_information").attr("value", "hidden");

	}

}

function saveClient(tpButton) {

	if(validateRequiredFields()) return;
	
	var tp_people 		= $('#slc_tp_people').val();
	var Client  	    = null;
	var url 			= null;
	
	if (tp_people === 'FISICA') {
		
		Client 				= new Object();

		Client.name 		= $("#client_name").val();
		Client.cpfCnpj 		= $("#client_physical_cpf").val();
		Client.rg 			= $("#client_physical_rg").val();
		Client.dateBirth	= $("#client_physical_dateBirth").val();
		Client.email 		= $("#client_physical_email").val();
		Client.workPhone 	= $("#client_physical_workPhone").val();
		Client.homePhone 	= $("#client_physical_homePhone").val();
		Client.observation 	= $("#client_physical_observation").val();
		
	} else if (tp_people === 'JURIDICA') {

		Client		 				= new Object();
		
		Client.name 				= $("#client_name").val();
		Client.cpfCnpj 				= $("#client_juridic_cnpj").val();
		Client.corporateName 		= $("#client_juridic_corporateName").val();
		Client.stateRegistration 	= $("#client_juridic_stateRegistration").val();
		Client.email 				= $("#client_juridic_email").val();
		Client.workPhone 			= $("#client_juridic_workPhone").val();
		Client.homePhone 			= $("#client_juridic_homePhone").val();
		Client.observation	 		= $("#client_juridic_observation").val();

	}
	
	//add contact to any of the Clients above
	Client.contacts = getContatoInfo();
	//end

	//add address to any of the Clients above 
	var Address				 = new Object();
	
	Address.cep				 = $("#address_cep").val();
	Address.address			 = $("#address_address").val();
	Address.number			 = $("#address_number").val();
	Address.complement		 = $("#address_complement").val();
	Address.neighborhood	 = $("#address_neighborhood").val();
	Address.city			 = $("#address_city").val();
	
	Client.address = Address;
	//end
	
	$.ajax({
		type 		: "post",
		dataType 	: "json",
		contentType : "application/json",
		data 		: JSON.stringify(Client),
		url 		: "client/save",
		statusCode 	: {
			200 	: function(data) {
				$.growl("<strong>Sucesso:</strong> O cliente " + data.name + " foi salvo no sistema.", {
					type: "success",
					animate: {
						enter: 'animated fadeInRight',
						exit: 'animated fadeOutRight'
					}
				});
				
				clearAllFields();
				
				if(tpButton == 1){
					$("#link_cliente").trigger("click");
				}
				
				addRowAfterSaveClient(data);
				
			},
			500 	: function(data) {
				
				$.growl("<strong>Erro:</strong> Ocorreu um erro no sistema. Tente novamente mais tarde.", {
					type: "error",
					animate: {
						enter: 'animated fadeInRight',
						exit: 'animated fadeOutRight'
					}
				});
				
			}
		}
	}).done(function() {

	});

}

function getContatoInfo(){
	
	var Contatos = [];
	var rowCount = ($('#tbl_add_contact tr').length) - 1;
	
	for(var i = 0; i <= rowCount; i++){
		
		var Contacts = [];
		
		for(var j = 0; j <= 4; j++){ 
			
			var tabela = $("#tbl_add_contact");
			var linha  = tabela.find("tr").eq(i + 1);   
			var coluna = linha.find("td").eq(j + 1);
			var input  = coluna.find("input");

			if(input.val() != undefined){
				Contacts[j] = input.val();
			}
			
		}
		
		if(Contacts.length != 0 && Contacts != []){
			Contatos.push({
				"name"  : Contacts[0],
				"email" : Contacts[1],
				"phone" : Contacts[2],
				"jobTitle" : Contacts[3],
			});
		}
		
	}
	
	return Contatos;
	
	
}

function clearAllFields(){
	
	$("#client_name").val("");
	$("#client_physical_cpf").val("");
	$("#client_physical_rg").val("");
	$("#client_physical_dateBirth").val("");
	$("#client_physical_email").val("");
	$("#client_physical_workPhone").val("");
	$("#client_physical_homePhone").val("");
	$("#client_physical_observation").val("");
	
	$("#client_name").val("");
	$("#client_juridic_cnpj").val("");
	$("#client_juridic_corporateName").val("");
	$("#client_juridic_stateRegistration").val("");
	$("#client_juridic_email").val("");
	$("#client_juridic_workPhone").val("");
	$("#client_juridic_homePhone").val("");
	$("#client_juridic_observation").val("");
	
	$("#address_cep").val("");
	$("#address_address").val("");
	$("#address_number").val("");
	$("#address_complement").val("");
	$("#address_neighborhood").val("");
	$("#address_city").val("");
	
	var rowCount = ($('#tbl_add_contact tr').length) - 1;
	
	//delete row of table
	if(rowCount > 1){
		for(var i = rowCount; i >= 2; i--){
			$("#tbl_add_contact tr:eq(" + i + ")").remove();
		}
	}
	
	$("#name_1").val("");
	$("#mail_1").val("");
	$("#fone_1").val("");
	$("#cargo_1").val("");
	
}

function validateRequiredFields(){
	if($("#client_name").val().length < 1){
		$.growl("<strong>Erro:</strong> O campo 'Nome do cliente' é obrigatório.", {
			type: "error",
			animate: {
				enter: 'animated fadeInRight',
				exit: 'animated fadeOutRight'
			}
		});
		return true;
	}
}

