<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_show"/>
	<title>Corporativo</title>
</head>
<body>

	<content tag="header">
		<h3>Tipo de Cliente</h3>
	</content>
	
	<content tag="beanId">${tipoDeCorporativoInstance.id}</content>
	
	<content tag="form">
		<g:hasErrors bean="${tipoDeCorporativoInstance}">
			<div class="alert alert-danger">
				<g:renderErrors bean="${tipoDeCorporativoInstance}" as="list" />
			</div>
		</g:hasErrors>
		
		<form class="form-horizontal"  >
			
			<fieldset disabled="disabled">
				<legend>Corporativo</legend>
				<f:with bean="${tipoDeCorporativoInstance}">
					<f:field property="clave" input-required="required" input-class="form-control" cols="col-sm-5"/>
					<f:field property="descripcion" input-required="required" input-class="form-control" cols="col-sm-5"/>
				</f:with>
				
			</fieldset>
			
			<div class="form-group">
<%--				<div class="buttons col-md-offset-2 col-md-2">--%>
<%--					<g:link action="edit" class="btn btn-default " id="${tipoDeCorporativoInstance.id }" >--%>
<%--						<span class="glyphicon glyphicon-floppy-save"></span> Editar--%>
<%--					</g:link>--%>
<%--				</div>--%>
			</div>
			
		</form>
		
	</content>
	
</body>
</html>