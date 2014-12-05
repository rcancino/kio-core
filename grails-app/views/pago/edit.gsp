<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Pago ${pagoInstance.id}</title>
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
						Pago ${pagoInstance.id} - ${pagoInstance.cliente.nombre} 
					</h2>
					<h3>  Disponible: ${g.formatNumber(number:pagoInstance.disponible,type:'currency')}  </h3>
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
					<g:if test="${pagoInstance.disponible}">
						<g:link class="list-group-item" action='agregarAplicacion' id="${pagoInstance.id}"> 
							<i class="fa fa-plus"></i>&nbsp; Agregar aplicacion
						</g:link>

					</g:if>
					<g:link class="list-group-item" action='actualizarMembresias' id="${pagoInstance.id}"
						onclick="return confim('Actualizar las membresias de los socios relacionados?');"> 
						<i class="fa fa-unlock"></i>&nbsp; Actualizar membresias
					</g:link>
					
				</div>
			</div>

			<div class="col-md-9">
				<g:hasErrors bean="${pagoInstance}">
					<div class="alert alert-danger">
						<g:renderErrors bean="${pagoInstance}" as="list" />
					</div>
				</g:hasErrors>
				<g:form class="form-horizontal " action="save" name="notaForm" >
				<fieldset disabled>
					<div class="row">
						<div class="col-sm-5">
							<div class="form-group">
								<label for="fecha" class="col-sm-4 control-label">Fecha</label>
								<div class="col-sm-8">
									<input  id="fecha" name="fecha" type="text" class="form-control" type="text"
									  autocomplete="off"
									  value="${pagoInstance?.fecha?.format('dd/MM/yyyy')}">
								</div>
							</div>
							<f:field property="banco" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-4"/>
							
							
							<div class="form-group">
								<label class="col-sm-4 control-label">Importe</label>
							    <div class="col-sm-8">
							      <p class="form-control-static text-right"><g:formatNumber number="${pagoInstance.importe}" 
							      	type="currency"/>
							      </p>
							    </div>
							</div>
						</div>
						
						<div class="col-sm-5">
							<f:field bean="${pagoInstance}" 
								property="formaDePago" input-class="form-control" cols="col-sm-8" colsLabel="col-sm-4"/>
							<f:field property="referenciaBancaria" 
								input-class="form-control" cols="col-sm-8" colsLabel="col-sm-4" label="Referencia"/>	
							<div class="form-group">
								<label class="col-sm-4 control-label">Disponible</label>
							    <div class="col-sm-8">
							      <p class="form-control-static text-right"><g:formatNumber number="${pagoInstance.disponible}" 
							      	type="currency"/>
							      </p>
							    </div>
							</div>
						</div>
						<div class="col-sm-10">
							<f:field property="comentario" input-class="form-control" cols="col-sm-10" colsLabel="col-sm-2"/>
						</div>
						
					</div>
				</fieldset>	
				</g:form>
			</div>

		</div><!-- end .row2 -->

		<div class="row">
			<div class="col-md-12 grid-panel">
				<legend>Aplicaciones</legend>
				<table id="grid" class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>Folio</th>
							<th>Venta</th>
							<th>Fecha</th>
							<th>Importe</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${pagoInstance.aplicaciones}" var="row">
							<tr id="${row.id}">
								<td >
									<g:link  action="show" id="${row.id}">
										${fieldValue(bean:row,field:"id")}
									</g:link>
								</td>
								<td>
									${fieldValue(bean:row,field:"venta.id")}
								</td>
								<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
								<td><g:formatNumber number="${row.importe}" type="currency"/></td>
								<td>
									<sec:link action="eliminarAplicacion" 
										expression="hasRole('ADMINISTRACION')"
										onclick="return confirm('Eliminar aplicación ');"
										id="${row.id}">
										<i class="fa fa-trash"></i> 
									</sec:link>

									
								</td>
							</tr>
						</g:each>
					</tbody>
				</table>
			</div>
		</div>

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