jQuery(function($) {
	$(".date").mask("99/99/9999");
	$(".inp-cnpj").mask("99.999.999/9999-99");
	$(".inp-cep").mask("99.999-999");
	$(".inp-cpf").mask(" 999.999.999-99");
	$(".inp-tel").mask("(99) 99999-9999");
	$(".inp-only-number").mask("09");
	
	//called when key is pressed in textbox
	  $(".only-number").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#errmsg").html("Digits Only").show().fadeOut("slow");
	               return false;
	    }
	   });
	
	
	
});

