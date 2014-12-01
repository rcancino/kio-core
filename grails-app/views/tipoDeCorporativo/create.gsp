<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_create"/>
	<title>Tipo de corporativo</title>
</head>
<body>

	<content tag="header">
		<h3>Alta de corporativo</h3>
	</content>
	<content tag="form">
		<g:hasErrors bean="${tipoDeCorporativoInstance}">
			<div class="alert alert-danger">
				<g:renderErrors bean="${tipoDeCorporativoInstance}" as="list" />
			</div>
		</g:hasErrors>

		
		
		<g:form class="form-horizontal" action="save" >
			
			<fieldset>
				<legend>Corporativo nuevo</legend>
				<f:with bean="${tipoDeCorporativoInstance}">
					<f:field property="clave" input-required="required" input-class="form-control" cols="col-sm-5" input-autofocus="autofocus"/>
					<f:field property="descripcion" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="activo"  input-class="form-control" cols="col-sm-5"/>
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