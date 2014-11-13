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
						Nota de credito ${notaDeCreditoInstance.id} - ${notaDeCreditoInstance.cliente}
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
					<g:link class="list-group-item" action='index'> 
						<i class="fa fa-bars"></i>&nbsp;Catalogos</g:link>
					<g:link class="list-group-item" action='agregarConcepto' 
						controller="notaDeCreditoDet" id="${notaDeCreditoInstance.id}"> 
						<i class="fa fa-plus"></i>&nbsp;Agregar concepto</g:link>
				</div>
			</div>

			<div class="col-md-6">
				<g:hasErrors bean="${notaDeCreditoInstance}">
					<div class="alert alert-danger">
						<g:renderErrors bean="${notaDeCreditoInstance}" as="list" />
					</div>
				</g:hasErrors>
				<g:form class="form-horizontal " action="update" name="notaForm" method="PUT">
					
					<div class="form-group">
						<label for="fecha" class="col-sm-2 control-label">Fecha</label>
						<div class="col-sm-10">
							<input  id="fecha" name="fecha" type="text" class="form-control" type="text"
							  autocomplete="off"
							  value="${notaDeCreditoInstance?.fecha?.format('dd/MM/yyyy')}">
						</div>
					</div>
					<f:with bean="${notaDeCreditoInstance}">

						<f:field property="tipo" input-class="form-control" />
						<f:field property="comentario" input-class="form-control" />
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
								<td>${notaDeCreditoInstance.importe}</td>
							</tr>
							<tr>
								<td>Imupesto (tasa)</td>
								<td>${notaDeCreditoInstance.impuestoTasa}</td>
							</tr>
							<tr>
								<td>Impuesto</td>
								<td>${notaDeCreditoInstance.impuestos}</td>
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

		<div class="row">
			<div class="col-md-12">

				<div class="table-panel">
					<legend>Conceptos</legend>
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>Cantidad</th>
								<th>Concepto</th>
								<th>Descripcion</th>
								<th>Unidad</th>
								<th>Importe</th>
							</tr>
						</thead>
						<tbody>
							<g:each in="${productoInstanceList}" var="row">
								<tr>
									<td>
										<g:link action="show" id="${row.id}">
											${fieldValue(bean:row,field:"id")}
										</g:link>
									</td>
									<td>${fieldValue(bean:row,field:"clave")}</td>
									
								</tr>
							</g:each>
						</tbody>
					</table>
					
				</div>
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

			

		});
	</script>	
	
</body>
</html>