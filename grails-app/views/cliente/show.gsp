<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_show"/>
	<title>Cliente (${clienteInstance.id})</title>
</head>
<body>

	<content tag="header">
		<h3>Tipo de Venta</h3>
	</content>
	
	<content tag="beanId">${clienteInstance.id}</content>
	
	<content tag="form">
		<g:hasErrors bean="${clienteInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${clienteInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		
		<form class="form-horizontal"  >
			
			<fieldset disabled="disabled">
				<legend>Tipo de Venta</legend>
				<f:with bean="${clienteInstance}">
					<f:field property="nombre" input-required="required" input-class="form-control" cols="col-sm-5" input-autofocus="autofocus"/>
					<f:field property="rfc" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="tipo" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="emailCfdi" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="direccion" >
						<fieldset class="">
    						<legend>Dirección</legend>
    						<f:field property="direccion.calle" input-class="form-control" cols="col-sm-5"/>
    						<f:field property="direccion.numeroExterior" input-class="form-control" cols="col-sm-5"/>
    						<f:field property="direccion.numeroInterior" input-class="form-control" cols="col-sm-5"/>
						</fieldset>
					</f:field>
				</f:with>
				
			</fieldset>
			
			<div class="form-group">

			</div>
			
		</form>
		
	</content>
	
</body>
</html>