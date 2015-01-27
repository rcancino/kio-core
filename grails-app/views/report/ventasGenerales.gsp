<html>
<head>
<meta charset="UTF-8">
<meta name="layout" content="reportes"/>
<title>Calificación Para Incentivo</title>
<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
</head>
<body>

	<content tag="reporteTitle">
		Ventas generales por periodo
	</content>
	
	<content tag="reportForm">
		<g:hasErrors bean="${reportCommand}">
            <div class="alert alert-danger">
                <g:renderErrors bean="${reportCommand}" as="list" />
            </div>
        </g:hasErrors>
		<div class="col-sm-8">
		
		<g:form action="${params.action}" class="form-horizontal" name="reportForm">
			<g:hiddenField name="reportName" value="${params.action}"/>
			<fieldset>
				<legend> Parámetros</legend>
				<f:with bean="${reportCommand}">

					<div class="form-group">
						<label for="fechaInicial" class="col-sm-4 control-label ">Fecha Inicial</label>
						<div class="col-sm-6">
							<input  id="fechaInicial" name="fechaInicial" type="text" class="form-control dateField" 
							type="text"
							autocomplete="off"
							value="${reportCommand?.fechaInicial?.format('dd/MM/yyyy')}">
						</div>
					</div>

					<div class="form-group">
						<label for="fechaFinal" class="col-sm-4 control-label">Fecha Final</label>
						<div class="col-sm-6">
							<input  id="fechaFinal" name="fechaFinal" type="text" class="form-control dateField" type="text"
							  autocomplete="off"
							  value="${reportCommand?.fechaFinal?.format('dd/MM/yyyy')}">
						</div>
					</div>

					%{-- <f:field property="fechaInicial" 
						input-class="form-control" 
						cols="col-sm-9" colsLabel="col-sm-3"/> --}%
					%{-- <f:field property="fechaFinal" input-class="form-control dateField" cols="col-sm-9" colsLabel="col-sm-3"/> --}%
				</f:with>
			</fieldset>
			<div class="form-group">
		    	<div class="col-sm-offset-3 col-sm-3">
		      		<button id="ejecutar" type="submit" class="btn btn-primary">
		      			<span class="glyphicon glyphicon-cog"></span> Ejecutar
		      		</button>
		    	</div>
		  	</div>
		</g:form>
		</div>
	</content>

	<content tag="javascript">
		<script type="text/javascript">
				$(document).ready(function(){
					//$("#importe").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});
					$(".dateField").datepicker({
			     
			 		});
			 	});
			// $('form[name=reportForm]').submit(function(e){
	  //   		$(this).children('input[type=submit]').attr('disabled', 'disabled');
	  //   		console.log("Desablidatndo submit button....");
	  //   		var button=$("#ejecutar");
	  //   		button.attr('disabled','disabled').attr('value','Procesando...');
	  //   		// this is just for demonstration
	  //   		//e.preventDefault(); 
	  //   		return true;
			// });
		</script>
	</content>
	
</body>

</html>