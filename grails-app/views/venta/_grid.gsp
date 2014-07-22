<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<g:sortableColumn property="id" title="Id"/>
			<th>Modificado</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${ventaInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="show" id="${row.id}">
						${fieldValue(bean:row,field:"id")}
					</g:link>
				</td>
				<td><g:formatDate date="${row.lastUpdated}"/></td>
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${ventaInstanceCount ?: 0}"/>
</div>