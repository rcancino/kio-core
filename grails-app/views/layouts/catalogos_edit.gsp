<g:applyLayout name="application">
    <html>
    <head>
        <title><g:layoutTitle/></title>
        <g:layoutHead/>
    </head>
    </html>
    <body>

        <div class="container">

            <div class="row">
                <div class="col-md-12">
                    <div class="alert alert-info">
                        <g:if test="${pageProperty(name:'page.header')}">
                            <g:pageProperty name="page.header"/>
                        </g:if>
                        <g:else> <h3>Falta Page Header</h3></g:else>  
                         <g:if test="${flash.message}">
                            <div class="col-md-offset-4">
                                <span class="label label-warning">${flash.message}</span>
                            </div>
                        </g:if>  
                    </div>
                </div>
            </div><!-- end .row 1 Header -->
            
            <div class="row">
            	
            	<div class="col-md-2">
            		<div class="list-group">
						<g:link action="index" class="list-group-item ">
							<span class="glyphicon glyphicon-list"></span> Catálogo
						</g:link>
						<g:link action="create" class="list-group-item ">
							<span class="glyphicon glyphicon-floppy-saved"></span> Nuevo
						</g:link>
						<g:link action="delete" class="list-group-item " id="${g.pageProperty(name:'page.beanId') }"
                            onclick="return confirm('Eliminar el registro?');">
							<span class="glyphicon glyphicon-trash"></span> Eliminar
						</g:link>
					</div>
            	</div><!-- End .col-md-2 side bar -->
            	
            	<div class="col-md-10">
            		<div class="row">
            			<g:pageProperty name="page.form"/>
            		</div>
            		
					
            	</div>
            	
            </div><!-- end .row 2  -->
            
            <div class="row">
            	
            </div>
            
        </div>
        
    </body>
</g:applyLayout>