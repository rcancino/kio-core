<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Alta de pago</title>
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
						Alta de Pago
					</h2>
					<g:if test="${flash.message}">
						<span class="label label-warning">${flash.message}</span>
					</g:if> 
				</div>
			</div>
		</div><!-- end .row -->
		
		<div class="row">
			
			<div class="col-md-3">
				<div class="list-group">
					<g:link class="list-group-item" action='index'> 
						<i class="fa fa-bars"></i>&nbsp;Pagos</g:link>
				</div>
			</div>

			<div class="col-md-9">
				<g:hasErrors bean="${pagoInstance}">
					<div class="alert alert-danger">
						<g:renderErrors bean="${pagoInstance}" as="list" />
					</div>
				</g:hasErrors>
				<g:form class="form-horizontal " action="save" name="notaForm" >

					<div class="form-group ${hasErrors(bean:pagoInstance,field:'cliente', 'has-error')}">
						<label for="cliente" class="col-sm-2 control-label">Cliente</label>
						<div class="col-sm-8">
							<g:hiddenField id="clienteId" name="cliente.id" value="${pagoInstance?.cliente?.id}"/>
							<input id="cliente" name="cliente.nombre" type="text" class="form-control"
							  autocomplete="off" autofocus="on"
							  value="${pagoInstance?.cliente?.nombre}">
						</div>
					</div>
					<div class="form-group">
						<label for="fecha" class="col-sm-2 control-label">Fecha</label>
						<div class="col-sm-8">
							<input  id="fecha" name="fecha" type="text" class="form-control" type="text"
							  autocomplete="off"
							  value="${pagoInstance?.fecha?.format('dd/MM/yyyy')}">
						</div>
					</div>
					<f:with bean="${pagoInstance}">

						<f:field property="formaDePago" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-2"/>
						<f:field property="referenciaBancaria" 
							input-class="form-control" cols="col-sm-8" colsLabel="col-sm-2"/>
						<f:field property="banco" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-2"/>
						<f:field property="importe" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-2"
							input-type="text"/>
						<f:field property="comentario" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-2"/>
					</f:with>
					<div class="form-group">
						<div class="buttons  col-md-offset-2  col-md-3">
							<g:submitButton name="Generar" class="btn btn-primary  btn-block" value="Aceptar"/>
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

			$("#cliente").autocomplete({
				source:'<g:createLink controller="cliente" action="getClientesJSON"/>',
				minLength:3,
				select:function(e,ui){
					console.log('Cliente seleccionado: '+ui.item.value);
					$("#clienteId").val(ui.item.id);
					$("#cliente").val(ui.item.cliente.nombre);
					$("#socioId").val(null);
					$("#socio").val(null);
					
				}
			});

			// $("#tipoDeNota").change(function(){
			// 	var text = "";
			// 	   $(this).children("option:selected").each(function() {
			// 	      text += $( this ).text() ;
			// 	});
			// 	if(text==='BONIFICACION'){
			// 		$("#importe").attr('disabled','disabled');
			// 		//$("#referencia").attr('required','required');
			// 	}else{
			// 		$("#importe").removeAttr('disabled');
			// 		$("#importe").attr('required','required');
					
			// 	}
			// });

		});
	</script>	
	
</body>
</html>