<%@page expressionCodec="none" %>

<g:select class="form-control"  
	name="${property}" 
	value="${value}"
	from="${['SERVICIO','PIEZA','NA']}"
	noSelection="[null:'Seleccione una unidad']"/>




