<%@page expressionCodec="none" %>
<f:with bean="${socioInstance}">
	<br/>
	
	<div class="row">
		<div class="col-md-6">
			%{-- <g:hiddenField id="clienteId" name="cliente.id" value="${socioInstance?.cliente?.id}"/> --}%
			%{-- <f:field property="cliente.id" 
				input-class="form-control"
				input-disabled="disabled" 
				input-type="text"
				colsLabel="col-md-4" cols="col-md-8"/> --}%
			<f:field property="cliente" 
				input-class="form-control"
				input-disabled="disabled" 
				input-type="text"
				colsLabel="col-md-4" cols="col-md-8"/>
			
			
		</div>
		<div class="col-md-6">
			<f:field property="cliente.rfc" 
				input-class="form-control"
				input-disabled="disabled" 
				input-type="text"
				colsLabel="col-md-4" cols="col-md-8"/>
			<f:field property="cfdiEmail" 
				input-autocomplete="off"
				input-class="form-control " 
				colsLabel="col-md-4" cols="col-md-8"
				/>
		</div>
		%{-- <g:render template="domicilioFiscal"/> --}%

	</div>
	<div class="row">
		<fieldset id="domicilioFiscal" disabled>
			<legend>Domicilio fiscal  </legend>
			<div class="form-group">
				<label for="calle" class="col-sm-2 control-label">Calle </label>
				<div class="col-sm-4">
					<input 
						value="${socioInstance?.cliente?.direccion?.calle}"
						type="text" class="form-control" >
				</div>
			</div>

			<div class="form-group">
				<label for="numeroExterior" class="col-sm-2 control-label">No Exterior</label>
				<div class="col-sm-4">
						<input 
						value="${socioInstance?.cliente?.direccion?.numeroExterior}"
						type="text" class="form-control">
				</div>
				<label for="numeroInterior" class="col-sm-2 control-label">No Interior</label>
				<div class="col-sm-4">
						<input  
						value="${socioInstance?.cliente?.direccion?.numeroInterior}"
						type="text" class="form-control">
				</div>
			</div>

			<div class="form-group">
				<label for="colonia" class="col-sm-2 control-label">Colonia</label>
				<div class="col-sm-4">
						<input 
						value="${socioInstance?.cliente?.direccion?.colonia}"
						type="text" class="form-control">
				</div>
				<label for="colonia" class="col-sm-2 control-label">Delegación</label>
				<div class="col-sm-4">
						<input 
						value="${socioInstance?.cliente?.direccion?.municipio}"
						type="text" class="form-control">
				</div>
			</div>


			<div class="form-group">
			<label for="estado" class="col-sm-2 control-label">Estado</label>
				<div class="col-sm-4">
						<input 
						value="${socioInstance?.cliente?.direccion?.estado}"
						type="text" class="form-control">
				</div>
				<label for="pais" class="col-sm-2 control-label">País</label>
				<div class="col-sm-4">
						<input 
						value="${socioInstance?.cliente?.direccion?.pais}"
						type="text" class="form-control">
				</div>
			</div>

			<div class="form-group">
				<label for="codigoPostal" class="col-sm-2 control-label">C.P.</label>
				<div class="col-sm-4">
						<input 
						value="${socioInstance?.cliente?.direccion?.codigoPostal}"
						type="text" class="form-control"  >
				</div>
			</div>

		</fieldset>
	</div>
	
		
</f:with>


	
	
	
