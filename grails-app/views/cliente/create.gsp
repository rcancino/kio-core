<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_create"/>
	<title>Cliente (Alta)</title>
</head>
<body>

	<content tag="header">
		<h3>Nuevo cliente</h3>
	</content>
	<content tag="form">
		
		<g:hasErrors bean="${socioInstance}">
			<div class="alert alert-danger">
				<g:renderErrors bean="${clienteInstance}" as="list" />
			</div>
		</g:hasErrors>
		
		<g:form class="form-horizontal" action="save" >
			
			<fieldset>
				<legend>Cliente nuevo</legend>
				<f:with bean="${clienteInstance}">
					<f:field property="nombre" input-required="required" 
					input-class="form-control uppercase-field" cols="col-sm-5" 
					input-autofocus="autofocus"
					input-autocomplete="off"/>
					<f:field property="rfc" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="tipo" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="emailCfdi" input-required="required" input-class="form-control" cols="col-sm-5"/>
				</f:with>
			</fieldset>
			<g:render template="/cliente/direccion"/>
			<fieldset>
				<legend></legend>
			</fieldset>
			<div class="form-group">
				<div class="buttons col-md-offset-2 col-md-2">
					<g:submitButton name="Salvar" class="btn btn-primary " />
						
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