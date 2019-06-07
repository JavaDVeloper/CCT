<%-- 
    Document   : booking-confirmation
    Created on : 29-Apr-2019, 19:12:27
    Author     : PiotrB. CCT - sb17018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GERBOX - confirm your booking!</title>
    </head>
    <body>
        <%@include file="/basic/header.jsp" %>
        <div class="row"><!-- row 2 - for service type -->
            <div class="col-md-0 col-lg-1 col-xl-1">
            </div>
            <div class="col-md-12 col-lg-10 col-xl-10">
<!--                <c:url var="goBack" value="DriverControllerServlet">
                    <c:param name="availabilitycheckform" value="CONFIRM_BOOKING"/> 
                    <c:param name="customer-id" value="${CUSTOMER_ID}"/> 
                    <c:param name="service-year" value="${CHOSEN_TIME_SLOT.chosenYear}"/>
                    <c:param name="service-month" value="${CHOSEN_TIME_SLOT.chosenMonth}"/>
                    <c:param name="service-day" value="${CHOSEN_TIME_SLOT.chosenDay}"/>
                </c:url>
                    <a href="${goBack}"><p class="top-button">Back</p></a>-->
                    <div class="main-panel">
                        <br/>
                        <h3 class="welcome-name">Dear ${CUSTOMER_NAME}</h3>
                        <br/>
                        <div id="vehicle-option-frame" >
                            <form action="DriverControllerServlet" method="GET">
                                <input type="hidden" name="availabilitycheckform" value="CONFIRM_BOOKING"/> 
                                <input type="hidden" name="customer-id" value="${CUSTOMER_ID}"/> 
                                <input type="hidden" name="customer-name" value="${CUSTOMER_NAME}"/> 
                                <input type="hidden" name="free-slot-year" value="${CHOSEN_TIME_SLOT.chosenYear}"/>
                                <input type="hidden" name="free-slot-month" value="${CHOSEN_TIME_SLOT.chosenMonth}"/>
                                <input type="hidden" name="free-slot-day" value="${CHOSEN_TIME_SLOT.chosenDay}"/>
                                <br/>
                                <div class="thin-frame" >
                                    <label>Check details before booking</label>
                                    <br/>
                                    <div class="panels-in-dashboard">
                                        <label>Vehicle</label>
                                        <hr/>
                                        <div class="option-to-confirm">
                                            <input type="hidden" name="vehicle-id" class="display-only-input" value="${CHOSEN_VEHICLE_ID}"/>	
                                            <input type="hidden" name="vehicle-make" class="display-only-input" value="${CHOSEN_VEHICLE_MAKE}"/>	
                                            <input type="hidden" name="vehicle-model" class="display-only-input" value="${CHOSEN_VEHICLE_MODEL}"/>	
                                            <input type="text" class="display-only-input" value="${CHOSEN_VEHICLE_MAKE} ${CHOSEN_VEHICLE_MODEL}"/>	
                                        </div>
                                        <div class="option-to-confirm">
                                            <input type="text" name="vehicle-type" class="display-only-input"value="${CHOSEN_VEHICLE_TYPE}"/>	
                                        </div>
                                        <div style="clear:both;"></div>
                                        <div class="option-to-confirm">
                                            <input type="text" name="engine-type" class="display-only-input" value="${CHOSEN_ENGINE_TYPE}"/>	
                                        </div>
                                        <div class="option-to-confirm">
                                            <input type="text" name="vehicle-registration" class="display-only-input" value="${CHOSEN_VEHICLE_REGISTRATION}"/>
                                        </div>
                                        <div class="option-to-confirm">
                                            <input type="text" name="vehicle-color" class="display-only-input" value="${CHOSEN_VEHICLE_COLOR}"/>
                                        </div>
                                        <div style="clear:both;"></div>
                                    </div>
                                    <div class="panels-in-dashboard">

                                        <div id="vehicle-option-frame" >
                                            <label>Service</label>
                                            <hr/>
                                            <div class="option-to-confirm">
                                                <input type="text" name="free-slot-date" class="display-only-input" value="${CHOSEN_TIME_SLOT.chosenDate}"/>
                                            </div>
                                            <div class="option-to-confirm">
                                                <input type="hidden" name="free-slot-time-start" value="${CHOSEN_TIME_SLOT.chosenTimeSlotStart}"/>
                                                <input type="hidden" name="free-slot-time-finish"  value="${FINISH_HOUR}"/>
                                                <input type="text" class="display-only-input" value="${CHOSEN_TIME_SLOT.chosenTimeSlotStart} - ${FINISH_HOUR}"/>
                                            </div>
                                            <div class="option-to-confirm">
                                                <input type="text" name="service-type" class="display-only-input" value="${CHOSEN_SERVICE_TYPE}"/>
                                            </div>
                                            <div style="clear:both;"></div>
                                        </div>
                                    </div>
                                    <br/>
                                    <br/>
                                    <div style="clear:both;"></div>
                                    <div id="vehicle-option-frame" >
                                        <div class="service-short-description">
                                            <input type="textarea" name="service-description" class="input-text" placeholder="Short description what's happened"/>	
                                        </div>
                                        <div style="clear:both;"></div>
                                    </div>	
                                </div>
                                <br/>
                                <!-- <div id="submit-block" class="display-login-panel"> -->
                                <div id="login-submit-button">
                                    <input type="submit" class="login-submit input-frame" value="CONFIRM BOOKING" />
                                </div>
                            </form>
                            <br/>
                            <br/>
                        </div>

                    </div><!--main-->
                    <!-- </div> -->
                </div>
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div>
            </div> <!-- end row 4 -->
            <%@include file="/basic/bottom.html" %>
        </body>
    </html>
