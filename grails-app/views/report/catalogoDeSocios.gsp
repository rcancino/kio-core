<html>
<head>
<meta charset="UTF-8">
<meta name="layout" content="reportes"/>
<title>Catálogo de socios</title>
</head>
<body>

	<content tag="reporteTitle">
		Catálogo general de socios
	</content>
	
	<content tag="reportForm">
		
		<div class="col-sm-8">
		
		<g:form action="${params.action}" class="form-horizontal" name="reportForm">
			<fieldset>
				<legend> Parámetros</legend>
				<div class="form-group">
					<label for="tipo" class="col-md-2 lable-control"></label>
					<div class="col-md-6">
						<g:select class="form-control"  
							name="tipo" 
							value='TODOS'
							from="${['ACTIVOS','SUSPENDIDOS','TODOS']}" 
							/>
					</div>
				</div>
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
		
	</content>
	
</body>

</html>