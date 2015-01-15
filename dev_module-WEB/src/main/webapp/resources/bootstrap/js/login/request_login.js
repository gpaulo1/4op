$(document).ready(function() {

	$("#login-btn").click(function() {

		if($("#email-login").val() == null || $("#username-login").val() == undefined || $("#username-login").val() == ''){
			$("#username-login").val(null);
		}
		
		if($("#email-login").val() == null || $("#email-login").val() == undefined || $("#email-login").val() == ''){
			$("#email-login").val(null);
		}
		
		url = "request-login/"+ $("#email-login").val() + "/" + $("#password-login").val();
		
		$.ajax({
			url          : url,
			statusCode   : {
				200 : function(data) {
					
					if(data == 'denied'){
						
						$("#modal-body").append(createMsgErrorLogin("Usuário ou senha inválidos."));
						$('#login-btn').button('reset');
						
					}else{
						
						$(".login-error-msg").remove();
						$('#login-btn').button('reset');
						
						window.location.replace("dashboard");
						
					}
					
				},
				500 : function(){
					$("#modal-body").append(createMsgErrorLogin("Ocorreu um erro no servidor! Tente novamente mais tarde."));
				}
			}
		})

	});

});

function createMsgErrorLogin(pMsg){

	$(".login-error-msg").remove();
	
	var msg = "<div class='alert alert-danger login-error-msg' role='alert'>";
		msg += "<span class='glyphicon glyphicon-exclamation-sign'";
		msg += "aria-hidden='true'></span> <span class='sr-only'>Error:</span>";
		msg += pMsg;
		msg += "</div>";
		
	return msg;
	
}