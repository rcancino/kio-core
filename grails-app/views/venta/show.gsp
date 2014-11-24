<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Pedido ${ventaInstance.id}</title>
	%{-- <asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> 
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/> --}%
</head>
<body>

<content tag="header">
	
	Venta ${ventaInstance.id} 
	<g:if test="${ventaInstance?.cfdi}">
		<span class="label label-warning">FACTURADA</span>	
	</g:if>
</content>

<content tag="info">
</content>

<content tag="body">
	
	<div class="col-md-12">
		<g:hasErrors bean="${ventaInstance}">
			<div class="aler alert-danger">
				<g:renderErrors bean="${ventaInstance}" as="list" />
			</div>
		</g:hasErrors>
	</div>
	
	<div class="col-md-8">
		<g:form name="updateForm" action="update" class="form-horizontal" id="${ventaInstance.id}">
			<div class="form-group ">
				<label for="cliente" class="col-sm-2 control-label">Cliente</label>
				<div class="col-sm-10">
					<p class="form-control-static">${ventaInstance.cliente}</p>
				</div>
			</div>

			<div class="form-group">
				<label for="tipo" class="col-sm-2 control-label">Tipo</label>
				<div class="col-sm-6">
					<p class="form-control-static">${ventaInstance.tipo}</p>
				</div>
			</div>

			<div class="form-group">
				<label for="tipo" class="col-sm-2 control-label">Comentario</label>
				<div class="col-sm-6">
					<p class="form-control-static">${ventaInstance.comentario}</p>
				</div>

			</div>
			<div class="form-group">
				<label for="tipo" class="col-sm-2 control-label">Factura</label>
				<div class="col-sm-3">
					<p class="form-control-static">${ventaInstance?.cfdi?.folio} (${ventaInstance?.cfdi?.fecha?.format('dd/MM/yyyy')})</p>
				</div>

				<label for="tipo" class="col-sm-2 control-label">UUID</label>
				<div class="col-sm-5">
					<p class="form-control-static">${ventaInstance?.cfdi?.uuid}</p>
				</div>
			</div>

			<div class="form-group">
				<label for="fecha" class="col-sm-2 control-label">Fecha</label>
				<div class="col-sm-6">
					%{-- <input id="fecha" name="fecha" type="text"  
						value="${g.formatDate(date:ventaInstance.fecha,format:'dd/MM/yyyy') }"
						class="form-control" autocomplete="off"> --}%
					<p class="form-control-static">${g.formatDate(date:ventaInstance.fecha,format:'dd/MM/yyyy') }</p>
				</div>
			</div>
		</g:form>
	</div>		
	<div class=" col-md-4">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-offset-2 col-sm-4 control-label">SubTotal</label>
				<div class=" col-sm-6 ">
					<input value="${formatNumber(number:ventaInstance.importe,type:'currency')}" 
					class="form-control text-right" disabled/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 col-sm-4 control-label">Impuesto</label>
				<div class=" col-sm-6 ">
					<input value="${formatNumber(number:ventaInstance.impuesto,type:'currency')}" 
					class="form-control text-right" disabled/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-2 col-sm-4 control-label">Total</label>
				<div class=" col-sm-6 ">
					<input value="${formatNumber(number:ventaInstance.total,type:'currency')}" 
					class="form-control text-right" disabled/>
				</div>
			</div>
		</form>

		
	</div>
	
		

	<g:render template="ventasDetGrid"/>	

</content>

<content tag="footer">
	<div class="btn-group">
  							
		<g:link class="btn btn-default btn-sm" action="index">
			 <i class="fa fa-arrow-left"></i> Ventas 
		</g:link>		
		

		<g:link class="btn btn-default btn-sm" 
			action="create" id="${ventaInstance.id}" >
			<i class="fa fa-check-square-o"></i> Nueva venta 
		</g:link>

		<sec:link controller="myController" class="btn btn-danger btn-sm"
			action="cancelar" expression="hasRole('ADMINISTRACION')">
			<i class="fa fa-minus-circle"></i> Cancelar
		</sec:link>
		

  	</div>
</content>

<content tag="js">

// <script type="text/javascript">
// $(document).ready(function(){
// 	$("#fecha").datepicker({
	     
// 	 });
// 	$(".money-data").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});
	
	
// 	$("#next").click(function(){
// 		console.log('Siguiete paso');
// 		$("#updateForm").submit();
// 	});
	
// });
// </script>

</content>	

	

</body>
</html>