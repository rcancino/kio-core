<%@ page import="com.luxsoft.kio.MedioDeContacto" %>



<div class="fieldcontain ${hasErrors(bean: medioDeContactoInstance, field: 'clave', 'error')} required">
	<label for="clave">
		<g:message code="medioDeContacto.clave.label" default="Clave" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="clave" required="" value="${medioDeContactoInstance?.clave}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: medioDeContactoInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="medioDeContacto.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${medioDeContactoInstance?.descripcion}"/>

</div>

