$(document).ready(function() {

	$("#btn-find-by-name").click(function() {

		var value = $("#inp-value-find").val();

		$.ajax({
			type : "get",
			url : '/dev_module-WEB/account-receivable/search/' + value,
			statusCode : {
				200 : function(data) {
					
					$("#inp-value-find").val("");
					clearTable("account-table");
					addRowAccountReceivable("account-table", data)
					

				},
				404 : function(data) {
				},
				400 : function(data) {
				},
				500 : function(data) {
				}
			}
		}).done(function() {

		});

	});

});

function clearTable(){
	
}