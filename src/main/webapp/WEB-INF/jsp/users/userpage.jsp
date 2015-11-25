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

    <p>Auglýsingar notanda: ${user.username}</p>

    <c:choose>
        <c:when test="${not empty ads}">
            <ul class="list-group">
                <c:forEach var="ad" items="${ads}">
                    <a href="/ads/${ad.id}" class="list-group-item">
                        <span class="adlist-item adlist-title">
                            <h4>${ad.name}</h4>
                            <p>${ad.creationTimestamp}</p>
                        </span>
                        <span class="adlist-item">
                            <p>${ad.content}</p>
                        </span>

                        <c:choose>
                            <c:when test="${sessionScope.user.id eq ad.author.id}">
                                <span class="adlist-item float-right">
                                    <form method="post" commandName="ad" role="form">
                                        <input type="submit" formaction="/ad/delete?id=${ad.id}" value="Eyða" class="btn btn-default"></input>
                                        <input type="submit" formaction="/ad/edit/${ad.id}" formmethod="get" value="Breyta" class="btn btn-default"></input>
                                    </form>
                                </span>
                            </c:when>
                        </c:choose>
                    </a>
                </c:forEach>
            </ul>
        </c:when>
    </c:choose>
</t:wrapper>