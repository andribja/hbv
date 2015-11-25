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
    <c:choose>
        <c:when test="${not empty ads}">
            <c:forEach var="ad" items="${ads}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a href="/ads/${ad.id}">
                            <h3 class="panel-title">${ad.name}</h3>
                            <a href="/user/${ad.author.id}" class="text-muted">${ad.author.username}</a>
                        </a>    
                    </div>
                    <div class="panel-body">
                        <p id="timestamp" class="text-muted">${ad.creationTimestamp}</p>
                        <p>${ad.content}</p>
                    </div>
                    <!-- <span class="adlist-item float-right">
                        <form action="/ad/delete?id=${ad.id}" method="post" commandName="ad" role="form">
                        <input type="submit" value="Eyða" class="btn btn-default"></input>
                        </form>
                    </span> -->
                </div>
            </c:forEach>
        </c:when>
    </c:choose>
</t:wrapper>