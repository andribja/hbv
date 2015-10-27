<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Auglýsing</title>
</t:head>

<t:wrapper>
	<c:choose>
		<c:when test="${not empty ad}">
			<h2>${ad.name}</h2>
			<p>${ad.content}</p>
		</c:when>
	</c:choose>
</t:wrapper>
