<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<g:sortableColumn property="id" title="Id"/>
			<th>Serie</th>
			<th>Folio</th>
			<th>Fecha</th>
			<th>Receptor</th>
			<th>UUID</th>			
			<th>Total</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${cfdiInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="show" id="${row.id}">
						${fieldValue(bean:row,field:"id")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"serie")}</td>
				<td>${fieldValue(bean:row,field:"folio")}</td>
				<td><g:formatDate date="${row.fecha}" format="dd/MM/yyyy"/></td>
				<td>${fieldValue(bean:row,field:"receptor")}</td>
				<td>${fieldValue(bean:row,field:"uuid")}</td>
				<td><g:formatNumber number="${row.total}" type="currency"/></td>
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${cfdiInstanceCount ?: 0}"/>
</div>