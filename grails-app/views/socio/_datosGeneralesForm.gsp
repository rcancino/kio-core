<%@page expressionCodec="none" %>
<f:with bean="${socioInstance}">
	<br/>
	<div class="row">
		<div class="col-md-6">
			<f:field property="apellidoPaterno" input-required input-autocomplete="off"
			input-class="form-control uppercase-field" colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="apellidoMaterno" input-required input-autocomplete="off"
			input-class="form-control uppercase-field" colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="nombres" input-required input-autocomplete="off"
			input-class="form-control uppercase-field" colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="sexo" input-required input-class="form-control" colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="numeroDeSocio" input-required input-class="form-control" colsLabel="col-md-4" cols="col-md-8"
			input-readonly="readonly"/>
			<f:field property="tarjeta"  input-class="form-control" colsLabel="col-md-4" cols="col-md-8" label="Tarjeta No"/> 
		</div>
		<div class="col-md-6">
			<f:field property="telefonoCasa" input-class="form-control"  colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="telefonoTrabajo" input-class="form-control" colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="celular" input-class="form-control" colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="email" input-class="form-control "  colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="email2" input-class="form-control " colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="activo"  input-class="form-control" colsLabel="col-md-4" cols="col-md-8"
				input-readonly="readonly"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<fieldset>
				<legend>Dirección  </legend>
				<div class="form-group">
					<label for="calle" class="col-sm-2 control-label">Calle </label>
					<div class="col-sm-4">
						<input name="direccion.calle" 
							value="${socioInstance?.direccion?.calle}"
							type="text" class="form-control mayusculas" 
							placeholder="Calle">
					</div>
				</div>

				<div class="form-group">
					<label for="numeroExterior" class="col-sm-2 control-label">No Exterior</label>
					<div class="col-sm-4">
							<input name="direccion.numeroExterior" 
							value="${socioInstance?.direccion?.numeroExterior}"
							type="text" class="form-control mayusculas"  
							placeholder="# exterior">
					</div>
					<label for="numeroInterior" class="col-sm-2 control-label">No Interior</label>
					<div class="col-sm-4">
							<input name="direccion.numeroInterior" 
							value="${socioInstance?.direccion?.numeroInterior}"
							type="text" class="form-control mayusculas"  
							placeholder="# interior">
					</div>
				</div>

				<div class="form-group">
					<label for="colonia" class="col-sm-2 control-label">Colonia</label>
					<div class="col-sm-4">
							<input name="direccion.colonia" 
							value="${socioInstance?.direccion?.colonia}"
							type="text" class="form-control mayusculas" 
							placeholder="Colonia">
					</div>
					<label for="colonia" class="col-sm-2 control-label">Delegación</label>
					<div class="col-sm-4">
							<input name="direccion.municipio" 
							value="${socioInstance?.direccion?.municipio}"
							type="text" class="form-control mayusculas" 
							placeholder="Delegación / Municipio">
					</div>
				</div>


				<div class="form-group">
				<label for="estado" class="col-sm-2 control-label">Estado</label>
					<div class="col-sm-4">
							<input name="direccion.estado" 
							value="${socioInstance?.direccion?.estado}"
							type="text" class="form-control mayusculas"  
							placeholder="Estado">
					</div>
					<label for="pais" class="col-sm-2 control-label">País</label>
					<div class="col-sm-4">
							<input name="direccion.pais" 
							value="${socioInstance?.direccion?.pais}"
							type="text" class="form-control mayusculas" 
							placeholder="pais">
					</div>
				</div>

				<div class="form-group">
					<label for="codigoPostal" class="col-sm-2 control-label">C.P.</label>
					<div class="col-sm-4">
							<input name="direccion.codigoPostal" 
							value="${socioInstance?.direccion?.codigoPostal}"
							type="text" class="form-control mayusculas"  
							placeholder="# Código postal">
					</div>
				</div>

			</fieldset>
		</div>

		
	</div>
		
</f:with>


	
	
	
