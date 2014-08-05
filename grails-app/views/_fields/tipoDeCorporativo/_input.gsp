<%@page expressionCodec="none" %>

<g:select class="form-control"  
	name="${property}" 
	value="${value?.id}"
	from="${com.luxsoft.kio.TipoDeCorporativo.findAll()}" 
	optionKey="id" 
	optionValue="clave"
	noSelection="[null:'Seleccione un corporativo']"
	/>