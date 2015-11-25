<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<t:head>
    <title>Skrifa umsögn</title>
</t:head>

<t:wrapper>
    <h2>Skilaboð</h2>
    <p>Senda skilaboð til ${receiver.username}</p>

    <sf:form name="form" action="/message" method="post" commandName="message" role="form">
        <div class="form-group">
            <label for="title">Efni</label>
            <sf:input type="text" path="title" id="title" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="content">Ummæli:</label>
            <sf:textarea type="text" path="content" id="content" rows="10" class="form-control"/>
        </div>

        <input type="hidden" name="receiver_id" value="${receiver.id}"/>

        <c:choose>
            <c:when test="${not empty ad}">
                <input type="hidden" name="ad_id" value="${ad.id}"/>
            </c:when>
        </c:choose>



        <input type="submit" value="Senda" class="btn btn-default"></input>
    </sf:form>
</t:wrapper>
