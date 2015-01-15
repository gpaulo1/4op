jQuery(function($) {
	$(".msk-date").mask("99/99/9999");
	$(".msk-cnpj").mask("99.999.999/9999-99");
	$(".msk-cep").mask("99.999-999");
	$(".msk-cpf").mask(" 999.999.999-99");
	$(".msk-cel").mask("(99) 9 9999-9999");
	$(".msk-homephone").mask("(99) 9999-9999");
	$(".msk-only-number").mask("09");
	
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

