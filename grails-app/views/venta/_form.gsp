<g:form action="create" class="form-horizontal">
	<div class="col-md-8">
	
	<fieldset>
		<legend>Nuevo pedido</legend>
	
		<div class="form-group">
			<label for="clienteField" class="col-sm-2 control-label">Cliente</label>
			<div class="col-sm-8">
				<g:hiddenField id="clienteId" name="cliente.id" />
				<input class="form-control" 
				id="clienteField" name="cliente" type="text" 
				placeholder="Seleccione un cliente" autofocus="on" autocomplete="off">
			</div>
		</div>
		<f:with bean="${ventaInstance}">
			<f:field property="fecha" input-class="form-control" />
			<f:field property="tipo" input-class="form-control" />
			<f:field property="moneda" input-class="form-control" input-disabled="true"/>
		</f:with>
	</fieldset>
	</div>

	<div class="col-md-4 well">
		<fieldset>
			<legend>Total</legend>
			<f:with bean="${ventaInstance}">
				<f:field property="importeBruto" input-class="form-control" input-type="text" 
				input-cols="col-sm-8" input-colsLabel="col-sm-4" label="Importe"/>
				<f:field property="descuento" input-class="form-control" input-type="text"/>
				<f:field property="importeNeto" input-class="form-control" input-disabled="true"/>
				<f:field property="impuestoTasa" input-class="form-control" input-disabled="true"/>
				<f:field property="impuesto" input-class="form-control" input-disabled="true"/>
				<f:field property="total" input-class="form-control" input-disabled="true"/>
			</f:with>
		</fieldset>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
				<button type="submit" class="btn btn-default">Salvar</button>
		</div>
	</div>
</g:form>