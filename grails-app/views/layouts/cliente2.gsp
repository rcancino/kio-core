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
								<h2>Falta definir header</h2>
							</g:else>
	  					</div>
	  					<div class="panel-body">
							%{-- <g:render template="toolbar"/> --}%
	  					</div>
	  					<div class="row">
							%{-- <div class="col-md-12"><g:render template="grid"/></div> --}%
						</div>
					</div>

					
				</div>
			</div>
		</div><!-- end .container -->

	</body>
</g:applyLayout>