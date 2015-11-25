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
    <h2>Breyta auglýsingu</h2>

    <form name="form" action="/ad/edit/${ad.id}" method="post" role="form">
        <div class="form-group">
            <label for="name">Titill:</label>
            <input type="text" name="name" id="name" class="form-control" value="${ad.name}"/>
        </div>
        <div class="form-group">
            <label for="content"> Auglýsing</label>
            <textarea type="text" name="content" id="content" rows="10" class="form-control" >${ad.content}</textarea>
        </div>
        <div class="form-group">
            <input type="submit" value="Vista" class="btn btn-default"></input>

            Veldu kaupanda
            <select id="select-user" name="buyer">
                <option></option>
                <c:forEach var="user" items="${users}">
                    <c:choose>
                        <c:when test="${user.id ne sessionScope.user.id}">
                            <option value="${user.id}">${user.username}</option>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </form>
</t:wrapper>
