<%@page expressionCodec="none" %>
<f:with bean="${socioInstance}">
	<br/>
	
	<div class="row">
		<div class="col-md-6">
			<f:field property="cliente.id" 
				input-class="form-control"
				input-disabled="disabled" 
				input-type="text"
				colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="cliente.nombre" 
				input-required input-autocomplete="off"
				input-class="form-control uppercase-field" 
				colsLabel="col-md-4" cols="col-md-8"
				/>
		</div>
		<div class="col-md-6">
			<f:field property="cliente.rfc" 
				input-class="form-control"
				input-disabled="disabled" 
				input-type="text"
				colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="cfdiEmail" 
				input-autocomplete="off"
				input-class="form-control uppercase-field" 
				colsLabel="col-md-4" cols="col-md-8"
				/>
		</div>

	</div>
	
	<div class="row">
		<div class="col-md-12">
			<fieldset>
				<legend>Dirección  </legend>
				<div class="form-group">
					<label for="calle" class="col-sm-2 control-label">Calle </label>
					<div class="col-sm-4">
						<input name="cliente.direccion.calle" 
							value="${socioInstance?.cliente?.direccion?.calle}"
							type="text" class="form-control mayusculas" 
							placeholder="Calle">
					</div>
					%{-- <button id="copiarDireccion" class="btn btn-default"> Copiar del socio</button> --}%
				</div>

				<div class="form-group">
					<label for="numeroExterior" class="col-sm-2 control-label">No Exterior</label>
					<div class="col-sm-4">
							<input name="cliente.direccion.numeroExterior" 
							value="${socioInstance?.cliente?.direccion?.numeroExterior}"
							type="text" class="form-control mayusculas"  
							placeholder="# exterior">
					</div>
					<label for="numeroInterior" class="col-sm-2 control-label">No Interior</label>
					<div class="col-sm-4">
							<input name="cliente.direccion.numeroInterior" 
							value="${socioInstance?.cliente?.direccion?.numeroInterior}"
							type="text" class="form-control mayusculas"  
							placeholder="# interior">
					</div>
				</div>

				<div class="form-group">
					<label for="colonia" class="col-sm-2 control-label">Colonia</label>
					<div class="col-sm-4">
							<input name="cliente.direccion.colonia" 
							value="${socioInstance?.cliente?.direccion?.colonia}"
							type="text" class="form-control mayusculas" 
							placeholder="Colonia">
					</div>
					<label for="colonia" class="col-sm-2 control-label">Delegación</label>
					<div class="col-sm-4">
							<input name="cliente.direccion.municipio" 
							value="${socioInstance?.cliente?.direccion?.municipio}"
							type="text" class="form-control mayusculas" 
							placeholder="Delegación / Municipio">
					</div>
				</div>


				<div class="form-group">
				<label for="estado" class="col-sm-2 control-label">Estado</label>
					<div class="col-sm-4">
							<input name="cliente.direccion.estado" 
							value="${socioInstance?.cliente?.direccion?.estado}"
							type="text" class="form-control mayusculas"  
							placeholder="Estado">
					</div>
					<label for="pais" class="col-sm-2 control-label">País</label>
					<div class="col-sm-4">
							<input name="cliente.direccion.pais" 
							value="${socioInstance?.cliente?.direccion?.pais}"
							type="text" class="form-control mayusculas" 
							placeholder="pais">
					</div>
				</div>

				<div class="form-group">
					<label for="codigoPostal" class="col-sm-2 control-label">C.P.</label>
					<div class="col-sm-4">
							<input name="cliente.direccion.codigoPostal" 
							value="${socioInstance?.cliente?.direccion?.codigoPostal}"
							type="text" class="form-control mayusculas"  
							placeholder="# Código postal">
					</div>
				</div>

			</fieldset>
		</div>

		
	</div>	
	
		
</f:with>


	
	
	
