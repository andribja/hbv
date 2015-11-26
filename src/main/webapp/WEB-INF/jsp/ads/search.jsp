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

    <form name="form" action="/ads/search" method="post" role="form">
        <div class="form-group">
            <label for="query">Leit</label>
            <input type="text" name="query" id="query" class="form-control"/>
        </div>
        <div class="form-group">
            <input type="submit" value="Leita" class="btn btn-default"/>
        </div>
    </form>
</t:wrapper>