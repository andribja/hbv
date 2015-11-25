<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Prófíll</title>
</t:head>

<t:wrapper>
    <h2>Notandi: ${user.username}</h2>
    <p>Hér er public prófæll notandans ${user.username}</p>
    <a class="btn btn-default" href="/ads/user/${user.id}" role="button">Auglýsingar notanda</a>
    <a class="btn btn-default" href="/message?user_id=${user.id}" role="button">Senda skilaboð</a>
    <c:choose>
		<c:when test="${not empty reviews}">
			<h3>Umsagnir um ${user.username}</h3>
			<c:forEach var="review" items="${reviews}">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Umsögn eftir <a href="/users/${review.sender.id}">${review.sender.username}</a></h3>
					</div>
					<div class="panel-body">
						<p>${review.comment}</p>
					</div>
					<div class="panel-footer">
						<p class="rating">Einkunn: ${review.rating}</p>
					</div>
				</div>
			</c:forEach>
		</c:when>
	</c:choose>
</t:wrapper>
