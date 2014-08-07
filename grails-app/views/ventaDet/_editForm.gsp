<div class="col-md-10">
<fieldset>
	<legend> <small id="productoLabel">${ventaDetInstance?.producto}</small></legend>
	<g:form name="ventaDetForm" action="update" class="form-horizontal">	
		
		
		<g:hiddenField name="venta.id" value="${ventaInstance.id}"/>
		<g:hiddenField name="ventaDet.version" value="${ventaDetInstance.version}"/>
		<g:hiddenField name="id" value="${ventaDetInstance.id}"/>
		
		<div class="form-group">
			<label for="socio" class="col-sm-2 control-label">Socio</label>
			<div class="col-sm-10">
				<g:select class="form-control"  
						name="socio" 
						value="${socio}"
						from="${socios}" 
						optionKey="id" 
						noSelection="[null:'Seleccione una socio']"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="producto" class="col-sm-2 control-label">Producto</label>
			<div class="col-sm-10">
				
				<g:hiddenField id="productoId" name="producto.id" autocomplete="off" value="${ventaDetInstance.producto.id}"/>
				<input id="producto" class="form-control" 
					name="producto.descripcion" placeholder="Seleccione otro producto"
					type="text"  autofocus="on" 
					autocomplete="off">
			</div>
		</div>
		
		<div class="form-group">
			<label for="cantidad" class="col-sm-2 control-label">Cantidad</label>
			<div class="col-sm-4">
				<input id="cantidad" class="form-control"
					value="${ventaDetInstance?.cantidad}" 
					name="cantidad"
					type="text"  autocomplete="off">
			</div>
		</div>

		<div class="form-group">
			<label for="precio" class="col-sm-2 control-label ">Precio</label>
			<div class="col-sm-4">
				<input id="precio" class="form-control data-moneda" 
					name="precio"  value="${ventaDetInstance?.precioConIva }"
					autocomplete="off" disabled>
			</div>
		</div>

		<div class="form-group">
			<label for="descuentoTasa" class="col-sm-2 control-label">Descuento</label>
			<div class="col-sm-4">
				<input id="descuento" class="form-control data-moneda" 
					name="descuento"  value="${ventaDetInstance?.descuento }"
					autocomplete="off">
			</div>
		</div>

		%{-- <div class="form-group">
			<label for="importeNeto" class="col-sm-2 control-label">Neto</label>
			<div class="col-sm-4">
				<input id="subTotal" class="form-control data-moneda" 
					name="subTotal"  value="${ventaDetInstance?.producto?.precioNeto }"
					autocomplete="off" disabled>
			</div>
		</div> --}%


	
	</g:form>
</fieldset>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		$(".data-moneda").autoNumeric({wEmpty:'zero'});
		$("#producto").autocomplete({
			source:'/kio-core/producto/getProductosAsJSON',
            minLength: 2,
            select:function(e,ui){
				console.log('Producto seleccionado: '+ui.item.value);
				$("#productoId").val(ui.item.id);
				$("#productoLabel").text(ui.item.descripcion);
				$("#precio").autoNumeric('set', ui.item.precioNeto);
				$("#subTotal").autoNumeric('set', ui.item.precioNeto);
				$("#precio").autoNumeric('set', ui.item.precioBruto);
				validar();		
			}
		});
		$("#cantidad").on('blur',function(e){
			validar();
		});

		
		var validar=function(){
			var cantidad= $("#cantidad").val();
			var producto= $("#productoId").val();
			var res=( cantidad>0 && producto>0 );
			console.log('Valido cantidad: '+cantidad);
			console.log('Valido producto: '+producto);
			if(res){
				$("input[type=submit]").removeAttr("disabled");
				$("#next").removeAttr("disabled");
			}else{
				$("input[type=submit]").attr("disabled", "disabled");
				$("#next").attr("disabled", "disabled");
			}
		};

		$("#next").attr("disabled", "disabled");
		$("#next").click(function(){
			console.log('Salvar la forma');
			$("#ventaDetForm").submit();
		});
		
	});
</script>