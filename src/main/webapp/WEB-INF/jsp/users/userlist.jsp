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
				<div class="panel panel-default">
	                    <div class="panel-heading">
	                        <a href="/users/${user.id}">
	                            <h3 class="panel-title">${user.username}</h3>
	                        </a>    
	                    </div>
	                    <div class="panel-body">
	                        <p>Email: ${user.email}</p>
	                        <a class="btn btn-default" href="/ads/user/${user.id}" role="button">Auglýsingar notanda</a>
	    					<a class="btn btn-default" href="/message?user_id=${user.id}" role="button">Senda skilaboð</a>
	                    </div>
	            </div>
            </c:forEach>
		</c:when>
	</c:choose>
</t:wrapper>
