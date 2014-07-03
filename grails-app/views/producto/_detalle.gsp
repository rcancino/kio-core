<div class="col-md-6">
	<div class="panel-header"><h3>Características</h3></div>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label class="col-sm-4 control-label">Clave</label>
			<div class="col-sm-8">
				<p class="form-control-static">${productoInstance.clave}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Descripcion</label>
			<div class="col-sm-8">
				<p class="form-control-static">${productoInstance.descripcion}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Descripcion 2</label>
			<div class="col-sm-8">
				<p class="form-control-static">${productoInstance.descripcion2?:'PENDIENTE'}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Tipo</label>
			<div class="col-sm-8">
				<p class="form-control-static">${productoInstance.tipo}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Inventariable</label>
			<div class="col-sm-8">
				<p class="form-control-static">${productoInstance.inventariable?'SI':'NO'}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Unidad</label>
			<div class="col-sm-8">
				<p class="form-control-static">${productoInstance.unidad}</p>
			</div>
		</div>
	</form>	
</div>

<div class="col-md-6">
	<div class="panel-header"><h3>Precio / Descuento</h3></div>
	
	<form class="form-horizontal" role="form">
		
		<div class="form-group">
			<label class="col-sm-4 control-label">Precio bruto</label>
			<div class="col-sm-8">
				<p class="form-control-static">${productoInstance.precioBruto}</p>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-4 control-label">Descuento</label>
			<div class="col-sm-8">
				<p class="form-control-static">${productoInstance.descuento}</p>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-4 control-label">Precio neto</label>
			<div class="col-sm-8">
				<p class="form-control-static">${productoInstance.precioBruto}</p>
			</div>
		</div>

	</form>	
</div>