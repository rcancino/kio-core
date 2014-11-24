<g:form class="form-horizontal" role="form" action="update" id="${productoInstance.id}">
	
	<g:hiddenField name="version" value="${productoInstance.version}"/>
<f:with bean="${productoInstance}">

<div class="col-md-6">
	<div class="panel-header"><h3>Características</h3></div>
		<f:field property="clave" input-class="form-control"/>
		<f:field property="descripcion" input-class="form-control"/>
		<f:field property="descripcion2" input-class="form-control"/>
		<f:field property="unidad" input-class="form-control"/>
		<f:field property="inventariable" input-class="form-control"/>
		<f:field property="tipo" input-class="form-control"/>
		<f:field property="periodicidad" input-class="form-control"/>
		<f:field property="duracion" input-class="form-control" input-type="text"/>
		<f:field property="suspendido" input-class="form-control" />

		
</div>

<div class="col-md-6">
	<div class="panel-header"><h3>Precio / Descuento</h3></div>
	<f:field property="precioBruto" input-class="form-control" input-type="text"/>
	<f:field property="descuento" input-class="form-control" input-type="text"/>
	<f:field property="precioNeto" input-class="form-control" input-type="text"/>
</div>
<div class="form-group">
	<div class="col-md-offset-2 col-md-2">
		<g:submitButton name="Actualizar" class="btn btn-primary " />
	</div>
</div>
</f:with>
</g:form>