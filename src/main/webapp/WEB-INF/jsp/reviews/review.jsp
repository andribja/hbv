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
    <h2>SKrifa ummæli</h2>

    <sf:form name="form" action="/review?user_id=${receiver_id}&ad_id=${ad_id}" method="post" commandName="review" role="form">
        <div class="form-group">
            <label for="comment">Ummæli:</label>
            <sf:input type="text" path="comment" id="comment" class="form-control"/>
        </div>

        <%--<sf:input type="hidden" path="sender" value=${sender}></sf:input>--%>
        <%--<sf:input type="hidden" path="receiver" value=${receiver}></sf:input>--%>
        <%--<sf:input type="hidden" path="relevantAd" value=${ad}></sf:input>--%>


        <input type="submit" value="Senda" class="btn btn-default"></input>
    </sf:form>
</t:wrapper>
