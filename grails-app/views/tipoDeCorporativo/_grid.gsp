<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td>Id</td>
			<th>Clave</th>
			<th>Descripción</th>
			<th>Activo</th>
		</tr>
	</thead>
	<tbody>
		<g:each in="${tipoDeCorporativoInstanceList}" var="row">
			<tr>
				<td>
					<g:link action="show" id="${row.id}">
						${fieldValue(bean:row,field:"id")}
					</g:link>
				</td>
				<td>${fieldValue(bean:row,field:"clave")}</td>
				<td>${fieldValue(bean:row,field:"descripcion")}</td>
				<td>
					<g:if test="${row.activo}">
						<i class="fa fa-check"></i>
					</g:if>
					<g:else>
						<i class="fa fa-times"></i>
					</g:else>
				</td>
			</tr>
		</g:each>
	</tbody>
</table>
<div class="pagination">
	<g:paginate total="${tipoDeCorporativoInstanceCount ?: 0}"/>
</div>