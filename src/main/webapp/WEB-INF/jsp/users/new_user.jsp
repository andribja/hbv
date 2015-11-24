<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<t:head>
    <title>Nýr notandi</title>
</t:head>

<t:wrapper>
    <h2>Nýr notandi</h2>

    <sf:form name="form" action="/signup" method="post" commandName="user" role="form">
        <div class="form-group">
            <label for="email">Netfang:</label>
            <sf:input type="text" path="email" id="email" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="username">Notandanafn:</label>
            <sf:input type="text" path="username" id="username" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="password">Lykilorð:</label>
            <input type="password" name="password" id="password" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="confirm">Staðfesta lykilorð:</label>
            <input type="password" name="confirm" id="confirm" class="form-control"/>
        </div>

        <input type="submit" value="Senda" class="btn btn-default"></input>
    </sf:form>
</t:wrapper>
