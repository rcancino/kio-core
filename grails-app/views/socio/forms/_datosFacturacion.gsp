



<fieldset id="clienteSet">
		<legend>Cliente</legend> 
		<f:with bean="${socioInstance}">
			
<%--			<f:field property="cliente.nombre" input-id="demo" input-required="required" input-class="form-control" cols="col-sm-5" input-autofocus="autofocus"/>--%>
			<div class="form-group">
    				<label for="calle" class="col-sm-2 control-label">Nombre</label>
    				<div class="col-sm-8">
      					<g:field name="cliente.nombre" type="text" class="form-control cliente-form"  autofocus="autofocus" />
    				</div>
    				<div class="col-sm-2">
      					<input id="mostrador" name="mostrador" type="checkbox"> Mostrador
    				</div>
  				</div>
			<f:field property="cliente.rfc" input-required="required" input-class="form-control cliente-form" cols="col-sm-5"/>
			<f:field property="cliente.tipo" input-required="required" input-class="form-control cliente-form" cols="col-sm-5"/>
			<f:field property="cliente.emailCfdi" input-required="required" input-class="form-control cliente-form" cols="col-sm-5"/>
			<fieldset class="cliente-form"><g:render template="/_common/direccionForm" model="[prefix:'cliente']"/></fieldset>
	
		</f:with>
</fieldset>

<script>
$(document).ready(function(){
	$("#mostrador").change(function(){
		var res=this.checked;
		if(res){
			$(".cliente-form").attr("disabled","disabled");
		}else{
			$(".cliente-form").removeAttr("disabled");
		}
		
	});
	$("#demo").autocomplete({
		source:'/kio-core/cliente/getClientesJSON',
		minLength:3
	});
});
</script>




