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
                <th colspan="6" style="text-align: center;">
                    <h2 id="day-name">${SINGLE_DAY.dayName} / ${SINGLE_DAY.dayInMonth} / ${SINGLE_DAY.currentMonth}</h2>
                </th>
            </tr>
            
            <c:forEach var="hour" begin="9" end="16" step="1">
            <tr> <!--the hour row-->
 
                <c:if test="${hour<10}">
                    <c:set var="hour" value="0${hour}"/> 
                </c:if>
                    <c:set var="rowclass" value="inner-table"/> 
                <c:if test="${hour%2==0}">
                    <c:set var="rowclass" value="inner-table2"/> 
                </c:if>
                <td>${hour}
                </td>
                <td colspan="3"><!--minutes rows-->
                    <table class="${rowclass}">
                        <%--<c:forEach var="mins" begin="0" end="30" step="30">--%>
                            <%--<c:if test="${mins<10}">--%>
                                <%--<c:set var="mins" value="0${mins}"/>--%> 
                            <%--</c:if>--%>
                         <tr>                                        
                            <!--<td>${mins}</td>-->
                            <td>blelele</td>
                            <td>blelele</td>
                            <td>blelele</td>
                        </tr>
                        <%--</c:forEach>--%>
                    </table>
                </td><!--minutes rows-->
                <c:url var="tempLink" value="DriverControllerServlet">
                    <c:param name="command" value="BOOK_A_SPOT"/>
                    <c:param name="service-type" value="${CHOSEN_SERVICE_TYPE}"/>
                    <c:param name="free_spot_hour" value="${hour}"/>                    
                    <c:param name="free_spot_day" value="${SINGLE_DAY.dayInMonth}"/>                    
                    <c:param name="free_spot_month" value="${SINGLE_DAY.currentMonth}"/>                    
                    <c:param name="free_spot_year" value="${SINGLE_DAY.currentYear}"/>                    
                </c:url>
                <td><a href="${tempLink}"><div>CHOOSE</div></a></td>
            </tr> <!--the hour row-->
            </c:forEach>
        </table>
    </body>
</html>
