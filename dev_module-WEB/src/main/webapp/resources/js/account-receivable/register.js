$(document).ready(function() {

	var infoField = false;
	$("#info-field").hide();

	$("#info_button").click(function() {
		if (infoField == false) {
			//deslizar pagina ao expandir
			$('html, body').animate({
			    scrollTop: $(this).offset().top
			  }, 200);
			//end
			$("#info-field").show(200);
			infoField = true;
		} else if (infoField == true) {
			$("#info-field").hide(200);
			infoField = false;
		}
	});

});
