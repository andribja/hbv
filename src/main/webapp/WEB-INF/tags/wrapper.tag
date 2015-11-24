<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>

<html>
	<body>
		<div class="container">
	    	<div class="container-fluid">
	    		<div class="col-md-3">
					<nav class="nav" style="float:left">
					    <div class="container-fluid">
					        <div class="nav navbar-pills navbar-stacked">
					        	<li><a href="/">Heim</a></li>
					            <li><a href="/userpage">Minn aðgangur</a></li>
					            <li><a href="/users">Notendur</a></li>
					            <li><a href="/signup">Skrá notanda</a></li>
					            <li><a href="/ads">Skoða auglýsingar</a></li>
					            <li><a href="/new/ad">Skrá auglýsingu</a></li>
					        </div>
					    </div>
					</nav>
				</div>

				<div class="col-md-9">
					<jsp:doBody/>
				</div>
			</div>
		</div>	
	</body>
</html>