<div class="col-md-12">
	<g:form name="generalesForm" class="form-horizontal" action="update">
		<f:with bean="${socioInstance}">
			<f:field property="apellidoPaterno" 
			input-class="form-control uppercase-field" 
			input-autocomplete="off" input-autofocus="autofocus"/>
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
			%{-- <f:field property="corporativo" input-class="form-control"/> --}%
		</f:with>
		</fieldset>
		<g:render template="/_common/direccionForm" model="[prefix:'socio']"/>
		<div class="form-group">
			<div class="col-sm-offset-8 col-sm-4">
				<g:submitButton name="Actualizar" class="btn btn-primary " />
			</div>
		</div>
	</g:form>
</div>
<%--
<div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      %{-- <img src="http://lorempixel.com/g/300/300/people" alt="..."> --}%
      %{-- <img src="holder.js/200x300"> --}%
      <img src="http://placehold.it/300x300">
      <div class="caption">
        <h3>${socioInstance.nombres}</h3>
        
      </div>
    </div>
 </div>
--%>
