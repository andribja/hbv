<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<t:head>
    <title>asdf</title>
</t:head>

<t:wrapper>
    <h2>Ný auglýsing</h2>

    <sf:form name="form" action="/new/ad" method="post" commandName="ad" role="form">
        <div class="form-group">
            <label for="name">Titill:</label>
            <sf:input type="text" path="name" id="name" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="content"> Auglýsing</label>
            <sf:textarea type="text" path="content" id="content" rows="10" class="form-control"/>
        </div>

        <input type="submit" value="Senda" class="btn btn-default"></input>
    </sf:form>
</t:wrapper>
