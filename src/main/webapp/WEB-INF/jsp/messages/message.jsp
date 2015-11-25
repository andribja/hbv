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
        <c:when test="${not empty message}">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">${message.title}</h3>
                    <a href="/user/${message.sender.id}" class="text-muted">${message.sender.username}</a>
                </div>
                <div class="panel-body">
                    <p>${message.content}</p>
                </div>
                <div class="panel-footer">
                        <a href="/message?user_id=${message.sender.id}&ad_id=${message.relevantAd.id}" class="btn btn-default">Svara</a>
                        <button class="btn btn-default">Eyða</button>

                    <%--<c:choose>--%>
                        <%--<c:when test="${not empty sessionScope.user}">--%>
                            <%--<a href="/message?user_id=${ad.author.id}&ad_id=${ad.id}">Hefurðu áhuga? Sendu ${ad.author.username} skilaboð</a>--%>
                        <%--</c:when>--%>
                        <%--<c:otherwise>--%>
                            <%--<a href="/login?redirect=true">Hefurðu áhuga? Skráðu þig inn til að senda ${ad.author.username} skilaboð</a>--%>
                        <%--</c:otherwise>--%>
                    <%--</c:choose>--%>
                </div>
            </div>
        </c:when>
    </c:choose>
</t:wrapper>
