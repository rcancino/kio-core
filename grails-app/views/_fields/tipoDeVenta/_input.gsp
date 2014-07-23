<%@page expressionCodec="none" %>

<g:select class="form-control"  
	name="${property}" 
	value="${value?.id}"
	from="${com.luxsoft.kio.TipoDeVenta.findAll()}" 
	optionKey="id" 
	optionValue="clave"
	/>