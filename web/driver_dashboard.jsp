<%-- 
    Document   : driver
    Created on : 16-Mar-2019, 01:07:31
    Author     : PiotrB. CCT - sb17018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerbox - booking service</title>
        
        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    </head>
    <body>
        <%@include file="/basic/header.jsp" %>
        <h3>Driver login: SUCCESSFUL!</h1>

        <br/>
        <c:import url="/user-choice/service-type-choice.jsp" />
        <br/>
        <c:set var="visibility" value="false"/>
        <c:set var="visibility" value="${PAGE_INCLUSION}"/>
        <c:if test="${visibility.equals(\"true\")}">
            <%@include file="/calendar/week-preview.jsp" %>
            <br/>
            <div>
                <div  class="roster-vehicle-options"><%@include file="/calendar/single-day.jsp" %></div>
                <div  class="roster-vehicle-options"></div>
                <div  class="roster-vehicle-options"><%@include file="/user-choice/vehicle-choice.jsp" %></div>
            </div>
            
            <br/>
        </c:if>
        <h4><a href="index.jsp">Back</a></h4>
        <%@include file="/basic/bottom.html" %>          
    </body>
</html>
