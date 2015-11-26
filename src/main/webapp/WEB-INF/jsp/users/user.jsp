<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:head>
    <title>Upplýsingar um notanda</title>
</t:head>

<t:wrapper>
	<h2>Notandi: ${user.username}</h2>
	<a class="btn btn-default" href="/ads/my_ads" role="button">Mínar auglýsingar</a>
	<a class="btn btn-default" href="/messages/my_messages" role="button">Mín skilaboð (${fn:length(unread)})</a>

	<hr>

	<c:choose>
		<c:when test="${not empty ads}">
			<p>Þú átt eftir að gefa umsögn fyrir eftirfarandi auglýsingar:</p>
			<ul class="list-group">
			<c:forEach var="ad" items="${ads}">
				<li class="list-group-item">
					<a href="/ads/${ad.id}"><h4>${ad.name}</h4></a>
					<a href="/review?ad_id=${ad.id}">Skilja eftir umsögn</a>
					</li>
				</li>
			</c:forEach>
			</ul>
		</c:when>
	</c:choose>
</t:wrapper>
