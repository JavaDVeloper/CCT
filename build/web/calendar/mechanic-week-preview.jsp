<%-- 
    Document   : week-preview
    Created on : 21-Mar-2019, 06:34:32
    Author     : PiotrB. CCT - sb17018
--%>

<%--<%@page import="barpiotr.Days.Day"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GERBOX - Choose a day!</title>

    </head>

    <body>
        <div class="thin-frame calendar-frame">
            <label>Check roster</label>
            <div id="weekly-display">
                <!--sets number of week ahead-->
                <c:set var="weeksBack" value="${DAYS_AHEAD}"/>
                <c:url var="reverseLink" value="MechanicControllerServlet">
                    <c:param name="availabilitycheckform" value="DISPLAY_SERVICES"/>                         
                    <c:param name="service-type" value="${CHOSEN_SERVICE_TYPE}"/>
                    <c:param name="customer-name" value="${CUSTOMER_NAME}"/>
                    <c:param name="customer-id" value="${CUSTOMER_ID}"/>  
                    <c:param name="vehicle-model" value="${CHOSEN_VEHICLE_MODEL}"/>
                    <c:param name="vehicle-make" value="${CHOSEN_VEHICLE_MAKE}"/>
                    <c:param name="how-many-weeks-ahead" value="${weeksBack}"/> 
                    <c:param name="service-status" value="${serviceStat}"/>
                    <c:param name="clicked-reverse" value="yes"/>                                    
                </c:url>

                <div class="day-of-week">
                    <a href="${reverseLink}">
                        <div class="day-inner" id="reverse-week"><</div>
                    </a>
                </div>

                <c:forEach var="tempDay" items="${WEEK_DAYS_TO_CHOOSE}">
                    <c:url var="tempLink" value="MechanicControllerServlet">
                        <c:param name="availabilitycheckform" value="DISPLAY_SERVICES_ON_DAY"/>             
                        <c:param name="service-type" value="${CHOSEN_SERVICE_TYPE}"/>
                        <c:param name="customer-name" value="${CUSTOMER_NAME}"/>
                        <c:param name="customer-id" value="${CUSTOMER_ID}"/>
                        <c:param name="vehicle-model" value="${CHOSEN_VEHICLE_MODEL}"/>
                        <c:param name="vehicle-make" value="${CHOSEN_VEHICLE_MAKE}"/>
                        <c:param name="day_name" value="${tempDay.dayName}"/>                    
                        <c:param name="day_of_month" value="${tempDay.dayInMonth}"/>                    
                        <c:param name="current_month" value="${tempDay.currentMonth}"/>                    
                        <c:param name="current_month_number" value="${tempDay.currentMonthInNumber}"/>                    
                        <c:param name="current_year" value="${tempDay.currentYear}"/>                    
                    </c:url>
                    <c:choose>
                        <c:when test="${tempDay.dayName.equals(\"Sat\")}">
                            <c:set var="weekDayClass" value="${\"day-of-weekend\"}"/>
                        </c:when>
                        <c:when test="${tempDay.dayName.equals(\"Sun\")}">
                            <c:set var="weekDayClass" value="${\"day-of-weekend\"}"/>
                        </c:when>                    
                        <c:otherwise>
                            <c:set var="weekDayClass" value="${\"day-of-week\"}"/>
                        </c:otherwise>
                    </c:choose>

                    <!--checks clicked day in week-->
                    <c:if test="${SINGLE_DAY.dayInMonth==tempDay.dayInMonth}">
                        <c:set var="weekDayClass" value="${\"day-chosen\"}"/>
                    </c:if>    

                    <div class="${weekDayClass}">
                        <c:if test="${!tempDay.dayName.equals(\"Sun\")}">      
                            <a href="${tempLink}">
                            </c:if>           
                            <div class="day-inner">
                                ${tempDay.dayName} <br/>
                                ${tempDay.dayInMonth} <br/>
                                ${tempDay.currentMonth}
                            </div>         
                            <c:if test="${!tempDay.dayName.equals(\"Sun\")}">      
                            </a>
                        </c:if>   
                    </div>
                </c:forEach>

                <!--sets number of week ahead -->
                <c:set var="weeksAhead" value="${DAYS_AHEAD}"/>
                <c:url var="forwardLink" value="MechanicControllerServlet">
                    <c:param name="availabilitycheckform" value="DISPLAY_SERVICES"/>
                    <c:param name="service-type" value="${CHOSEN_SERVICE_TYPE}"/>
                    <c:param name="customer-name" value="${CUSTOMER_NAME}"/>
                    <c:param name="customer-id" value="${CUSTOMER_ID}"/>  
                    <c:param name="vehicle-model" value="${CHOSEN_VEHICLE_MODEL}"/>
                    <c:param name="vehicle-make" value="${CHOSEN_VEHICLE_MAKE}"/>
                    <c:param name="how-many-weeks-ahead" value="${weeksAhead}"/>                                    
                </c:url>

                <div class="day-of-week">
                    <a href="${forwardLink}">
                        <div class="day-inner" id="forward-week">></div>
                    </a>
                </div>  
            </div>
        </div>
    </body>
</html>
