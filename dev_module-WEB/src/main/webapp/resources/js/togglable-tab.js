$(document).ready(function(){
	$("#fixe-price-select").show();
	$("#per-hour-select").hide();
	
	
	$("#fixed-price").click(function(){
		$("#fixe-price-select").show();
		$("#per-hour-select").hide();
		$("#fixed-price").prop('disabled',true);
		$("#per-hour").prop('disabled', false);
	});
	
	$("#per-hour").click(function(){
		$("#fixe-price-select").hide();
		$("#per-hour-select").show();
		$("#fixed-price").prop('disabled',false);
		$("#per-hour").prop('disabled', true);
	});
	
});