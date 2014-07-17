//= require jquery-ui
//= require_self
/**
 * Desde autocomplete.js 
 
$(function(){
	$("#cliente").autocomplete({
		source:'/kio-core/cliente/getClientesJSON2',
		minLength:3,
		select:function(e,ui){
			console.log('Valor seleccionado: '+ui.item.id);
			//$("#cliente.id").val(ui.item.id);
		}
	});
});
*/
$(document).ready(function(){
	$("#autoCompleteCliente").autocomplete({
		source:'/kio-core/cliente/getClientesJSON',
		minLength:2
	});
});