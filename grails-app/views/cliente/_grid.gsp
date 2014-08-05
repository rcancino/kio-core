<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<g:sortableColumn property="id" title="Id"/>
			<g:sortableColumn property="nombre" title="Nombre"/>
			<th>RFC</th>
			<th>Tipo</th>
			
			<g:sortableColumn property="direccion.colonia" title="Colonia"/>
			<th>Modificado</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${clienteInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="show" id="${row.id}">
						${fieldValue(bean:row,field:"id")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"nombre")}</td>
				<td>${fieldValue(bean:row,field:"rfc")}</td>
				<td>${fieldValue(bean:row,field:"tipo")}</td>
				<td>${fieldValue(bean:row.direccion,field:"colonia")}</td>
				<td><g:formatDate date="${row.lastUpdated}" format="dd/MM/yyyy hh:mm"/></td>
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${clienteInstanceCount ?: 0}"/>
</div>