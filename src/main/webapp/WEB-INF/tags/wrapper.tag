<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>

<html>
	<body>
		<nav class="nav" style="float:left">
		    <div class="container-fluid">
		        <div class="nav navbar-pills navbar-stacked">
		        	<li><a href="/">Heim</a></li>
		            <li><a href="/userpage">Minn aðgangur</a></li>
		            <li><a href="/users">Notendur</a></li>
		            <li><a href="/new/user">Skrá notanda</a></li>
		            <li><a href="/ads">Skoða auglýsingar</a></li>
		            <li><a href="/new/ad">Skrá auglýsingu</a></li>
		        </div>
		    </div>
		</nav>
		<div class="container">
	    	<div class="container-fluid">
				<jsp:doBody/>
			</div>
		</div>	
	</body>
</html>