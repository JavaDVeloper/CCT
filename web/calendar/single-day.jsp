<%-- 
    Document   : single_day
    Created on : 24-Mar-2019, 03:24:39
    Author     : PiotrB. CCT - sb17018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GERBOX - single day</title>
    </head>
    <body>
        <h3>I am a single day!</h3>
        <table border="2" class="hour-row">
            <tr>
                <th colspan="3" style="text-align: center;">
                    <h2 id="day-name">${SINGLE_DAY.dayName} / ${SINGLE_DAY.dayInMonth} / ${SINGLE_DAY.currentMonth}</h2>
                </th>
            </tr>
            <tr> <!--the hour row-->
                <th>Check in</th><!--minutes rows-->
                <th>Check out</th><!--minutes rows-->
                <th>CHOOOSE</th>
            </tr> <!--the hour row-->
            
            <c:forEach var="freeHour" items="${FREE_HOURS}">
            <tr> <!--the hour row-->
                <td>
                    ${freeHour.getStartHour()}
                </td><!--minutes rows-->
                <td>
                    ${freeHour.getFinishHour()}
                </td><!--minutes rows-->
                <c:url var="tempLink" value="DriverControllerServlet">
                    <c:param name="command" value="BOOK_A_SPOT"/>
                    <c:param name="service-type" value="${CHOSEN_SERVICE_TYPE}"/>
                    <c:param name="free_spot_hour" value="${hour}"/>                    
                    <c:param name="free_spot_day" value="${SINGLE_DAY.dayInMonth}"/>                    
                    <c:param name="free_spot_month" value="${SINGLE_DAY.currentMonth}"/>                    
                    <c:param name="free_spot_year" value="${SINGLE_DAY.currentYear}"/>                    
                </c:url>
                <td><div style="text-align: center;"><input type="radio" name="booked-time-slot" value="${freeHour.getStart().getHour()}"/></div></td>
            </tr> <!--the hour row-->
            </c:forEach>
        </table>
    </body>
</html>
