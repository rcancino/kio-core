<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Pagos</title>
	<asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> 
</head>
<body>

<content tag="header">
	<h3>Pagos registrados</h3>
	<nav:set path="user/operaciones/caja/pagos"/>
</content>

<content tag="operaciones">
	<li>
	    <g:link action="create" >
	        <i class="fa fa-plus"></i> Nuevo
	    </g:link>
	    
	</li>
</content>
<content tag="reportes">
	<li><g:link controller="reporte" action="pagosPorDia"> Pagos por día</g:link></li>
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
				<th>F.P</th>
				<th>Disponible</th>
				<th>Usuario</th>
				%{-- <th>Modificado</th> --}%
			</tr>
		</thead>
		<tbody>
			<g:each in="${pagoInstanceList}" var="row">
				<tr id="${row.id}">
					<td >
						<g:link  action="edit" id="${row.id}">
							${fieldValue(bean:row,field:"id")}
						</g:link>
					</td>
					<td>
						<g:link  action="edit" id="${row.id}">
							<abbr title="${row.cliente.nombre}">
								${org.apache.commons.lang.StringUtils.substring(row.cliente.nombre,0,20)}
							</abbr>
							%{-- ${fieldValue(bean:row,field:"cliente.nombre")} --}%
							
						</g:link>
					</td>
					<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
					<td><g:formatNumber number="${row.importe}" type="currency"/></td>
					<td>${row.formaDePago}</td>
					<td><g:formatNumber number="${row.disponible}" type="currency"/></td>
					<td>${org.apache.commons.lang.StringUtils.substring(row.usuario,0,10)}</td>
					%{-- <td><g:formatDate date="${row.lastUpdated}" format="dd/MM/yy HH:mm"/></td> --}%
				</tr>
			</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<g:paginate total="${pagoInstanceCount ?: 0}"/>
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