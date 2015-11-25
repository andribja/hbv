<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:head>
    <title>Greiðan</title>
</t:head>

<t:wrapper>
    <div class="jumbotron">
    	<h1>Greiðan</h1>
    	<c:choose>
			<c:when test="${empty sessionScope.user.username}">
	    		<p>Velkomin/n á Greiðuna!</p>
	    		<br />
	    	</c:when>
	    	<c:otherwise>
	    		<p>Velkomin/n ${sessionScope.user.username}!</p>
	    		<br />
	    	</c:otherwise>
    	</c:choose>
    	<p>
    		<c:choose>
	    		<c:when test="${empty sessionScope.user.username}">
	    			<a class="btn btn-default btn-lg" href="/login" role="button">Innskráning</a>
	    			<a class="btn btn-default btn-lg" href="/signup" role="button">Nýskráning</a>
	    			<br />
	    		</c:when>
	    		<c:otherwise>
	    			<a class="btn btn-default btn-lg" href="/new/ad" role="button">Skrá auglýsingu</a>
	    		</c:otherwise>
    		</c:choose>
    	</p>
    </div>
</t:wrapper>
