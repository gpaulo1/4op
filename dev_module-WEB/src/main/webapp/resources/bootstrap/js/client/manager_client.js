
$(document).ready(function(){
	
	//initialize table 
	var table = $('#tbl_show_contacts').dataTable( {
        "searching": false,
        "ordering": false,
        "info":     false,
        "language": {
            "lengthMenu": "Display _MENU_ records per page",
            "zeroRecords": "Nothing found - sorry",
            "info": "Showing page _PAGE_ of _PAGES_",
            "infoEmpty": "Nenhum dados disponível.",
            "infoFiltered": "(filtered from _MAX_ total records)"
        },
        "dom": '<"toolbar">frtip' 
    } );
	//end
	
	//initialize click select table
	$('#tbl_show_contacts tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
	//end
	
});

function addRowAfterSaveClient(client){
	
	var table = $('#tbl_show_contacts').DataTable();
	
	$.ajax({
		url 		: "client/refresh",
		statusCode 	: {
			200 	: function(data) {
				table.clear().draw();
				
				for(var i = 0; i <= data.length; i++){
					
					table.row.add( [
						            "<input type='checkbox'>",
						            data[i].name,
						            data[i].cpfCnpj,
						            data[i].email,
						            data[i].workPhone,
						            data[i].dateRegistration
						        ] ).draw().node();
					
				}
				
			},
			500 	: function(data) {
				
			}
		}
	})
	
	
	console.log("jsiosdhfoi");
	
	
}
