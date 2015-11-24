<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Login</title>
</t:head>

<t:wrapper>
     <form name="form" action="/login" method="post" role="form">
        <div class="form-group">
            <label for="username">Notandanafn:</label>
            <input type="text" name="username" id="username" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="password">Lykilorð:</label>
            <input type="password" name="password" id="password" class="form-control"/>
        </div>

         <div class="checkbox">
             <label>
                 <input type="checkbox" name="remember-me" id="remember-me">
                 Muna innskráningu
             </label>
         </div>


        <input type="submit" value="Senda" class="btn btn-default"></input>
    <form>
</t:wrapper>