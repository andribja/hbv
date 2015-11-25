<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<html>
	<body>
		<div class="container-fluid">
			<div class="col-xs-3 col-md-2" id="sidenav">
				<nav class="nav affix">
					<ul class="nav nav-pills nav-stacked">
						<li><a href="/">Heim</a></li>
						<c:choose>
							<c:when test="${empty sessionScope.user}">
								<li><a href="/search">Leita</a></li>
								<li><a href="/ads">Skoða auglýsingar</a></li>
								<li><a href="/login">Innskráning</a></li>
								<li><a href="/signup">Nýskráning</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/userpage">${sessionScope.user.username}</a></li>
								<li><a href="/users">Notendur</a></li>
								<li><a href="/ads">Skoða auglýsingar</a></li>
								<li><a href="/search">Leita</a></li>
								<li><a href="/new/ad">Skrá auglýsingu</a></li>
								<li><a href="/logout">Útskráning</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
			</div>
			<div class="col-xs-9 col-lg-8">
				<jsp:doBody/>
			</div>
		</div>
	</div>
</body>
</html>