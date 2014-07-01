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
					<g:if test="${flash.message}">
						<div class=" alert alert-info message" role="status">
							<strong>${flash.message}</strong>
						</div>
					</g:if>
					<g:if test="${pageProperty(name:'page.header')}">
						<g:pageProperty name="page.header"/>
					</g:if>
					
				</div>
			</div><!-- end .row 1 -->
			
			<div class="row">
				<div class="col-md-2">
					<g:if test="${pageProperty(name:'page.taskPanel')}">
						<g:pageProperty name="page.taskPanel"/>
					</g:if>
				</div><!-- end .col-md-2 -->
			</div><!-- end .row 2 -->
		
		</div><!-- end .container -->
		
	</body>
</g:applyLayout>