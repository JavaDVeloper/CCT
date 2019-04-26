<%-- 
    Document   : employee_dashboard
    Created on : 18-Mar-2019, 13:05:23
    Author     : PiotrB. CCT - sb17018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GARBOX - Mechanic's dashboard</title>
        
        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    </head>
    <body>
        <h1>Employees login: SUCCESSFUL!</h1>
        <%@include file="/calendar/week-preview.jsp" %>
        <c:import url="/calendar/single_day.jsp" />
    </body>
</html>
