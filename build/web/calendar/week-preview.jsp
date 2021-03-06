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
            <label>Choose a day suits you</label>
            <br/>
            <div id="weekly-calendar">   
                <!--sets number of week ahead-->
                <c:set var="weeksAhead" value="${DAYS_AHEAD}"/>
                <c:url var="reverseLink" value="DriverControllerServlet">                       
                        <c:param name="availabilitycheckform" value="AVAILABILITY_CHECK"/>             
                        <c:param name="service-type" value="${CHOSEN_SERVICE_TYPE}"/>
                        <c:param name="customer-name" value="${CUSTOMER_NAME}"/>
                        <c:param name="customer-id" value="${CUSTOMER_ID}"/>
                        <c:param name="day-name" value="${SINGLE_DAY.dayName}"/>                    
                        <c:param name="day-of-month" value="${SINGLE_DAY.dayInMonth}"/>                    
                        <c:param name="current-month" value="${SINGLE_DAY.currentMonth}"/>                    
                        <c:param name="current-month-number" value="${SINGLE_DAY.currentMonthInNumber}"/>                    
                        <c:param name="current-year" value="${SINGLE_DAY.currentYear}"/> 
                        <c:param name="how-many-weeks-ahead" value="${weeksAhead}"/>                                
                        <c:param name="moving-week" value="back"/>                                    
                </c:url>

                <div class="day-of-week">
                    <a href="${reverseLink}">
                        <div class="day-inner" id="reverse-week"><</div>
                    </a>
                </div>
                <c:forEach var="tempDay" items="${WEEK_DAYS_TO_CHOOSE}">
                    <c:url var="tempLink" value="DriverControllerServlet">
                        <c:param name="availabilitycheckform" value="AVAILABILITY_CHECK"/>             
                        <c:param name="service-type" value="${CHOSEN_SERVICE_TYPE}"/>
                        <c:param name="customer-name" value="${CUSTOMER_NAME}"/>
                        <c:param name="customer-id" value="${CUSTOMER_ID}"/>
                        <c:param name="day-name" value="${tempDay.dayName}"/>                    
                        <c:param name="day-of-month" value="${tempDay.dayInMonth}"/>                    
                        <c:param name="current-month" value="${tempDay.currentMonth}"/>                    
                        <c:param name="current-month-number" value="${tempDay.currentMonthInNumber}"/>                    
                        <c:param name="current-year" value="${tempDay.currentYear}"/>
                        <c:param name="how-many-weeks-ahead" value="${weeksAhead}"/>
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
                    <c:if test="${SINGLE_DAY.dayInMonth==tempDay.dayInMonth and SINGLE_DAY.currentMonth==tempDay.currentMonth}">
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
                <c:url var="forwardLink" value="DriverControllerServlet">
                        <c:param name="availabilitycheckform" value="AVAILABILITY_CHECK"/>             
                        <c:param name="service-type" value="${CHOSEN_SERVICE_TYPE}"/>
                        <c:param name="customer-name" value="${CUSTOMER_NAME}"/>
                        <c:param name="customer-id" value="${CUSTOMER_ID}"/>
                        <c:param name="day-name" value="${SINGLE_DAY.dayName}"/>                    
                        <c:param name="day-of-month" value="${SINGLE_DAY.dayInMonth}"/>                    
                        <c:param name="current-month" value="${SINGLE_DAY.currentMonth}"/>                    
                        <c:param name="current-month-number" value="${SINGLE_DAY.currentMonthInNumber}"/>                    
                        <c:param name="current-year" value="${SINGLE_DAY.currentYear}"/> 
                        <c:param name="how-many-weeks-ahead" value="${weeksAhead}"/>
                        <c:param name="moving-week" value="forward"/>  
                </c:url>
                <div class="day-of-week">
                    <a href="${forwardLink}">
                        <div class="day-inner" id="forward-week">></div>
                    </a>
                </div>  
            </div>
            <br/>
            <br/>
        </div>
    </body>
</html>
