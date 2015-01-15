$(document).ready(function() {
	
	
	
	
});

function gerarObjetoAccount(){
	
	
	
}

function selectChanged(newvalue) {
	
	console.log(newvalue)
	
	if (newvalue == 'PARCELADO') {
		$("#qnt-parcelas").show(150);
		return;
	}
	
	if (newvalue == 'UNICA') {
		$("#qnt-parcelas").hide(150);
		$("#div-listar-parcelas").hide(150);
		return;
	}
	
}