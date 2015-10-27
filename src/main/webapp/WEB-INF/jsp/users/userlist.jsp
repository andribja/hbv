<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Notendur</title>
</t:head>

<t:wrapper>
	<h2>Notendur</h2>
	<c:choose>
		<c:when test="${not empty users}">
			<c:forEach var="user" items="${users}">
                <a href="/users/${user.username}" class="list-group-item">
					<h4>${user.username}</h4>
					<p>${user.email}</p>
                </a>
            </c:forEach>
		</c:when>
	</c:choose>
</t:wrapper>
