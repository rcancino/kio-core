<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_create"/>
	<title>Producto nuevo</title>
	<asset:javascript src="forms/autoNumeric.js"/>
</head>
<body>

	<content tag="header">
		<h3>Nuevo producto/servicio</h3>
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
				
				
				<f:with bean="${productoInstance}">
					<f:field property="clave" input-class="form-control"/>
					<f:field property="descripcion" input-class="form-control"/>
					<f:field property="descripcion2" input-class="form-control"/>
					<f:field property="tipo" input-class="form-control"/>
					<f:field property="inventariable" input-class="form-control"/>
					<f:field property="unidad" input-class="form-control"/>
					<f:field property="precioBruto" input-class="form-control" input-type="text" input-data-moneda="moneda"/>
					<f:field property="descuento" input-class="form-control" input-type="text"/>
					<f:field property="precioNeto" input-class="form-control" input-type="text"/>
					<f:field property="suspendido" input-class="form-control" />
				</f:with>
				
			</fieldset>
			
			<div class="form-group">
				<div class="buttons col-md-offset-2 col-md-2">
					<g:submitButton name="Salvar" class="btn btn-primary " />
				</div>
			</div>
			
		</g:form>
		
		<script type="text/javascript">
$(document).ready(function(){
	$("#precioBruto").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});

});
</script>
		
	</content>

</body>
</html>