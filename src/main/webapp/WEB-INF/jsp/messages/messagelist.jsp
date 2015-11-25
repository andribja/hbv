<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Skilaboð</title>
</t:head>

<t:wrapper>
    <h2>Skilaboð</h2>
    <c:choose>
        <c:when test="${not empty messages}">
            <c:forEach var="message" items="${messages}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a href="/messages/${message.id}">
                            <h3 class="panel-title">${message.title}</h3>
                            <a href="/users/${message.sender.id}" class="text-muted">${message.sender.username}</a>
                        </a>
                    </div>
                    <div class="panel-body">
                        <p id="timestamp" class="text-muted">${message.sendTimestamp}</p>
                        <p>${message.content}</p>
                    </div>
                </div>
            </c:forEach>
        </c:when>
    </c:choose>
</t:wrapper>
