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
    <h2>Skilaboð send</h2>
    <p>Þú sendir skilaboð til ${receiver.username}</p>
</t:wrapper>
