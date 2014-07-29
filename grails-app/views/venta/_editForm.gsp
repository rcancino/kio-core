<g:form action="save" class="form-horizontal">
	
	<div class="col-sm-8">
	<fieldset>
		<legend>Cliente</legend>
		
		
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
	<fieldset disabled>
		<legend>Total</legend>
			<f:with bean="${ventaInstance}">
				<f:field property="importeBruto" input-class="form-control" input-type="text" 
				cols="col-sm-6" colsLabel="col-sm-4" label="Importe"/>
				<f:field property="descuento" input-class="form-control" input-type="text" 
				cols="col-sm-6" colsLabel="col-sm-4" label="Descuento"/>
				<f:field property="importeNeto" input-class="form-control" input-type="text" 
				cols="col-sm-6" colsLabel="col-sm-4" label="Sub Total"/>
				<f:field property="impuesto" input-class="form-control" input-type="text" 
				cols="col-sm-6" colsLabel="col-sm-4" label="IVA"/>
				<f:field property="total" input-class="form-control" input-type="text" input-id="total"
				cols="col-sm-6" colsLabel="col-sm-4" label="Total"
				/>
				
		</f:with>
	</fieldset>
	</div>

	

	<div class="col-sm-12">
		<legend>Partidas</legend>
		<div id="gridPanel">
			<g:render template="ventasDetGrid" model="[partidas:ventaInstance.partidas]"/>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-6 col-sm-6">
			<g:link action="create" class="btn btn-default">
				<span class="glyphicon glyphicon-floppy-saved"></span> Nueva
			</g:link>
			<g:link action="index" class="btn btn-default"> Cancelar</g:link>

			<g:link controller="ventaDet" action="create" class="btn btn-primary" id="${ventaInstance.id}">
				<span class="glyphicon glyphicon-shopping-cart"></span> Agregar 
			</g:link>
			
			
			
			<g:submitButton name="Actualizar" class="btn btn-success " />
			
		</div>
	</div>

</g:form>

<script type="text/javascript">
	$(document).ready(function(){
		$("#fecha").datepicker({
		     
		 });
	});
</script>