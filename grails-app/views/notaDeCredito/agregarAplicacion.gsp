<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Aplicación de Nota</title>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/>
	<meta name="layout" content="application"/>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h2> 
						${"Aplicacion de pago"} (Folio: ${aplicacionDeNotaInstance.nota.id} Disponible:${aplicacionDeNotaInstance.nota.disponible})
					</h2>
					<h4>
						${aplicacionDeNotaInstance.nota.cliente} 
					</h4>
					<g:if test="${flash.message}">
						<span class="label label-warning">${flash.message}</span>
					</g:if> 
				</div>
			</div>
		</div><!-- end .row -->
		
		<div class="row">
			
			<div class="col-md-2">
				<div class="list-group">
					<g:link class="list-group-item" action='edit' id="${aplicacionDeNotaInstance?.nota?.id}"> 
						<i class="fa fa-bars"></i>&nbsp;Regresar</g:link>
				</div>
			</div>

			<div class="col-md-8">
				<g:hasErrors bean="${aplicacionDeNotaInstance}">
					<div class="alert alert-danger">
						<g:renderErrors bean="${aplicacionDeNotaInstance}" as="list" />
					</div>
				</g:hasErrors>
				<g:form class="form-horizontal " action="salvarAplicacion" name="aplicacionForm">
					<g:hiddenField name="nota.id" value="${aplicacionDeNotaInstance.nota.id}"/>
					<div class="form-group ${hasErrors(bean:aplicacionDeNotaInstance,field:'venta', 'has-error')}">
						<label for="venta" class="col-sm-2 control-label">Venta</label>
						<div class="col-sm-8">
							<g:hiddenField id="ventaId" name="venta.id" value="${aplicacionDeNotaInstance?.venta?.id}"/>
							<input id="venta" type="text" class="form-control"
							  autocomplete="off" autofocus="on"
							  value="${aplicacionDeNotaInstance?.venta?.id}"/>
						</div>
						
					</div>
					<div class="form-group">
						<label for="fecha" class="col-sm-2 control-label">Fecha</label>
						<div class="col-sm-8">
							<input  id="fecha" name="fecha" type="text" class="form-control" type="text"
							  autocomplete="off"
							  value="${aplicacionDeNotaInstance?.fecha?.format('dd/MM/yyyy')}">
						</div>
					</div>
					<f:with bean="${aplicacionDeNotaInstance}">
						<f:field property="importe" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-2"
							input-type="text"/>
						<f:field property="comentario" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-2"/>
					</f:with>

					<div class="form-group">
						<div class="buttons  col-md-offset-2  col-md-3">
							<g:submitButton name="Generar" class="btn btn-primary  btn-block" value="Aceptar" 
							disabled="disabled"/>
						</div>
					</div>
				</g:form>
			</div>

		</div><!-- end .row2 -->

	</div>

	<script type="text/javascript">
		$(document).ready(function(){
			//$("#importe").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});
			$("#fecha").datepicker({
	     
	 		});

			$('form[name=aplicacionForm]').submit(function(e){
	    		$(this).children('input[type=submit]').attr('disabled', 'disabled');
	    		console.log("Desablidatndo submit button....");
	    		//$("#Cobrar").attr('disabled','disabled');
	    		var button=$("#Generar");
	    		button.attr('disabled','disabled').attr('value','Procesando...');
	    		// this is just for demonstration
	    		//e.preventDefault(); 
	    		return true;
			});

			$("#venta").autocomplete({
				source:'<g:createLink action="buscarVentasPendientesJSON" id="${aplicacionDeNotaInstance.nota.id}"/>',
				minLength:1,
				select:function(e,ui){
					console.log('Venta seleccionada: '+ui.item.label);
					$("#ventaId").val(ui.item.id);
					//$("#descripcion").val(ui.item.label);
					$("#importe").val(ui.item.importe);
					var button=$("#Generar");
	    			button.removeAttr('disabled');

				}
			});

		});
	</script>	
	
</body>
</html>