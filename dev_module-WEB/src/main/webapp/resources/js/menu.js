$(document).ready(function(){
	$("#submenu").hide();
	
	$("#financa").click(function(){
		removeActive();
		$(this).addClass('active');
		$("#submenu").show(100);
	});
	$("#dashboard").click(function(){
		removeActive();
		$(this).addClass('active');
		$("#submenu").hide();
	});
});

function removeActive(){
		$("#financa").removeClass('active');
		$("#dashboard").removeClass('active');
}