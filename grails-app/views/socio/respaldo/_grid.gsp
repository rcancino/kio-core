<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<g:sortableColumn property="id" title="Id"/>
			<g:sortableColumn property="apellidoPaterno" title="Nombre"/>
			<th>Cliente</th>
			<th>Tipo</th>
			<th>Area</th>
			<th>Tel Casa</th>
			<th>Cell</th>
			<th>Modificado</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${socioInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="edit" id="${row.id}">
						${fieldValue(bean:row,field:"id")}
					</g:link>
				</td>
				<td>${row.toString()}</td>
				<td>
					<g:link controller="cliente" action="show" id="${row.cliente.id}">
						${fieldValue(bean:row,field:"cliente.rfc")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"tipoDeSocio.clave")}</td>
				<td>${fieldValue(bean:row,field:"areaDeInteres")}</td>
				<td>${fieldValue(bean:row,field:"telefonoCasa")}</td>
				<td>${fieldValue(bean:row,field:"celular")}</td>
				<td><g:formatDate date="${row.lastUpdated}"/></td>
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${socioInstanceCount ?: 0}"/>
</div>