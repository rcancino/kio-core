<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="pago"/>
	<title>Caja</title>
	<asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> 
</head>
<body>

<content tag="header">
	<h3>Cobros registrados</h3>
	<nav:set path="user/operaciones/caja/cobros"/>
</content>

<content tag="operaciones">
	%{-- <li>
	    <g:link action="create" >
	        <i class="fa fa-plus"></i> Nuevo
	    </g:link>
	    
	</li> --}%
</content>

<content tag="reportes">
	<li>
		%{-- <g:link controller="reporte" action="cobranza"> Cobranza</g:link> --}%
		<a href="#cobranzaDialog" data-toggle="modal">Cobranza</a>
	</li>
</content>	

<content tag="document">
	<div class="">
		<table id="cobrosTable" class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>Folio</th>
					
					<th>Cliente</th>
					<th>Venta</th>
					<th>Fecha</th>
					<th>Importe</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${cobroInstanceList}" var="row">
					<tr id="${row.id}">
						<td >
							<g:link  action="show" id="${row.id}">
								${fieldValue(bean:row,field:"id")}
							</g:link>
						</td>
						
						<td>
							<g:link  action="show" id="${row.id}">
								${fieldValue(bean:row,field:"cliente.nombre")}
							</g:link>
						</td>
						<td>${fieldValue(bean:row,field:"venta.id")}</td>
						<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
						<td><g:formatNumber number="${row.importe}" type="currency"/></td>
					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${cobroInstanceCount ?: 0}"/>
		</div>
		<g:render template="cobranzaDialog"/>
	</div>
</content>
<content tag="javascript">
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#cobrosTable').dataTable( {
	        	"paging":   false,
	        	"ordering": false,
	        	"info":     false
	        	,"dom": '<"toolbar col-md-4">rt<"bottom"lp>'
	    	} );

	    	var table = $('#cobrosTable').DataTable();
	    	
	    	$("#filterField").on('keyup',function(e){
	    		var term=$(this).val();
	    		//console.log('Filtrando para: '+term);
	    		$('#cobrosTable').DataTable().search(
					$(this).val()
	    		).draw();
	    	});

	   //  	$("#fecha").datepicker({
	     
	 		// });

		});
	</script>
</content>

	<div class="container">
		
		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h2></h2>
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
			<g:link action="index" class="btn btn-default ">
				<span class="glyphicon glyphicon-repeat"></span> Refrescar
			</g:link>

			<g:link action="pendientes" class="btn btn-default ">
				<span class="glyphicon glyphicon-tasks"></span> Pendientes
			</g:link>
			
		</div><!-- end .row toolbar -->

		<br/>
		<div class="row">

			
		</div>

	</div>


	
</body>
</html>