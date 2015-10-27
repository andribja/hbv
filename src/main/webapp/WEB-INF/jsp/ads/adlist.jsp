<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Auglýsingar</title>
</t:head>

<t:wrapper>
    <h2>Auglýsingar</h2>

    <p>Hér eru auglýsingarnar</p>

    <c:choose>
        <c:when test="${not empty ads}">
            <ul class="list-group">
                <c:forEach var="ad" items="${ads}">
                    <a href="/ads/${ad.id}" class="list-group-item">
                        <span style="width: 15em; display: inline-block;">
                            <h4>${ad.name}</h4>
                            <p>${ad.creationTimestamp}</p>
                        </span>
                        <span style="display: inline-block;">
                            <p>${ad.content}</p>
                        </span>
                    </a>
                </c:forEach>
            </ul>
        </c:when>
    </c:choose>
</t:wrapper>