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
                <c:forEach var="ad" items="${ads}">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a href="/ads/${ad.id}">
                                <h3 class="panel-title">${ad.name}</h3>
                            </a>
                        </div>
                        <div class="panel-body">
                            <p id="timestamp" class="text-muted">${ad.creationTimestamp}</p>
                            <p>${ad.content}</p>
                        </div>
                            <c:choose>
                                <c:when test="${sessionScope.user.id eq ad.author.id}">
                                    <div class="panel-footer">
                                        <span class="adlist-item float-right">
                                            <form method="post" commandName="ad" role="form">
                                                <input type="submit" formaction="/ad/delete?id=${ad.id}" value="Eyða" class="btn btn-default"></input>
                                                <input type="submit" formaction="/ad/edit/${ad.id}" formmethod="get" value="Breyta" class="btn btn-default"></input>
                                            </form>
                                        </span>
                                    </div>
                                </c:when>
                            </c:choose>
                    </div>
                </c:forEach>
        </c:when>
    </c:choose>
</t:wrapper>