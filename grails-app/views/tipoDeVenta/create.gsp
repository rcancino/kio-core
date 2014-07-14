<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_create"/>
	<title>Tipo de Venta nuevo</title>
</head>
<body>

	<content tag="header">
		<h3>Nuevo tipo de Venta</h3>
	</content>
	<content tag="form">
		<g:hasErrors bean="${tipoDeVentaInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${tipoDeVentaInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		
		<g:form class="form-horizontal" action="save" >
			
			<fieldset>
				<legend>Alta de tipo</legend>
				<f:with bean="${tipoDeVentaInstance}">
					<f:field property="clave" input-required="required" input-class="form-control" cols="col-sm-5" input-autofocus="autofocus"/>
					<f:field property="descripcion" input-required="required" input-class="form-control" cols="col-sm-5"/>
				</f:with>
				
			</fieldset>
			
			<div class="form-group">
				<div class="buttons col-md-offset-2 col-md-2">
					<g:submitButton name="Salvar" class="btn btn-primary " />
						
				</div>
			</div>
			
		</g:form>
		
	</content>
	
</body>
</html>