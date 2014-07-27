<form name="ventaNuevaForm" novalidate class="form-horizontal" ng-submit="salvar(venta)">
	
	<div class="col-sm-8">
	<fieldset>
		<legend>Cliente: {{venta.cliente.nombre}} ({{venta.cliente.id}})</legend>
		<div class="form-group">
			<label for="socio" class="col-sm-2 control-label">Socio</label>
			<div class="col-sm-10">
				<input id="socio" name="socio" class="form-control" auto-complete ng-model="socio"
					required placeholder="Seleccione un socio" autofocus="on" autocomplete="off">
			</div>
		</div>
		
		<div class="form-group">
			<label for="fecha" class="col-sm-2 control-label">Fecha</label>
			<div class="col-sm-6">
				<input id="fecha" class="form-control" required autocomplete="off" ng-model="venta.fecha">
			</div>
		</div>

		<div class="form-group">
			<label for="tipo" class="col-sm-2 control-label">Tipo</label>
			<div class="col-sm-6">
				<input id="tipo" name="tipo" class="form-control" autocomplete="off">
			</div>
		</div>
		
	</fieldset>
	</div>
	<div class="col-sm-4">
	<fieldset>
		<legend>Totales</legend>
		<div class="form-group">
			<label for="tipo" class="col-sm-4 control-label">Importe</label>
			<div class="col-sm-6 ">
				<input class="form-control text-right " autocomplete="off" ng-disabled="true" 
				value="{{venta.importe | currency:'$'}}" >
			</div>
		</div>
		<div class="form-group">
			<label for="tipo" class="col-sm-4 control-label">Descuentos</label>
			<div class="col-sm-6">
				<input class="form-control text-right " autocomplete="off" ng-disabled="true" 
				value="{{venta.descuentos | currency:'$'}}" >
			</div>
		</div>
		<div class="form-group">
			<label for="tipo" class="col-sm-4 control-label" ng-model="venta.importe">Sub Total</label>
			<div class="col-sm-6">
				<input class="form-control text-right " autocomplete="off" ng-disabled="true" 
				value="{{venta.subTotal | currency:'$'}}" >
			</div>
		</div>	
		<div class="form-group">
			<label for="tipo" class="col-sm-4 control-label">Impuestos</label>
			<div class="col-sm-6">
				<input class="form-control text-right " autocomplete="off" ng-disabled="true" 
				value="{{venta.impuestos | currency:'$'}}" >
			</div>
		</div>
		<div class="form-group">
			<label for="tipo" class="col-sm-4 control-label">Total</label>
			<div class="col-sm-6">
				<input class="form-control text-right " autocomplete="off" ng-disabled="true" 
				value="{{venta.total | currency:'$'}}" >
			</div>
		</div>
	</fieldset>
	</div>

	

	<div class="col-sm-12">
		<fieldset>
			<legend>Partidas</legend>
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th>Producto</th>
						<th>Descripcion</th>
						<th>Unidad</th>
						<th>Cantidad</th>
						<th>Precio</th>
						<th>Importe</th>
						<th>Descuento</th>
						<th>Sub Total</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="row in partidas">
						<td>{{row.clave}}</td>
						<td>{{row.descripcion}}</td>
						<td>{{row.unidad}}</td>
						<td>{{row.cantidad}}</td>
						<td>{{row.precio}}</td>
						<td>{{row.importeBruto | currency: "$"}}</td>
						<td>{{row.descuento}}</td>
						<td>{{row.importeNeto}}</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
		
		
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-8 col-sm-4">
			<button name="Salvar" type="submit" class="btn btn-primary" ng-disabled="ventaNuevaForm.$invalid">Salvar</button>
		</div>
	</div>
	
</form>
