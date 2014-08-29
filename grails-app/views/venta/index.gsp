<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="application"/>
	<title>Ventas</title>
</head>
<body>
	<div class="container">

		
		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-info">
					<h2>Ventas</h2>
					<g:if test="${flash.message}">
	                    <div class="">
	                        <span class="label label-warning">${flash.message}</span>
	                    </div>
                	</g:if> 
				</div>
			</div>
		</div><!-- end .row 1 Header -->

		<div class="row">
			
			<div class=" col-md-4">
				<g:link action="index" class="btn btn-default ">
					<span class="glyphicon glyphicon-repeat"></span> Refrescar
				</g:link>
				<g:link action="create" class="btn btn-default">
					<span class="glyphicon glyphicon-floppy-saved"></span> Nueva
				</g:link>
				
				
			</div>

			<div class="btn-group col-md-3">
				<div class="input-group ">
					<div class="input-group-addon"><span class="glyphicon glyphicon-search"></span></div>
					<input type="text" class="form-control" placeholder="Buscar" autofocus="autofocus">
				</div>
			</div>
			
		</div><!-- end .row toolbar -->
		
		<div class="row">
			<div class="col-md-12">
				%{-- <g:render template="grid"/> --}%
				<table class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<g:sortableColumn property="id" title="Id"/>
							<th>Cliente</th>
							<th>Rfc</th>
							<th>Status</th>
							
							<th>Fecha</th>
							<th>Importe</th>
							<th>Impuesto</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${ventaInstanceList}" var="row">
							<tr>
								<td>
									<g:link action="${row.status=='PEDIDO'?'edit':'show'}" id="${row.id}">
										${fieldValue(bean:row,field:"id")}
									</g:link>
								</td>
								<td>
									<g:link action="${row.status=='PEDIDO'?'edit':'show'}" id="${row.id}">
										${fieldValue(bean:row,field:"cliente.nombre")}
									</g:link>
									
								</td>
								<td>${fieldValue(bean:row,field:"cliente.rfc")}</td>
								<td>${fieldValue(bean:row,field:"status")}</td>
								<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
								<td><g:formatNumber number="${row.importeNeto}" type="currency"/></td>
								<td><g:formatNumber number="${row.impuesto}" type="currency"/></td>
								<td><g:formatNumber number="${row.total}" type="currency"/></td>
							</tr>
						</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${ventaInstanceCount ?: 0}"/>
				</div>
			</div>
		</div>

	</div>
	
</body>
</html>