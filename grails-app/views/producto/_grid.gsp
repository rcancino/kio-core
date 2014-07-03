<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<g:sortableColumn property="id" title="Id"/>
			<g:sortableColumn property="clave" title="Clave"/>
			<g:sortableColumn property="descripcion" title="Descripcion"/>
			<th>Tipo</th>
			<th>Modificado</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${productoInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="show" id="${row.id}">
						${fieldValue(bean:row,field:"id")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"clave")}</td>
				<td>${fieldValue(bean:row,field:"descripcion")}</td>
				<td>${fieldValue(bean:row,field:"tipo.clave")}</td>
				<td><g:formatDate date="${row.lastUpdated}"/></td>
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${productoInstanceCount ?: 0}"/>
</div>