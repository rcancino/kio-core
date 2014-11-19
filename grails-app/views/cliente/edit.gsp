<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_edit"/>
	<title>Cliente (${clienteInstance.id})</title>
</head>
<body>

	<content tag="header">
		<h3>${clienteInstance} (${clienteInstance.id})</h3>
	</content>
	<content tag="beanId">
		${clienteInstance.id}
	</content>
	<content tag="form">
		<g:hasErrors bean="${clienteInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${clienteInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		
		<g:form class="form-horizontal" action="update" >
			<g:hiddenField name="id" value="$clienteInstance.id"/>
			<g:hiddenField name="version" value="${clienteInstance.version}"/>
			<fieldset>
				<f:with bean="${clienteInstance}">
					<f:field property="nombre" input-required="required" 
					input-class="form-control uppercase-field" cols="col-sm-5"
					input-autocomplete="off"/>
					<f:field property="rfc" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="tipo" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="emailCfdi" input-class="form-control" cols="col-sm-5"/>
				</f:with>
			</fieldset>
			<g:render template="/cliente/direccion"/>
			<fieldset>
				<legend></legend>
			</fieldset>
			<div class="form-group">
				<div class="buttons col-md-offset-2 col-md-2">
					<g:submitButton name="Actualizar" class="btn btn-primary " />
						
				</div>
			</div>
			
		</g:form>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.mayusculas').keyup(function(){
	    			this.value = this.value.toUpperCase();
				});
			});
		</script>
	</content>
	
</body>
</html>