$(document).ready(function() {

	$("#inp-cliente").keyup(function() {

		var i = $("#inp-cliente").val();

		if (i.length > 0) {
			
			$.ajax({ 
				type : 'get',
				url : '/dev_module-WEB/account-receivable/buscar-cliente/' +  i,
				statusCode : {
					200 : function(data) {
						
						var ip2 = [];
						
						for(var i = 0; i < data.length; i++){
							ip2.push({value: data[i].id,
						        label: data[i].nome,
						        desc: data[i].id
						        });
						}
						
						$( "#inp-cliente" ).autocomplete({
						      minLength: 0,
						      source: ip2,
						      focus: function( event, ui ) {
						        $( "#inp-cliente" ).val( ui.item.label );
						        return false;
						      },
						      select: function( event, ui ) {
						        $( "#inp-cliente" ).val( ui.item.label );
						        $( "#inp-cliente-id" ).val( ui.item.value );
						        $( "#inp-cliente-description" ).html( ui.item.desc );
						 
						        return false;
						      }
						    })
						    .autocomplete( "instance" )._renderItem = function( ul, item ) {
						      return $( "<li>" )
						        .append( "<a>" + item.label + "<br>" + item.desc + "</a>" )
						        .appendTo( ul );
						    };
						
						    console.log("entroy");
						    
					},
					404 : function(data) {
						$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
						$("#message-error").show(200);
					},
					400 : function(data) {
						$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
						$("#message-error").show(200);
					},
					500 : function(data) {
						$("#message-error").text("Ocorreu um problema no servidor ao pesquisar registros recentes!")
						$("#message-error").show(200);
					}
				}
			}).done(function() {

			});
			
		}
	});

});