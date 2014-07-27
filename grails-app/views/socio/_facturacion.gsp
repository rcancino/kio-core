



<fieldset>
		 
		<f:with bean="${socioInstance}">
			

			<div class="form-group">
    			<label for="calle" class="col-sm-2 control-label">Nombre</label>
    			
    			<div class="col-sm-6">
    				
      				<g:field id="clienteField" value="${socioInstance?.cliente?.nombre }"
      					name="cliente.nombre" 
      					type="text" class="form-control"  
      					autofocus="autofocus" autocomplete="off"/>
    			</div>
    			
    			</div>
    				<div class="col-sm-1">
      					<input id="clienteId" name="cliente.id" value="${socioInstance?.cliente?.id }"
      						type="text"  
      						disabled class="form-control"/>
    				</div>
  				</div>
    				
  			</div>
				
				<f:field  property="cliente.rfc" 
					input-id="rfcField" 
					input-required="required" 
					input-class="form-control" 
					autocomplete="off"
					cols="col-sm-4"/>
				
				<f:field property="cliente.tipo" input-required="required" 
					input-class="form-control cliente-form" cols="col-sm-4"/>
				 
				<f:field property="cliente.emailCfdi" 
					input-required="required" input-class="form-control cliente-form" cols="col-sm-4"/>
					
					
				<%-- 
				<fieldset class="cliente-form">
					
				</fieldset>
				--%>
				
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




