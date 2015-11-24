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
	<a href="ads/user/${sessionScope.user.id}">Auglýsingar notanda</a>
</t:wrapper>
