<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Leit</title>
</t:head>

<t:wrapper>
    <h2>Leita að auglýsingum</h2>

    <p>Leit:</p>

    <form name="form" action="/ads/search" method="post" role="form">
        <div class="form-group">
            <label for="username">Notandanafn:</label>
            <input type="text" name="username" id="username" class="form-control"/>
        </div>
    </form>
</t:wrapper>