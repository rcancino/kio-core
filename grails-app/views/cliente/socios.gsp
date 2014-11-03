<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="layout" content="catalogos_show"/>
	<title>Cliente (${clienteInstance.id})</title>
</head>
<body>

	<content tag="header">
		<h3>Cliente: ${clienteInstance}</h3>
	</content>
	<content tag="beanId">${clienteInstance.id}</content>

	<content tag="tasks">
		<g:link action="index" class="list-group-item ">
		    <span class="glyphicon glyphicon-list"></span> Catálogo
		</g:link>
		<g:link action="create" class="list-group-item ">
		    <span class="glyphicon glyphicon-floppy-saved"></span> Nuevo
		</g:link>
		<g:link action="edit" class="list-group-item " id="${clienteInstance.id}">
		    <span class="glyphicon glyphicon-pencil"></span> Editar
		</g:link>
		
	</content>
	
	
	
	<content tag="form">
		<div class="col-md-12">
			<div class="page-header">
				<h3>
					Membresias asociadas
				</h3>
			</div>
			<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<g:sortableColumn property="id" title="No Socio"/>
			<g:sortableColumn property="apellidoPaterno" title="Nombre"/>
			<th>Servicio</th>
			<th>Vencimiento</th>
			<th>Corporativo</th>
			<th>Area</th>
			<th>Activo</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${socioInstanceList}" var="row">
			<tr class="${row.activo?'':'danger'}">
				
				<td>
					<g:link action="show" id="${row.id}">
						${fieldValue(bean:row,field:"numeroDeSocio")}
					</g:link>
				</td>
				<td>${row.toString()}</td>
				<td>
					<g:link controller="producto" action="show" id="${row.membresia?.servicio?.id}">
						${fieldValue(bean:row,field:"membresia.servicio.descripcion")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"membresia.proximoPago")}</td>
				<td>${fieldValue(bean:row,field:"perfil.tipoDeCorporativo")}</td>
				<td>${fieldValue(bean:row,field:"perfil.areaDeInteres")}</td>
				<td class="text-center">
					<g:checkBox name="myCheckbox" value="${row.activo}" disabled="true"/>
				</td>
				
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${socioInstanceCount ?: 0}"/>
</div>
		</div>
		
		
		
	</content>
	
</body>
</html>