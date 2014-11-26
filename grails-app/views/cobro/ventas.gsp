<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	%{-- <meta name="layout" content="application"/> --}%
	<meta name="layout" content="pago"/>
	<title>Caja</title>
	<asset:stylesheet src="datatables/dataTables.css"/>
	<asset:javascript src="datatables/dataTables.js"/> 
</head>
<body>

<content tag="header">
	<h3>Ventas generadas</h3>
	<nav:set path="user/operaciones/caja/ventas"/>
</content>

<content tag="operaciones">
	%{-- <li>
	    <g:link action="create" >
	        <i class="fa fa-plus"></i> Nuevo
	    </g:link>
	    
	</li> --}%
</content>
<content tag="refreshButton">
	<g:link action="ventas" class="btn btn-default ">
	    <span class="glyphicon glyphicon-repeat"></span> Refrescar
	</g:link>
</content>
<content tag="reportes">
	<li><g:link controller="reporte" action="pagosPorDia"> Ventas del día</g:link></li>
</content>
<content tag="document">
		<div class="">
			<table id="cajaTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th>Id</th>
						<th>Cliente</th>
						<th>Status</th>
						<th>Fecha</th>
						%{-- <th>Importe</th>
						<th>Impuesto</th> --}%
						<th>Total</th>
						<th>Pagos</th>
						<th>Saldo</th>
						<th>CFDI</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${ventaInstanceList}" var="row">
						<tr id="${row.id}">
							<td >
								<g:link  action="showVenta" id="${row.id}">
									${fieldValue(bean:row,field:"id")}
								</g:link>
							</td>
							<td>
								<abbr title="${row.cliente.nombre}">
									<g:link action="showVenta" id="${row.id}">
										${org.apache.commons.lang.StringUtils.substring(row.cliente.nombre,0,20)}
									</g:link>
								</abbr>
							</td>
							<td>
								<abbr title="${row.status}">
									${org.apache.commons.lang.StringUtils.substring(row.status,0,3)}
								</abbr>
							</td>
							
							<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
							<td><g:formatNumber number="${row.total}" type="currency"/></td>
							<td>
								<g:link action="showVenta" id="${row.id}">
									<g:formatNumber number="${row.pagos}" type="currency"/></td>
								</g:link>
								
							<td><g:formatNumber number="${row.saldo}" type="currency"/></td>
							<td>
								
									<g:if test="${row.cfdi}">
										<abbr title="${row.cfdi.uuid}">
										<g:link controller="cfdi" action="show" id="${row?.cfdi?.id}">
											${org.apache.commons.lang.StringUtils.substringAfterLast(row?.cfdi?.uuid,'-')}
										</g:link>
										</abbr>
									</g:if>
								
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
			
		</div>
	</div>
</content>
<content tag="javascript">
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

		});
	</script>
</content>


	
</body>
</html>