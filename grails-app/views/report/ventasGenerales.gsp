<html>
<head>
<meta charset="UTF-8">
<meta name="layout" content="reportes"/>
<title>Calificación Para Incentivo</title>
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
					<f:field property="fechaInicial" 
						input-class="form-control" 
						cols="col-sm-9" colsLabel="col-sm-3"/>
					<f:field property="fechaFinal" input-class="form-control" cols="col-sm-9" colsLabel="col-sm-3"/>
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