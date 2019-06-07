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
        <title>GERBOX - booking service</title>

        <link rel="stylesheet" type="text/css" href="./css/style.css" />
    </head>

    <body>
        <%@include file="/basic/header.jsp" %>

        <div class="row"><!-- row 2 - for service type -->

            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>
            <div class="col-md-12 col-lg-10 col-xl-10">
                <a href="index.jsp"><p class="top-button-right">Logout</p></a>
                <div class="main-panel">
                    <br/>

                    <h3 class="welcome-name">Dear ${CUSTOMER_NAME}</h3>
                    <br/>
                    <br/>
                    <c:set var="customerId" value="${CUSTOMER_ID}" />
                    <c:import url="/user-choice/service-type-choice.jsp" />

                </div>
            </div>
            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>

        </div> <!-- row 2 END - for service type -->



        <!-- row 3 - for service type -->
        <!-- to include form, weekly calendar, day's roster and vehicle options to driver's dashboard -->
        <c:set var="visibility" value="false" />
        <c:set var="visibility" value="${PAGE_INCLUSION}" />
        <c:if test="${visibility.equals(\"true\")}">
            <div class="row-3"><!-- row 3 - calendar -->
                <div>     
                    <!-- APPEARING WEEKLY CALENDAR -->
                    <%@include file="/calendar/week-preview.jsp" %>

                </div>	<!--container -->	
            </div>


            <!-- OPENING FORM -->
            <div class="row"><!-- row 4 - day -->
                <div class="options-panel">
                    <form action="DriverControllerServlet" method="GET">
                        <input type="hidden" name="availabilitycheckform" value="BOOK_A_SLOT" />
                        <input type="hidden" name="customer-id" value="${customerId}" />
                        <input type="hidden" name="customer-name" value="${CUSTOMER_NAME}" />
                        <input type="hidden" name="service-type" value="${CHOSEN_SERVICE_TYPE}" />
                        <!-- APPEARING DAILY ROSTER -->

                        <div class="thin-frame panels-in-dashboard">
                            <%@include file="/calendar/single-day.jsp" %>
                        </div>
                        <!-- APPEARING VEHICLE OPTIONS -->
                        <div class="thin-frame panels-in-dashboard">
                            <c:set var="userVehicleChoice" value="${LIST_OR_FORM}"/>
                            <c:if test="${userVehicleChoice.equals(\"form\")}">
                                <input type="hidden" name="entered-car" value="fromForm" />
                                <c:import url="/user-choice/vehicle-choice.jsp" />
                            </c:if>
                            <c:if test="${userVehicleChoice.equals(\"list\")}">
                                <input type="hidden" name="entered-car" value="fromList" />
                                <label>Choose car to book service</label>
                                <br/>

                                <p class="warning">${VEHICLE_ID_EMPTY}</p>
                                <!--<input type="hidden" name="vehicle-id" value="x" />-->
                                <div>
                                    <table>
                                        <tr class="top-header">
                                            <th>Make</th>
                                            <th>Model</th>
                                            <th>Registration</th>
                                            <th>Colour</th>
                                            <th>Type</th>
                                            <th>Engine</th>
                                            <th></th>
                                        </tr>
                                        <c:forEach var="userVehicle" items="${CUSTOMER_VEHICLES}">
                                            <tr>
                                                <td>${userVehicle.vehicleMakeName}</td>
                                                <td>${userVehicle.vehicleModelName}</td>
                                                <td>${userVehicle.registration}</td>
                                                <td>${userVehicle.colour}</td>
                                                <td>${userVehicle.vehicleTypeName}</td>
                                                <td>${userVehicle.engineTypeName}</td>
                                                <td><div><input type="radio" name="vehicle-id" class="radio-button" value="${userVehicle.id}" /></div></td>

                                            </tr>
                                        </c:forEach>
                                        <tr>
                                            <td colspan="7">
                                                <c:url var="toAddVeh" value="DriverControllerServlet">
                                                    <c:param name="availabilitycheckform" value="AVAILABILITY_CHECK"/>
                                                    <c:param name="customer-id" value="${customerId}" />
                                                    <c:param name="service-type" value="${CHOSEN_SERVICE_TYPE}" />
                                                    <c:param name="customer-name" value="${CUSTOMER_NAME}" />
                                                    <c:param name="adding-vehicles" value="addOther" />
                                                </c:url>
                                                <a href="${toAddVeh}">
                                                    <div class="info-submit">ADD VEHICLE
                                                    </div>
                                                </a>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </c:if>
                        </div>
                        <br />
                        <!-- <div id="submit-block" class="display-login-panel"> -->
                        <div>
                            <input type="submit" class="login-submit input-frame" value="BOOK SERVICE" />
                        </div>
                        <!-- </div> -->
                    </form>
                    <br/>
                    <br/>
                </div>
            </div> <!--end row 3-->
        </c:if>

        <div>
            <!-- row 4 -->
            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>
            <div class="col-md-12 col-lg-10 col-xl-10">
                <div style="clear: both"></div>
            </div>
            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>
        </div> <!-- end row 4 -->

        <!--container-->
        <%@include file="/basic/bottom.html" %>
        <c:set var="userNumber" value="${CUSTOMER_ID}"/>
        <c:if test="${userNumber eq null}">
            <c:redirect url="driver.jsp"/>
        </c:if>
    </body>
</html>