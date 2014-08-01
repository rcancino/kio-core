<g:form name="generalesForm" class="form-horizontal" action="update">
<div class="panel panel-primary">
	<div class="panel panel-heading">Datos generales</div>
	
	<div class="panel-body">
			<g:hiddenField name="id" field="${socioInstance.id}"/>
			<g:hiddenField name="version" field="${socioInstance.version}"/>
			
			<f:with bean="${socioInstance}">
				<f:field property="apellidoPaterno" 
				input-class="form-control uppercase-field" 
				input-autocomplete="off" 
				input-autofocus="autofocus"/>
				<f:field property="apellidoMaterno" input-class="form-control uppercase-field" input-autocomplete="off" />
				<f:field property="nombres" input-class="form-control uppercase-field" input-autocomplete="off" />
				<f:field property="tipoDeSocio" input-class="form-control"/>
				<f:field property="medioDeContacto" input-class="form-control"/>
				<f:field property="sexo" input-class="form-control"/>
				<f:field property="fechaDeNacimiento" input-class="form-control" label="F. Nacimiento"/>
				<f:field property="telefonoCasa" input-class="form-control"/>
				<f:field property="telefonoTrabajo" input-class="form-control"/>
				<f:field property="celular" input-class="form-control"/>
				<f:field property="email" input-class="form-control"/>
				<f:field property="email2" input-class="form-control"/>
				<f:field property="cfdiEmail" input-class="form-control"/>
				<f:field property="areaDeInteres" input-class="form-control"/>
			</f:with>
			</fieldset>
			
			%{-- <div class="form-group">
				<div class="col-sm-offset-8 col-sm-4">
					<g:submitButton name="Actualizar" class="btn btn-primary " />
				</div>
			</div> --}%
			
		
	</div>
	<div class="panel-footer">
		<g:submitButton name="Actualizar" class="btn btn-primary btn-sm" />
	</div>
	
</div>
</g:form>
