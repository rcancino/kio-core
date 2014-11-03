<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="application"/>
	<title>Caja</title>
	<asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> 
</head>
<body>
	<div class="container">
		
		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h2>Ventas pendientes de cobro</h2>
					<g:if test="${flash.message}">
	                    <div class="">
	                        <span class="label label-warning">${flash.message}</span>
	                    </div>
                	</g:if> 
				</div>
			</div>
		</div><!-- end .row 1 Header -->

		<div class="row">
			<div class="col-md-4">
				<div class="input-group ">
					<div  class="input-group-addon"><span class="glyphicon glyphicon-search"></span></div>
					<input id="filterField" type="text" class="form-control" placeholder="Buscar" 
						autofocus="autofocus" autocomplete="off">
				</div>
			</div>
			<g:link action="pendientes" class="btn btn-default ">
				<span class="glyphicon glyphicon-repeat"></span> Refrescar
			</g:link>

			<g:link action="index" class="btn btn-default" params="[tipo:'cobros']">
				<span class="glyphicon glyphicon-usd"></span> Cobros
			</g:link>
			
		</div><!-- end .row toolbar -->

		<br/>
		<div class="row">

			<div class="col-md-12">
				<table id="cajaTable" class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>Venta</th>
							<th>Cliente</th>
							
							<th>Rfc</th>
							<th>Status</th>
							<th>Tipo</th>
							<th>Fecha</th>
							<th>Importe</th>
							<th>Impuesto</th>
							<th>Total</th>
							<th>Saldo</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${ventaInstanceList}" var="row">
							<tr id="${row.id}">
								<td >
									<g:link  action="${row.status=='VENTA'?'registrar':'show'}" id="${row.id}">
										${fieldValue(bean:row,field:"id")}
									<span class="glyphicon glyphicon-shopping-cart"></span> 
									</g:link>
								</td>
								<td>
									<g:link action="${row.status=='VENTA'?'registrar':'show'}" id="${row.id}">
										${fieldValue(bean:row,field:"cliente.nombre")}
									</g:link>
									
								</td>
								
								<td>${fieldValue(bean:row,field:"cliente.rfc")}</td>
								<td>${fieldValue(bean:row,field:"status")}</td>
								<td>${fieldValue(bean:row,field:"tipo")}</td>
								<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
								<td><g:formatNumber number="${row.importe}" type="currency"/></td>
								<td><g:formatNumber number="${row.impuesto}" type="currency"/></td>
								<td><g:formatNumber number="${row.total}" type="currency"/></td>
								<td><g:formatNumber number="${row.saldo}" type="currency"/></td>
							</tr>
						</g:each>
					</tbody>
				</table>
				
			</div>
		</div>

	</div>

<script type="text/javascript">
	$(document).ready(function(){
		
		$('#cajaTable').dataTable( {
        	"paging":   false,
        	"ordering": false,
        	"info":     false
        	,"dom": '<"toolbar col-md-4">rt<"bottom"lp>'
    	} );

    	var table = $('#cajaTable').DataTable();

    	$('#cajaTable tbody').on( 'click', 'tr', function () {
	        $(this).toggleClass('success');
    	 });
    	
    	$("#filterField").on('keyup',function(e){
    		var term=$(this).val();
    		//console.log('Filtrando para: '+term);
    		$('#cajaTable').DataTable().search(
				$(this).val()
    		        
    		).draw();
    	});

    	$("#cobrar").on('click',function(e){
    		var selected=getSelected();
    		console.log('Seleccionados: '+selected);
    		if(selected.length===0){
    			alert("Debe seleccionar la venta a cobrar");
    			return;
    		}else{
    			//Pendiente de implementar Crear un  dato post 
    			var rows=getSelected();
    			if(rows.length>0){
    				console.log('Registros seleccionados: '+rows[0]);
    			}
    		}
    		//
    	});

    	var getSelected=function(){
			var res=[];
			var data=$("#cajaTable .success").each(function(){
				var tr=$(this);
				res.push(tr.attr("id"));
			});
			return res;
		}

	});
</script>
	
</body>
</html>