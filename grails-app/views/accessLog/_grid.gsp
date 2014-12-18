<table  id="accessLogGrid" class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			
			<th>Folio</th>
			<th>Numero</th>
			<th>Tarjeta</th>
			<th>Nombre</th>
			<th>Activo</th>
			<th>Creado</th>
			<th>Lectora 1</th>
			<th>Lectora 2</th>
			<th>Lectora 3</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${accessLogInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="show" id="${row.id}">
						${row.id}
					</g:link>
				</td>
				<td>${row.numero}</td>
				<td>${fieldValue(bean:row,field:"tarjeta")}</td>
				<td>${fieldValue(bean:row,field:"nombre")}</td>
				<td>${fieldValue(bean:row,field:"activo")}</td>
				<td><g:formatDate date="${row.dateCreated}" format="dd/MM HH:mm:ss"/></td>
				<td><g:formatDate date="${row.lectora1}" format="dd/MM HH:mm:ss"/></td>
				<td><g:formatDate date="${row.lectora2}" format="dd/MM HH:mm:ss"/></td>
				<td><g:formatDate date="${row.lectora3}" format="dd/MM HH:mm:ss"/></td>
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${accessLogInstanceCount ?: 0}"/>
</div>