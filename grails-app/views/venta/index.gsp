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
			
			<div class="col-md-12">
				<div class="row toolbar-panel">
				    <div class="col-md-6">
				        <div class="input-group">
				          
				          <input type='text' id="filtro" placeholder="Filtrar" class="form-control" autofocus="on">
				          <span class="input-group-btn">
				            <button type="button" name="search"
				                class="btn btn-default" data-toggle="modal" data-target="#searchDialog">
				                <i class="fa fa-search"></i> Buscar
				        	</button>
				          </span>
				        </div><!-- /input-group -->
				    </div>
				   

				    <div class="btn-group">
				        <g:link action="${action}" class="btn btn-default ">
				            <span class="glyphicon glyphicon-repeat"></span> Refrescar
				        </g:link>
				    </div>

				    <div class="btn-group">
				        <button type="button" name="operaciones"
				                class="btn btn-default dropdown-toggle" data-toggle="dropdown"
				                role="menu">
				                Operaciones <span class="caret"></span>
				        </button>
				        <ul class="dropdown-menu">
				            <li>
				                <g:link action="create" >
				                    <i class="fa fa-plus"></i> Nuevo
				                </g:link>
				            </li>
				        </ul>
				    </div>
				    <div class="btn-group">
				        <button type="button" name="reportes"
				                class="btn btn-default dropdown-toggle" data-toggle="dropdown"
				                role="menu">
				                Reportes <span class="caret"></span>
				        </button>

				        <ul class="dropdown-menu">
				            
				            
				        </ul>
				    </div>
				    
				</div>
			</div>
			
		</div><!-- end .row toolbar -->
		
		<div class="row">
			<div class="col-md-12">
				%{-- <g:render template="grid"/> --}%
				<table class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>Folio</th>
							<th>Fac</th>
							<th>Fecha</th>
							<th>Cliente</th>
							<th>Total</th>
							<th>Atendió</th>
							<th>Comentario</th>
							<th>Cobrar</th>
							
							

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
									<g:if test="${row.cfdi}">
										<g:link action="show" id="${row.cfdi.id}">
											${row.cfdi.folio}
										</g:link>
									</g:if>
								</td>
								<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
								<td>
									<g:link action="${row.status=='PEDIDO'?'edit':'show'}" id="${row.id}">
										${fieldValue(bean:row,field:"cliente.nombre")}
									</g:link>
									
								</td>
								<td><g:formatNumber number="${row.total}" type="currency"/></td>
								<td>${fieldValue(bean:row,field:"creadoPor")}</td>
								<td>${fieldValue(bean:row,field:"comentario")}</td>
								<td>
									<g:if test="${row.saldo>0}">
										<g:link action="mandarFacturar" id="${row.id}">
											<span class="glyphicon glyphicon-shopping-cart"></span>
										</g:link>
									</g:if>
								</td>
								
								
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