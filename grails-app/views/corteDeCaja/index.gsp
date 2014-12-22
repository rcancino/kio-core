<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Cortes</title>
	<meta name="layout" content="pago"/>
	<asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> 
	<asset:stylesheet src="jquery-ui.css"/>
	<asset:javascript src="jquery-ui/autocomplete.js"/>
</head>
<body>

<content tag="header">
	<h3>Cortes de caja  (${session.fecha?:new Date().format('dd/MM/yyyy')})</h3>
	<nav:set path="user/operaciones/caja/corte"/>
</content>

<content tag="operaciones">
	<li>
		<a href="#corteForm" data-toggle="modal">
			<i class="fa fa-plus"></i> Nuevo
		</a>
	    
	    
	</li>
</content>
<content tag="reportes">
	<li>
		%{-- <g:link controller="reporte" action="cortesDeCaja"> Arqueo</g:link> --}%
		<a href="#arqueoForm" data-toggle="modal">Arqueo</a>
	</li>
</content>

<content tag="document">
<div class="grid-panel">
	
	<table id="grid" class="table table-striped table-bordered table-condensed">

		<thead>
			<tr>
				<th>Folio</th>
				<th>Fecha</th>
				<th>Hora</th>
				<th>Total</th>
				<th>Cajero</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${corteDeCajaInstanceList}" var="row">
				<tr id="${row.id}">
					<td >
						<g:link  action="show" id="${row.id}">
							${fieldValue(bean:row,field:"id")}
						</g:link>
					</td>
					<td>
						<g:link  action="show" id="${row.id}">
							<g:formatDate date="${row.fechaHora}" format="dd/MM/yyyy"/>
							%{-- <abbr title="${row.fecha}">
								${org.apache.commons.lang.StringUtils.substring(row.cliente.nombre,0,20)}
							</abbr> --}%
						</g:link>
					</td>
					<td>
						<g:formatDate date="${row.fechaHora}" format="HH:mm"/>
					</td>
					<td><g:formatNumber number="${row.total}" type="currency"/></td>
					<td>${row.cajero}</td>
				</tr>
			</g:each>
		</tbody>
	</table>
	
</div>

</content><!-- End content document -->

<content tag="searchForm">
	<g:render template="arqueoReport"/>
	<g:render template="generarCorte"/>
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