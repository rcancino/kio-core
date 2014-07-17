<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_create"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:stylesheet src="jquery-ui.css"/>
	<title>Socio nuevo</title>
</head>
<body>

	<content tag="header">
		<h3>Nuevo  socio</h3>
	</content>
	<content tag="form">
		<g:hasErrors bean="${socioInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${socioInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		
		<g:form class="form-horizontal" action="save" >
			
			<fieldset>
<%--				<legend>Alta de socio</legend>--%>
				<f:with bean="${socioInstance}">
				
				<ul class="nav nav-tabs" role="tablist">
		  			<li class="active"><a href="#generales" role="tab" data-toggle="tab">Generales</a></li>
					<li><a href="#cliente" role="tab" data-toggle="tab">Facturación</a></li>
					<li><a href="#perfil" role="tab" data-toggle="tab">Perfil</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="generales">
						<div class="row">
							<div class="col-sm-12">
								<g:render template="forms/datosGenerales"/>
							</div>
						</div>
						
					</div>
					<div class="tab-pane" id="perfil">Perfil de socio</div>
					<div class="tab-pane" id="cliente">
						<g:render template="forms/datosFacturacion"/>
					</div>
				</div>
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