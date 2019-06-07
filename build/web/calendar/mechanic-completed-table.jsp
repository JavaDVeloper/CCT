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
            <label>Schedule</label>
            <br/>
            <div id="roster-table">
                <table id="timetable">
                    <tr>
                        <th colspan="12" class="top-header">
                            <input type="text" id="free-slot-date" readonly name="free-slot-date" value="${SINGLE_DAY.dayName} / ${SINGLE_DAY.dayInMonth} / ${SINGLE_DAY.currentMonth}"/>
                        </th>
                    </tr>
                    <tr> <!--the hour row-->
                        <th>Id</th>
                        <th>In</th>
                        <th>Out</th>
                        <th>Service type</th>
                        <th>Employee</th>
                        <th>Vehicle</th>
                        <th>Type</th>
                        <th>Engine</th>
                        <th>Registration</th>
                        <th>Colour</th>
                        <th colspan="2">Status</th>
                    </tr> <!--the hour row-->
                    
                    <c:forEach var="servicesOnDay" items="${SERVICES_ON_DAY}">
                        <form action="MechanicControllerServlet" method="GET">
                            <input type="hidden" name="availabilitycheckform" value="PENDING_STATUS_CHANGE" />
                            <tr> <!--the hour row-->
                                <td>
                                    <input type="hidden" name="service-on-day-value"  value="${servicesOnDay.serviceId}"/>
                                    ${servicesOnDay.serviceId}
                                  
                                </td>
                                <td>
                                    <!--<input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.serviceStart.substring(11,16)}"/>-->
                                    <input type="hidden" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.serviceStart.substring(11,16)}"/>
                                    ${servicesOnDay.serviceStart.substring(11,16)}
                                </td>
                                <td>
                                    <!--<input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.serviceFinish.substring(11,16)}"/>-->
                                    <input type="hidden" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.serviceFinish.substring(11,16)}"/>
                                    ${servicesOnDay.serviceFinish.substring(11,16)}
                                </td>
                                <td>
                                    <!--<input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.serviceType}"/>-->
                                    <input type="hidden" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.serviceType}"/>
                                    ${servicesOnDay.serviceType}
                                </td>
                                <td>
                                    <!--<input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.mechanicFirstName} ${servicesOnDay.mechanicLastName}"/>-->
                                    <input type="hidden" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.mechanicFirstName} ${servicesOnDay.mechanicLastName}"/>
                                    ${servicesOnDay.mechanicFirstName} ${servicesOnDay.mechanicLastName}
                                </td>
                                <td>
                                    <!--<input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.vehicleMake} ${servicesOnDay.vehicleModel}"/>-->
                                    <input type="hidden" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.vehicleMake} ${servicesOnDay.vehicleModel}"/>
                                    ${servicesOnDay.vehicleMake} ${servicesOnDay.vehicleModel}
                                </td>
                                <td>
                                    <!--<input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.vehicleType}"/>-->
                                    <input type="hidden" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.vehicleType}"/>
                                    ${servicesOnDay.vehicleType}
                                </td>
                                <td>
                                    <!--<input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.engineType}"/>-->
                                    <input type="hidden" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.engineType}"/>${servicesOnDay.engineType}
                                </td>
                                <td>
                                    <!--<input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.registration}"/>-->
                                    <input type="hidden" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.registration}"/>
                                    ${servicesOnDay.registration}
                                </td>
                                <td>
                                    <!--<input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.vehicleColor}"/>-->
                                    <input type="hidden" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.vehicleColor}"/>
                                    ${servicesOnDay.vehicleColor}
                                </td>
                                <td>
    <!--                                <input type="text" readonly name="service-on-day-value" class="display-only-input" value="${servicesOnDay.serviceStatus}"/>-->
                                    <!--<input type="hidden" name="service-on-day-value" class="display-only-input" value="${servicesOnDay.serviceStatus}"/>-->
                                    <select name="service-on-day-value" id="service-status" class="select-option">
                                        <c:set var="status">${servicesOnDay.serviceStatus}</c:set>
                                        <option value="${servicesOnDay.serviceStatus}">
                                            <c:out value="${servicesOnDay.serviceStatus}"/>
                                        </option>
                                        <c:forEach  var="tempElems" items="${LIST_OF_SERVICE_STATUSES}">                                     
                                            <c:set var="te">${tempElems.name}</c:set>
                                            <c:if test="${not (te == status)}">
                                                <option value="${te}">
                                                    <c:out value="${te}"/>
                                                </option>
                                            </c:if>    
                                        </c:forEach>     
                                    </select>
                                </td>
                                <td>

                                    <div id="login-submit-button">
                                        <input type="submit" class="login-submit" value="bill" />
                                    </div>

                                </td>
                            </tr> <!--the hour row-->
                        </form>
                    </c:forEach>
                </table>
            </div>
            <div>
                <form action="MechanicControllerServlet" method="GET">
                    <c:set var="count" value="${0}"/>
                    <input type="hidden" name="availabilitycheckform" value="PRINT_DAILY_ROSTER"/>
                    <input type="hidden" name="free-slot-date" value="${SINGLE_DAY.dayName} / ${SINGLE_DAY.dayInMonth} / ${SINGLE_DAY.currentMonth}"/>

                    <c:forEach var="serviceOnDay" items="${SERVICES_ON_DAY}">
                        <c:set var="theService" value="${count + 1}"/>
                        <c:set var="following" value="${theService}"/>

                        <input type="hidden" name="${following}" value=${serviceOnDay.serviceId}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.serviceStart.substring(11,16)}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.serviceFinish.substring(11,16)}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.serviceType}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.mechanicFirstName}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.mechanicLastName}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.vehicleMake}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.vehicleModel}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.vehicleType}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.engineType}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.registration}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.vehicleColor}>
                        <input type="hidden" name="${following}" value=${serviceOnDay.vehicleColor}>

                        <c:set var="count" value="${theService}"/>
                    </c:forEach>

                    <input type="hidden" name="number-services" value="${count}"/>
                    <div id="login-submit-button">
                        <input type="submit" class="login-submit input-frame" value="PRINT" />
                    </div>

                </form>
                <br/>
            </div>
        </div>
    </body>
</html>
