<table  id="accessLogGrid" class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			
			<th>Numero</th>
			<th>Nombre</th>
			<th>Tarjeta</th>
			<th>Activo</th>
			<th>Creado</th>
			<th>Replicado</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${accessLogInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="show" id="${row.id}">
						${fieldValue(bean:row,field:"numero")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"nombre")}</td>
				<td>${fieldValue(bean:row,field:"tarjeta")}</td>
				<td>${fieldValue(bean:row,field:"activo")}</td>
				<td><g:formatDate date="${row.dateCreated}" format="dd/MM hh:mm:ss"/></td>
				<td><g:formatDate date="${row.replicado}" format="dd/MM hh:mm:ss"/></td>
				
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${accessLogInstanceCount ?: 0}"/>
</div>