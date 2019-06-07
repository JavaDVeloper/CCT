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
        <%@include file="/basic/header.jsp" %>
        <div class="row"><!-- row 2 - for service type -->
            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>
            <div class="col-md-12 col-lg-10 col-xl-10">
                <div class="main-panel main-menu-mechanic">
                    <div>
                        <a href="#" class="main-menu-button this-page"><div class="mechanic-menu">Pending</div></a>
                        <a href="mechanic-dashboard-completed.jsp" class="main-menu-button"><div class="mechanic-menu">Completed</div></a>
                        <a href="mechanic-dashboard-collected.jsp" class="main-menu-button"><div class="mechanic-menu">Collected</div></a>  
                    </div>
                </div>
            </div>
            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>
        </div>
        <c:import url="/calendar/mechanic-week-preview.jsp" />
        <div class="row"><!-- row 2 - for service type -->
            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>
            <div class="col-md-12 col-lg-10 col-xl-10">
                <div class="options-panel">
                    <div class="thin-frame">
                        <c:import url="/calendar/mechanic-single-day.jsp" />
                    </div>
                </div>
            </div>
            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>

            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>
        </div><!--row-->
    </body>
</html>
