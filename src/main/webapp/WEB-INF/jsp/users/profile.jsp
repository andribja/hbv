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
    <a href="/ads/user/${user.id}">Auglýsingar notanda</a>
    <a href="/"
</t:wrapper>
