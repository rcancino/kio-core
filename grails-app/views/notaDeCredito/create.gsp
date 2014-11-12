<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Alta de nota</title>
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
						Alta de Nota de crédito
					</h2>
					<g:if test="${flash.message}">
						<span class="label label-warning">${flash.message}</span>
					</g:if> 
				</div>
			</div>
			<g:hasErrors bean="${notaDeCreditoInstance}">
				<div class="alert alert-danger">
					<g:renderErrors bean="${notaDeCreditoInstance}" as="list" />
				</div>
			</g:hasErrors>
		</div><!-- end .row -->
		
		<div class="row">
			<div class="col-md-3">
        		<div class="list-group">
        			<g:link action="index" class="list-group-item">
        				<i class="fa fa-tasks fa-fw fa-2x"></i>&nbsp;  Regresar
        			</g:link>
        		</div>
			</div>
			
			<div class="col-md-6 ">
				<g:form class="form-horizontal pull-left center-block" action="create" >
					
					<f:with bean="${notaDeCreditoInstance}">
						<f:field property="cliente" input-class="form-control" />
						<f:field property="tipoDeNota" input-class="form-control" />
						<f:field property="importe" input-class="form-control" />
						
					</f:with>
					<div class="form-group">
						<div class="buttons  col-md-offset-4  col-md-8">
							<g:submitButton name="Generar" class="btn btn-primary btn-lg btn-block" value="Cobrar"/>
							%{-- <button id="cobrarBtn" class="btn btn-primary btn-lg btn-block">Cobrar</button>	 --}%
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

			$('form[name=pagoForm]').submit(function(e){
	    		$(this).children('input[type=submit]').attr('disabled', 'disabled');
	    		console.log("Desablidatndo submit button....");
	    		//$("#Cobrar").attr('disabled','disabled');
	    		var button=$("#Generar");
	    		button.attr('disabled','disabled').attr('value','Procesando...');
	    		// this is just for demonstration
	    		//e.preventDefault(); 
	    		return true;
			});

			$("#tipoDeNota").change(function(){
				var text = "";
				   $(this).children("option:selected").each(function() {
				      text += $( this ).text() ;
				});
				if(text==='BONIFICACION'){
					$("#importe").attr('disabled','disabled');
					//$("#referencia").attr('required','required');
				}else{
					$("#importe").removeAttr('disabled');
					$("#importe").attr('required','required');
					
				}
			});

		});
	</script>	
	
</body>
</html>