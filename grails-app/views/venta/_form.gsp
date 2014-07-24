<g:form action="save" class="form-horizontal">
	
	<div class="col-sm-8">
	<fieldset>
		<legend>Cliente</legend>
		<div class="form-group">
			<label for="socio" class="col-sm-2 control-label">Socio</label>
			<div class="col-sm-10">
				<g:hiddenField id="socioId" name="socio" value="${ventaInstance?.id}"/>
				<input class="form-control" 
					id="socio" name="socio.nombre" type="text" 
					placeholder="Seleccione un socio" autofocus="on" autocomplete="off"
					%{-- value="${ventaInstance?.id?ventaInstance?.socio:''}" --}%
					>
			</div>
		</div>
		
		<div class="form-group">
			<label for="cliente" class="col-sm-2 control-label">Cliente</label>
			<div class="col-sm-10">
				<g:hiddenField id="clienteId" name="cliente.id" value="${ventaInstance?.cliente?.id}"/>
				<input id="cliente" name="cliente.nombre" type="text" class="form-control"
				 readonly="readonly" autocomplete="off"
				 value="${ventaInstance?.cliente?.nombre}">
			</div>
		</div>

		<div class="form-group">
			<label for="fecha" class="col-sm-2 control-label">Fecha</label>
			<div class="col-sm-6">
				<input id="fecha" value="${g.formatDate(date:ventaInstance.fecha,format:'dd/MM/yyyy') }"
					name="fecha" type="text" 
					class="form-control" autocomplete="off">
			</div>


		</div>
		<div class="form-group">
			<label for="tipo" class="col-sm-2 control-label">Tipo</label>
			<div class="col-sm-6">
				<f:input bean="${ventaInstance}" property="tipo" class="form-control"/>
			</div>

		</div>
		
	</fieldset>
	</div>
	<div class="col-sm-4">
	<fieldset>
		<legend>Total</legend>
			<f:with bean="${ventaInstance}">
				<f:field property="importeBruto" input-class="form-control" input-type="text" 
				cols="col-sm-6" colsLabel="col-sm-4" label="Importe"/>
				<f:field property="descuento" input-class="form-control" input-type="text" 
				cols="col-sm-6" colsLabel="col-sm-4" label="Descuento"/>
				<f:field property="importeNeto" input-class="form-control" input-type="text" 
				cols="col-sm-6" colsLabel="col-sm-4" label="Sub Total"/>
				<f:field property="impuestoTasa" input-class="form-control" input-type="text" 
				cols="col-sm-6" colsLabel="col-sm-4" label="IVA"/>
				<f:field property="total" input-class="form-control" input-type="text" input-id="totalField"
				cols="col-sm-6" colsLabel="col-sm-4" label="Total"
				/>
				
		</f:with>
	</fieldset>
	</div>

	

	<div class="col-sm-12">
		<legend>Partidas</legend>
		<div id="gridPanel">
			<g:render template="partidasGrid" model="[partidas:ventaInstance.partidas]"/>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-8 col-sm-4">

			<g:submitButton name="Salvar" class="btn btn-primary " />
			
		</div>
	</div>

</g:form>

<script type="text/javascript">
	$(document).ready(function(){
		/*
		$("#clienteField").autocomplete({
			source:'/kio-core/cliente/getClientesJSON',
			minLength:3,
			select:function(e,ui){
				console.log('Cliente seleccionado: '+ui.item.value);
				$("#clienteId").val(ui.item.id);
				
			}
		});
		*/
		$("#socio").autocomplete({
			source:'/kio-core/socio/getSociosJSON',
			minLength:3,
			select:function(e,ui){
				console.log('Socio seleccionado: '+ui.item.value);
				$("#socioId").val(ui.item.id);
				$("#cliente").val(ui.item.cliente.nombre);
				$("#clienteId").val(ui.item.cliente.id);
				//actualizarServicios(ui.item.socio);
				controller.actualizarGrid(ui.item.cliente);
				
			}
		});

		$("#fecha").datepicker({
		     
		 });

		$("#totalField").click(function(e){
			actualizarTotales();

		});


		var cargarGrid=function(productos){
				var tbody=$('tbody');
				tbody.empty();
				for(var i=0;i<productos.length;i++){
					var producto=productos[i];
					var row=tbody.append('<tr><td>'+producto.servicio.clave+'</td></tr>');
					
					
				}
		};

		var actualizarTotales=function(){
			console.log('Actualizando totales.....');
			
			var totalImporteNeto=0;
			var total=0;
			var elements=$('[data-importe-neto]').each(function(index,element){
				var importeNeto=$(this).attr("value");
				if(typeof importeNeto ==='number'){
					
				}
				importeNeto*=100;
				totalImporteNeto+=importeNeto;
				
			});
			console.log('Importe Neto: '+totalImporteNeto);
			total=totalImporteNeto*
			$("#importeNeto").val(totalImporteNeto/100);
		};

		var controller={
			actualizarGrid:function(cliente){
				console.log('Paso 1 Limpiar el grid');
				console.log('Paso 2 Agregar los servicio para el cliente: '+cliente.id);
				$.ajax({
					url:'<g:createLink controller="venta" action="crearPartidasPorServiciosDeCliente"/>',
					data:{'clienteId':cliente.id},
					success:function(data,textStatus,jqXHR){
						//console.log("Partidas recividas: "+data);
						/*
						for (var i = data.length - 1; i >= 0; i--) {
							console.log(data[i]);
						};
						*/
						//cargarGrid(data);
						$("#gridPanel").html(data)

					}
				});
			},
			

		};


	});
</script>