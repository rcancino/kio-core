<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Nota: ${notaDeCreditoInstance.id}</title>
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/>
</head>
<body>
	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h2> 
						Agregar concepto a la nota: ${notaDeCreditoInstance.id}  (${notaDeCreditoInstance.cliente})
					</h2>
					<g:if test="${flash.message}">
						<span class="label label-warning">${flash.message}</span>
					</g:if> 
				</div>
			</div>
		</div><!-- end .row -->
		
		<div class="row">
			
			<div class="col-md-2">
				<div class="list-group">
					<g:link class="list-group-item" action='edit' controller='notaDeCredito' id="${notaDeCreditoInstance.id}"> 
						<i class="fa fa-bars"></i>&nbsp;Regresar</g:link>
				</div>
			</div>

			<div class="col-md-6">
				<g:hasErrors bean="${concepto}">
					<div class="alert alert-danger">
						<g:renderErrors bean="${concepto}" as="list" />
					</div>
				</g:hasErrors>
				<g:form class="form-horizontal " action="save" name="notaDetForm" >
					<g:hiddenField name="nota" value="${notaDeCreditoInstance.id}"/>
					<f:with bean="${concepto}">
						<f:field property="concepto" input-class="form-control" />
						<f:field property="descripcion" input-class="form-control" />
						<f:field property="unidad" input-class="form-control" />
						<f:field property="cantidad" input-class="form-control" input-type="text" />
						<f:field property="valorUnitario" 
							input-class="form-control" 
							input-type="text" />
						
						%{-- <f:field property="importe" 
							input-class="form-control" 
							input-type="text" /> --}%
							
					</f:with>
					<div class="form-group">
						<div class="buttons  col-md-offset-2  col-md-3">
							<g:submitButton name="Generar" class="btn btn-primary  btn-block" value="Salvar"/>
						</div>
					</div>
				</g:form>
			</div><!-- end .col-md-6 -->

			<div class="col-md-4">
				<div class="table-panel">
					<table class="table table-striped table-bordered table-condensed">
						<tbody>
							<tr>
								<td>Importe</td>
								<td>${notaDeCreditoInstance.subTotal}</td>
							</tr>
							<tr>
								<td>Imupesto (tasa)</td>
								<td>${notaDeCreditoInstance.impuestoTasa}</td>
							</tr>
							<tr>
								<td>Impuesto</td>
								<td>${notaDeCreditoInstance.impuesto}</td>
							</tr>
							<tr>
								<td>Total</td>
								<td>${notaDeCreditoInstance.total}</td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>

		</div><!-- end .row2 -->
		

	</div>

	<script type="text/javascript">
		$(document).ready(function(){
			//$("#importe").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});
			$("#fecha").datepicker({
	     
	 		});

			$('form[name=notaForm]').submit(function(e){
	    		$(this).children('input[type=submit]').attr('disabled', 'disabled');
	    		console.log("Desablidatndo submit button....");
	    		//$("#Cobrar").attr('disabled','disabled');
	    		var button=$("#Generar");
	    		button.attr('disabled','disabled').attr('value','Procesando...');
	    		// this is just for demonstration
	    		//e.preventDefault(); 
	    		return true;
			});
			

		});
	</script>	
	
</body>
</html>