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
    <h2>Skrifa ummæli</h2>
    <p>Þú ert að skrifa ummæli fyrir notandann ${receiver.username}</p>
    <p>Vegna auglýsingarinnar ${ad.name}</p>

    <sf:form name="form" action="/review" method="post" commandName="review" role="form">
        <div class="form-group">
            <label for="comment">Ummæli:</label>
            <sf:input type="text" path="comment" id="comment" class="form-control"/>
        </div>

        <input type="hidden" name="receiver_id" value="${receiver.id}"/>
        <input type="hidden" name="ad_id" value="${ad.id}"/>

        <%--<sf:input type="hidden" path="sender" value=${sender}></sf:input>--%>
        <%--<sf:input type="hidden" path="receiver" value=${receiver}></sf:input>--%>
        <%--<sf:input type="hidden" path="relevantAd" value=${ad}></sf:input>--%>


        <input type="submit" value="Senda" class="btn btn-default"></input>
        Gefðu notanda einkunn <input type="number" name="rating" value="5" min="0" max="5"></input>
    </sf:form>
</t:wrapper>
