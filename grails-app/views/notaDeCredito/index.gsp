<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="pago"/>
	<title>Notas</title>
	<asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> 
</head>
<body>

<content tag="header">
	<h3>Notas de crédito registradas</h3>
	<nav:set path="user/operaciones/caja/notasDeCredito"/>
</content>

<content tag="operaciones">
	<li>
	    <g:link action="create" >
	        <i class="fa fa-plus"></i> Nuevo
	    </g:link>
	    
	</li>
</content>
<content tag="reportes">
	<li><g:link controller="reporte" action="notasDeCredito"> General </g:link></li>
	<li><g:link controller="reporte" action="notasDeCredito"> Por cliente </g:link></li>
	<li><g:link controller="reporte" action="notasDeCredito"> Por Fecha </g:link></li>
</content>

<content tag="document">
<div class="">
	
	
	<table id="grid" class="table table-striped table-bordered table-condensed">

		<thead>
			<tr>
				<th>Folio</th>
				<th>Cliente</th>
				<th>Fecha</th>
				<th>Importe</th>
				<th>Tipo</th>
				<th>Estatus</th>
				<th>Cfdi</th>
				<th>Modificado</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${notaDeCreditoInstanceList}" var="row">
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
					<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
					<td><g:formatNumber number="${row.importe}" type="currency"/></td>
					<td>${row.tipo}</td>
					<td>${row.estatus}</td>
					<td>${row?.cfdi?.uuid}</td>
					<td><g:formatDate date="${row.lastUpdated}" format="dd/MM/yyyy HH:mm"/></td>
				</tr>
			</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<g:paginate total="${notaDeCreditoInstanceCount ?: 0}"/>
	</div>
</div>
</content><!-- End content document -->

<content tag="searchForm">
	<g:render template="search"/>
	
</content>

<content tag="javascript">
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#grid').dataTable( {
	        	"paging":   false,
	        	"ordering": false,
	        	"info":     false
	        	,"dom": '<"toolbar col-md-4">rt<"bottom"lp>'
	    	} );

	    	var table = $('#cajaTable').DataTable();
	    	
	    	
	    	$("#filtro").on('keyup',function(e){
	    		var term=$(this).val();
	    		//console.log('Filtrando para: '+term);
	    		$('#grid').DataTable().search(
					$(this).val()
	    		        
	    		).draw();
	    	});

		});
	</script>
	
</content>
	
	
</body>
</html>