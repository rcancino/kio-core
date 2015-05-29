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
			
			<div class="col-md-3">
				<div class="list-group">
					<g:link class="list-group-item" action='index'> 
						<i class="fa fa-bars"></i>&nbsp;Notas</g:link>
					
					<g:if test="${!notaDeCreditoInstance.cfdi}">
						<g:link class="list-group-item" action='agregarConcepto' 
							controller="notaDeCreditoDet" id="${notaDeCreditoInstance.id}"> 
							<i class="fa fa-plus"></i>&nbsp;Agregar concepto</g:link>
						<g:link class="list-group-item" 
							action="mandarTimbrar" id="${notaDeCreditoInstance.id}" 
							onclick="return confirm('Timbrar nota?');">
							Timbarar
						</g:link>
						<g:if test="${!notaDeCreditoInstance.aplicaciones}">
							<g:link class="list-group-item list-group-item-danger" 
								onclick="return confirm('Eliminar nota?');"
								action='delete' id="${notaDeCreditoInstance.id}"> 
								<i class="fa fa-trash"></i>&nbsp; Eliminar nota
							</g:link>
						</g:if>
					</g:if>
					<g:else>
						<g:if test="${notaDeCreditoInstance.disponible && notaDeCreditoInstance.cfdi}">
							<g:link class="list-group-item" 
								action='agregarAplicacion' 
								id="${notaDeCreditoInstance.id}"> 
								<i class="fa fa-plus"></i>&nbsp; Agregar aplicacion
							</g:link>

							<g:link class="list-group-item" 
								controller="cfdi" action="show" id="${notaDeCreditoInstance.cfdi.id}">
								Nota:  ${notaDeCreditoInstance?.cfdi?.folio} <br>
								<h6>
									<small>${notaDeCreditoInstance.cfdi.uuid}</small>
								</h6>
								
							</g:link>

						</g:if>
						

					</g:else>


				</div>
			</div>

			<div class="col-md-5">
				<g:hasErrors bean="${notaDeCreditoInstance}">
					<div class="alert alert-danger">
						<g:renderErrors bean="${notaDeCreditoInstance}" as="list" />
					</div>
				</g:hasErrors>
				<g:form class="form-horizontal " action="update" name="notaForm" method="PUT">
					<fieldset ${notaDeCreditoInstance.cfdi?'disabled':''}>
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
					<g:if test="${!notaDeCreditoInstance.cfdi}">
						<div class="form-group">
							<div class="buttons  col-md-offset-2  col-md-3">
								<g:submitButton name="Generar" class="btn btn-primary  btn-block" value="Salvar"/>
							</div>
						</div>
					</g:if>
					</fieldset>
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
							<tr>
								<td>Disponible</td>
								<td>${notaDeCreditoInstance.disponible}</td>
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
								<th>Concepto</th>
								<th>Descripcion</th>
								<th>Cantidad</th>
								<th>Valor u</th>
								<th>Importe</th>
								<th>Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<g:each in="${notaDeCreditoInstance.conceptos}" var="row">
								<tr>
									<td>${fieldValue(bean:row,field:"concepto")}</td>
									<td>${fieldValue(bean:row,field:"descripcion")}</td>
									<td>${formatNumber(number:row.cantidad, format:'###.##')}</td>
									<td>${formatNumber(number:row.valorUnitario, format:'###.##')}</td>
									<td>${formatNumber(number:row.importe, format:'###.##')}</td>
									<td>
										<g:if test="${!notaDeCreditoInstance.cfdi}">
											<g:link controller="notaDeCreditoDet" action="eliminar"
												onclick="return confirm('Eliminar partida?');"
												id="${row.id}">
												<span class="glyphicon glyphicon-trash"></span>
											</g:link>
										</g:if>
									</td>
								</tr>
							</g:each>
						</tbody>
					</table>
					
				</div>
			</div>
		</div>

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
						<g:each in="${notaDeCreditoInstance.aplicaciones}" var="row">
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