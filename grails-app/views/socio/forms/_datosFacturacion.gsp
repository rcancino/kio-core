



<fieldset id="clienteSet">
		<legend>Cliente</legend> 
		<f:with bean="${socioInstance}">
			

			<div class="form-group">
    			<label for="calle" class="col-sm-2 control-label">Nombre</label>
    			<div class="col-sm-8">
    				<g:hiddenField id="clienteId" name="cliente.id"/>
      				<g:field id="clienteField" name="cliente.nombre" type="text" class="form-control cliente-form"  
      				autofocus="autofocus" autocomplete="off"/>
    			</div>
    				<div class="col-sm-2">
      					<a href="" id="copiar" class="btn btn-default" >Copiar</a>
    				</div>
  				</div>
				
				<f:field  property="cliente.rfc" 
					input-id="rfcField" 
					input-required="required" 
					input-class="form-control cliente-form" 
					autocomplete="off"
					cols="col-sm-5"/>

				<f:field property="cliente.tipo" input-required="required" 
					input-class="form-control cliente-form" cols="col-sm-5"/>
				<f:field property="cliente.emailCfdi" 
					input-required="required" input-class="form-control cliente-form" cols="col-sm-5"/>
				<fieldset class="cliente-form">
					<g:render template="/_common/direccionForm" model="[prefix:'cliente']"/>
				</fieldset>
	
		</f:with>
</fieldset>

<script>
$(document).ready(function(){
	$("#copiar").click(function(event){
		event.preventDefault();
		console.log('Copiando datos del socio al cliente');
		$("[name='cliente.rfc']").val("XAXX010101000");
		$("[name='cliente.nombre']").val( $("[name='nombres']").val().toUpperCase()+' '
			+$("[name='apellidoPaterno']").val().toUpperCase()+' '
			+$("[name='apellidoMaterno']").val().toUpperCase() );
		$("[name='cliente.emailCfdi']").val($("[name='cfdiEmail']").val());

		$("[name='cliente.direccion.calle']").val($("[name='socio.direccion.calle']").val());
		$("[name='cliente.direccion.numeroExterior']").val($("[name='socio.direccion.numeroExterior']").val());
		/*
		if(res){
			$(".cliente-form").attr("disabled","disabled");
		}else{
			$(".cliente-form").removeAttr("disabled");
		}
		*/
		

		
	});

	$("#clienteField").autocomplete({
		source:'/kio-core/cliente/getClientesJSON',
		minLength:3,
		select:function(e,ui){
			console.log('Cliente seleccionado: '+ui.item.value);
			console.log('Direccion: '+ui.item.direccion+ ' Rfc: '+ui.item.rfc);
			$("#clienteId").val(ui.item.id);
			$("#rfcField").val(ui.item.rfc);
			$("#emailCfdiField").val(ui.item.emailCfdi);
					
		}
	});
});
</script>




