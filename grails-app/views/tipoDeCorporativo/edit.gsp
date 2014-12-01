<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_edit"/>
	<title>Corporativo ${tipoDeCorporativoInstance}</title>
</head>
<body>

	<content tag="header">
		<h3>Tipo de Cliente ${tipoDeCorporativoInstance.id}</h3>
	</content>
	<content tag="form">
		
		<g:hasErrors bean="${tipoDeCorporativoInstance}">
			<div class="alert alert-danger">
				<g:renderErrors bean="${tipoDeCorporativoInstance}" as="list" />
			</div>
		</g:hasErrors>

		
		<g:form class="form-horizontal" action="update" method="PUT">
			<g:hiddenField name="version" value="${tipoDeCorporativoInstance?.version}" />
			<fieldset>
				<legend>Tipo de Cliente</legend>
				<f:with bean="${tipoDeCorporativoInstance}">
					<g:hiddenField name="id" value="${tipoDeCorporativoInstance?.id}" />
					<f:field property="clave" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="descripcion" input-required="required" input-class="form-control" cols="col-sm-5" input-autofocus="autofocus"/>
					<f:field property="activo" input-class="form-control" cols="col-sm-5" />
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