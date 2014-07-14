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
            	<g:if test="${pageProperty(name:'page.toolbar')}">
                    <g:pageProperty name="page.toolbar"/>
                </g:if>
                <g:else><g:render template="/_common/catalogosToolbar"/></g:else>  
                
            </div><!-- end .row 2 Toolbar -->

            <div class="row">
                <div class="col-md-12">
                    <g:render template="grid"/>
                </div>
            </div>

           

            
            
        </div>
        
    
        
    </body>
</g:applyLayout>