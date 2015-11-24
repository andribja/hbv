<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<html>
	<body>
		<div class="container-fluid">
			<div class="col-xs-3" id="sidenav">
				<nav class="nav affix">
					<ul class="nav nav-pills nav-stacked">
						<li><a href="/">Heim</a></li>
						<li><a href="/userpage">Minn aðgangur</a></li>
						<li><a href="/users">Notendur</a></li>
						<li><a href="/new/user">Skrá notanda</a></li>
						<li><a href="/ads">Skoða auglýsingar</a></li>
						<li><a href="/new/ad">Skrá auglýsingu</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-xs-9 col-md-8">
				<jsp:doBody/>
			</div>
		</div>
	</div>
</body>
</html>