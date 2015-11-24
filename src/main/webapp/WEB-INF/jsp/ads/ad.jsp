<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Auglýsing</title>
</t:head>

<t:wrapper>
	<h2>Auglýsing</h2>
	<c:choose>
		<c:when test="${not empty ad}">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">${ad.name}</h3>
				</div>
				<div class="panel-body">
					<p>${ad.content}</p>
				</div>
			</div>
		</c:when>
	</c:choose>
</t:wrapper>
