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
					<a href="/users/${ad.author.id}" class="text-muted">${ad.author.username}</a>
				</div>
				<div class="panel-body">
					<p>${ad.content}</p>
				</div>
				<div class="panel-footer">
					<c:choose>
						<c:when test="${not empty sessionScope.user}">
							<a href="/message?user_id=${ad.author.id}&ad_id=${ad.id}">Hefurðu áhuga? Sendu ${ad.author.username} skilaboð</a>
						</c:when>
						<c:otherwise>
							<a href="/login?redirect=true">Hefurðu áhuga? Skráðu þig inn til að senda ${ad.author.username} skilaboð</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:when>
	</c:choose>
</t:wrapper>
