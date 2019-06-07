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
        <div id="roster-table-frame">
            <label>Choose time suits you</label>
            <p class="warning">${FREE_SLOT_TIME_START_EMPTY}</p>            
       
            <div id="roster-table">
                <table id="timetable">
                    <tr>
                        <th colspan="3" class="top-header">
                            <input type="text" id="free-slot-date" name="free-slot-date" value="${SINGLE_DAY.dayName} / ${SINGLE_DAY.dayInMonth} / ${SINGLE_DAY.currentMonth}"/>
                            <input type="hidden" name="free-slot-day" value="${SINGLE_DAY.dayInMonth}"/>                    
                            <input type="hidden" name="free-slot-month" value="${SINGLE_DAY.currentMonthInNumber}"/>                    
                            <input type="hidden" name="free-slot-year" value="${SINGLE_DAY.currentYear}"/>
                            <input type="hidden" name="service-time" value="${SERVICE_TIME}"/>
                        </th>
                        </th>
                    </tr>
                    <tr> <!--the hour row-->
                        <th>In</th>
                        <th>Out</th>
                        <th>CHOOSE</th>
                    </tr> <!--the hour row-->

                    <c:forEach var="freeHour" items="${FREE_HOURS}">
                        <tr> <!--the hour row-->
                            <td>
                                ${freeHour.getStartHour()}
                            </td><!--minutes rows-->
                            <td>
                                ${freeHour.getFinishHour()}
                            </td><!--minutes rows-->
                            <td>
                                <div style="text-align: center;">
                                    <input type="radio" name="free-slot-time-start" class="radio-button" value="${freeHour.getStartHour()}"/>
                                </div>
                            </td>
                        </tr> <!--the hour row-->
                    </c:forEach>
                </table>
            </div>
            <br/>
        </div>
    </body>
</html>
