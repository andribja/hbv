<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Upplýsingar um notanda</title>
</t:head>

<t:wrapper>
	<h2>Notandi: ${user.username}</h2>
	<a href="/ads/my_ads">Mínar auglýsingar</a>

	<c:choose>
		<c:when test="${not empty ads}">
			<p>Þú átt eftir að gefa umsögn fyrir eftirfarandi auglýsingar:</p>
			<ul>
			<c:forEach var="ad" items="${ads}">
				<li><a href="/ads/${ad.id}">${ad.name}</a> -
					<a href="/review?ad_id=${ad.id}">Skilja eftir umsögn</a> </li>
			</c:forEach>
			</ul>
		</c:when>
	</c:choose>
</t:wrapper>
