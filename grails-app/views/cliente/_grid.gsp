<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<g:sortableColumn property="id" title="Id"/>
			<g:sortableColumn property="nombre" title="Nombre"/>
			<th>Dirección</th>
			<th>RFC</th>
			<th>Email</th>
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
				<td>${fieldValue(bean:row,field:"direccion")}</td>
				<td>${fieldValue(bean:row,field:"rfc")}</td>
				<td>${fieldValue(bean:row,field:"emailCfdi")}</td>
				
				
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${clienteInstanceCount ?: 0}"/>
</div>