<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td>Id</td>
			<th>Clave</th>
			<th>Descripción</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${tipoDeSocioInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="show" id="${row.id}">
						${fieldValue(bean:row,field:"id")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"clave")}</td>
				<td>${fieldValue(bean:row,field:"descripcion")}</td>
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${tipoDeSocioInstanceCount ?: 0}"/>
</div>