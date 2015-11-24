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

    <p>Þínar auglýsingar</p>

    <c:choose>
        <c:when test="${not empty ads}">
            <ul class="list-group">
                <c:forEach var="ad" items="${ads}">
                    <a href="/ads/user/${user.id}" class="list-group-item">
                        <span class="adlist-item adlist-title">
                            <h4>${ad.name}</h4>
                            <p>${ad.creationTimestamp}</p>
                        </span>
                        <span class="adlist-item">
                            <p>${ad.content}</p>
                        </span>

                        <span class="adlist-item float-right">
                            <form action="/ad/delete?id=${ad.id}" method="post" commandName="ad" role="form">
                                <input type="submit" value="Eyða" class="btn btn-default"></input>
                            </form>
                        </span>
                    </a>
                </c:forEach>
            </ul>
        </c:when>
    </c:choose>
</t:wrapper>