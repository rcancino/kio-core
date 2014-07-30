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
				<div class="col-md-12 ">
					
					<div class="panel panel-primary">
						<!-- Default panel contents -->
	  					<div class="panel-heading">
	  						<g:if test="${pageProperty(name:'page.header')}">
								<g:pageProperty name="page.header"/>
							</g:if>
							<g:else>
								Falta definir header
							</g:else>
	  					</div>
	  					
	  					<div class="row">
	  						<div class="col-md-offset-12  ">
	  							<g:pageProperty name="page.info"/>
	  						</div>
	  					</div>
						
	  					<div class="panel-body">
							<g:pageProperty name="page.body"/>
	  					</div>
	  					
	  					
	  					<div class="panel-footer">
							<g:pageProperty name="page.footer"/>
	  					</div>
					</div>

					
				</div>
			</div>
		</div><!-- end .container -->
		<g:pageProperty name="page.js"/>
	</body>
</g:applyLayout>