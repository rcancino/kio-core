<%@page expressionCodec="none" %>
<fieldset>
<legend>Dirección  </legend>
			
<div class="form-group">
	<label for="calle" class="col-sm-2 control-label">Calle </label>
	<div class="col-sm-4">
			<input name="${prefix?prefix+'.direccion.':''}direccion.calle" value="${row?.direccion?.calle}"
			type="text" class="form-control" placeholder="Calle">
	</div>
</div>

<div class="form-group">
	<label for="numeroExterior" class="col-sm-2 control-label">No Exterior</label>
	<div class="col-sm-4">
			<input name="${prefix?prefix+'.direccion.':''}direccion.numeroExterior" type="text" class="form-control"  placeholder="# exterior">
	</div>
	<label for="numeroInterior" class="col-sm-2 control-label">No Interior</label>
	<div class="col-sm-4">
			<input name="${prefix?prefix+'.direccion.':''}direccion.numeroInterior" type="text" class="form-control"  placeholder="# interior">
	</div>
</div>

<div class="form-group">
	<label for="colonia" class="col-sm-2 control-label">Colonia</label>
	<div class="col-sm-4">
			<input name="${prefix?prefix+'.direccion.':''}direccion.colonia" type="text" class="form-control" placeholder="Colonia">
	</div>
	<label for="colonia" class="col-sm-2 control-label">Delegación</label>
	<div class="col-sm-4">
			<input name="${prefix?prefix+'.direccion.':''}direccion.municipio" type="text" class="form-control" placeholder="Delegación / Municipio">
	</div>
</div>


<div class="form-group">
<label for="estado" class="col-sm-2 control-label">Estado</label>
	<div class="col-sm-4">
			<input name="${prefix?prefix+'.direccion.':''}direccion.estado" type="text" class="form-control"  placeholder="Estado">
	</div>
	<label for="pais" class="col-sm-2 control-label">País</label>
	<div class="col-sm-4">
			<input name="${prefix?prefix+'.direccion.':''}direccion.pais" type="text" class="form-control" placeholder="pais">
	</div>
</div>

<div class="form-group">
	<label for="codigoPostal" class="col-sm-2 control-label">C.P.</label>
	<div class="col-sm-4">
			<input name="${prefix?prefix+'.direccion.':''}direccion.codigoPostal" type="text" class="form-control"  placeholder="# Código postal">
	</div>
</div>
</fieldset>