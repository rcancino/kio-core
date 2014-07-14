<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_edit"/>
	<title>Tipo de Cliente ${tipoDeClienteInstance}</title>
</head>
<body>

	<content tag="header">
		<h3>Tipo de Cliente ${tipoDeClienteInstance.id}</h3>
	</content>
	<content tag="form">
		<g:hasErrors bean="${tipoDeClienteInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${tipoDeClienteInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"
					</g:if>>
					<g:message error="${error}"/>
				</li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		
		<g:form class="form-horizontal" action="update" method="PUT">
			<g:hiddenField name="version" value="${tipoDeClienteInstance?.version}" />
			<fieldset>
				<legend>Tipo de Cliente</legend>
				<f:with bean="${tipoDeClienteInstance}">
					<g:hiddenField name="id" value="${tipoDeClienteInstance?.id}" />
					<f:field property="clave" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="descripcion" input-required="required" input-class="form-control" cols="col-sm-5" input-autofocus="autofocus"/>
				</f:with>
				
			</fieldset>
			
			<div class="form-group">
				<div class="buttons col-md-offset-2 col-md-2">
					<g:actionSubmit class="btn btn-primary" action="update" value="Actualizar" >
						<span class="glyphicon glyphicon-ok"></span> Actualizar
					</g:actionSubmit>
					
					
				</div>
			</div>
			
		</g:form>
		
	</content>
	
</body>
</html>