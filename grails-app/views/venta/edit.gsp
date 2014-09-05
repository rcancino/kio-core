<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Pedido ${ventaInstance.id}</title>
	<asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> 
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
	<asset:javascript src="forms/autoNumeric.js"/>
</head>
<body>

<content tag="header">
	Pedido ${ventaInstance.id}
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
					%{-- <f:input bean="${ventaInstance}" property="tipo" class="form-control"/> --}%
					<p class="form-control-static">${ventaInstance.tipo}</p>
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

		%{-- <form class="form-horizontal">
			
		
		<fieldset disabled>
		<f:with bean="${ventaInstance}">
			<f:field property="subTotalConIva" 
				input-class="form-control money-data text-right" 
				input-type="text" cols="col-sm-6" colsLabel="col-sm-4" />
			<f:field property="descuento" input-class="form-control money-data text-right" input-type="text" 
			cols="col-sm-6" colsLabel="col-sm-4" />
			<f:field property="subTotal" input-class="form-control money-data text-right" input-type="text" 
			cols="col-sm-6" colsLabel="col-sm-4" label="Sub Total"/>
			<f:field property="impuesto" input-class="form-control money-data text-right" input-type="text" 
			cols="col-sm-6" colsLabel="col-sm-4" label="IVA"/>
			<f:field property="total" input-class="form-control money-data text-right" input-type="text" input-id="total"
			cols="col-sm-6" colsLabel="col-sm-4" label="Total"
			/>
		</f:with>	
		</fieldset>
		</form> --}%
	</div>
	
		

	<g:render template="ventasDetGrid"/>	

</content>

<content tag="footer">
	<div class="btn-group">
  							
		<g:link class="btn btn-default btn-sm" action="index" params="[tipo:'PEDIDO']">
			Cancelar
		</g:link>
		
		<g:link class="btn btn-default btn-sm" 
			action="create" id="${ventaInstance.id}" >
			 Nueva 
		</g:link>

		<g:link class="btn btn-default btn-sm" 
			controller="ventaDet" action="create" id="${ventaInstance.id}" >
			<span class="glyphicon glyphicon-plus"></span> Agregar partida
		</g:link>

		<g:link class="btn btn-default btn-sm" 
			action="mandarFacturar" id="${ventaInstance.id}" >
			<span class="glyphicon glyphicon-shopping-cart"></span> Mandar Facturar 
		</g:link>
		
		<button id="next" class="btn btn-success btn-sm">
			<span class="glyphicon glyphicon-ok"></span> Terminar
		</button>
		
		

		<g:link class="btn btn-danger btn-sm" 
			action="delete" id="${ventaInstance.id}" onclick="return confirm('Eliminar el pedido');">
			<span class="glyphicon glyphicon-trash"></span> Eliminar
		</g:link>

  	</div>
</content>

<content tag="js">

<script type="text/javascript">
$(document).ready(function(){
	$("#fecha").datepicker({
	     
	 });
	$(".money-data").autoNumeric({wEmpty:'zero',mRound:'B',aSign: '$'});
	
	/*
	$("#cliente").autocomplete({
		source:'/kio-core/cliente/getClientesJSON',
		minLength:3,
		select:function(e,ui){
			console.log('Cliente seleccionado: '+ui.item.value);
			$("#clienteId").val(ui.item.id);
			$("#cliente").val(ui.item.cliente.nombre);
			$("#socioId").val(null);
			$("#socio").val(null);
			
		}
	});*/
	$("#next").click(function(){
		console.log('Siguiete paso');
		$("#updateForm").submit();
	});
	
});
</script>

</content>	

	

</body>
</html>