<div class="col-md-6">
<fieldset>
	<legend> Producto / Servicio</legend>
	<g:form action="update" id="${ventaDetInstance.id}" class="form-horizontal">
		<g:hiddenField name="version" value="${ventaDetInstance?.version}"/>

		<g:hiddenField name="servicioPorSocio.id" value="${ventaDetInstance?.servicioPorSocio?.id}"/>

		<div class="form-group">
			<label for="producto" class="col-sm-2 control-label">Producto</label>
			<div class="col-sm-10">
				<g:hiddenField id="productoId" name="producto.id" 
					value="${ventaDetInstance?.producto.id}"/>
				<input id="producto" class="form-control" 
					name="producto.descripcion" value="${ventaDetInstance?.producto?.descripcion}"
					type="text"  autofocus="on" autocomplete="off">
			</div>
		</div>
		
		<div class="form-group">
			<label for="cantidad" class="col-sm-2 control-label">Cantidad</label>
			<div class="col-sm-4">
				<input id="cantidad" class="form-control" 
					name="cantidad" value="${ventaDetInstance?.cantidad}"
					type="text"  autocomplete="off">
			</div>
		</div>

		<div class="form-group">
			<label for="precioUnitario" class="col-sm-2 control-label ">Precio</label>
			<div class="col-sm-4">
				<input id="precioUnitario" class="form-control data-moneda" 
					name="precioUnitario" value="${ventaDetInstance?.precioUnitario}"
					disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="descuentoTasa" class="col-sm-2 control-label">Descuento</label>
			<div class="col-sm-4">
				<input id="descuentoTasa" class="form-control" 
					name="descuentoTasa" value="${ventaDetInstance?.descuentoTasa}"
					disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="importeNeto" class="col-sm-2 control-label">Importe</label>
			<div class="col-sm-4">
				<input id="importeNeto" class="form-control data-moneda" 
					name="importeNeto" value="${ventaDetInstance?.importeNeto}"
					disabled>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">
				<g:submitButton name="Actualizar" class="btn btn-primary " />
			</div>
		</div>
	
	</g:form>
</fieldset>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		$(".data-moneda").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});
		$("#producto").autocomplete({
			source:'/kio-core/producto/getProductosAsJSON',
            minLength: 2,
            select:function(e,ui){
				console.log('Producto seleccionado: '+ui.item.value);
				$("#precioUnitario").val(ui.item.precioBruto);
				$("#precioUnitario").autoNumeric('set', ui.item.precioBruto);
				$("#importeNeto").autoNumeric('set', ui.item.precioNeto);

				//console.log('Cliente: '+ui.item.cliente.nombre);
				//console.log('Scope: '+scope.venta.cliente.nombre);
						
			}
		});
	});
</script>