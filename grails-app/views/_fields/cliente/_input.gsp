<%@page expressionCodec="none" %>
<asset:stylesheet src="jquery-ui.css"/>
<asset:javascript src="jquery-ui/autocomplete.js"/>
<g:hiddenField id="clienteId" name="${property}.id" value="${value?.id}" />
<input type="text" id="${property}" name="${property}Nombre"  class="form-control clienteField" value="${value}"></input>

<script type="text/javascript">
$(function(){
	$(".empleadoField").autocomplete({
			source:'<g:createLink controller="cliente" action="getClientesJSON"/>',
			minLength:3,
			select:function(e,ui){
				console.log('Valor seleccionado: '+ui.item.id);
				$("#clienteId").val(ui.item.id);
			}
	});
});
</script>



