function clearTable(idTable) {
	
	var table = $('#' + idTable).DataTable();
	table.clear().draw();
	
}

function addRowAccountReceivable(idTable, data) {
	
	var table = $('#' + idTable).DataTable();
	for(var i = 0; i < data.length; i++){
		table.row.add( [
	            data[i].dataVencimento,
	            data[i].descricao,
	            data[i].valor,
	            data[i].formaPagamento,
	            data[i].formaPagamento,
	            "<div class='mini ui teal right pointing dropdown icon button'>"+
				"<i class='settings icon'></i>"+
				"<div class='menu'>"+
					"<a href='account-receivable/listar/${account.id}' class='item'>"+
						"<i class='edit icon'></i>Editar"+
					"</a>"+
					"<div class='item'>"+
						"<i class='delete icon'></i>Remove"+
					"</div>"+
					"<div class='item'>"+
						"<i class='hide icon'></i>Hide"+
					"</div>"+
						"</div>"+
			"</div>"
	        ] ).draw();
		
	}
}