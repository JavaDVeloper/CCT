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

        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    </head>
    <body>

        <%@include file="/basic/header.jsp" %>

        <div class="container">

            <div class="row"> <!-- row 2 -->
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div>   
                <div class="col-md-12 col-lg-10 col-xl-10">
                    <c:url var="logOut" value="DriverControllerServlet">
                        <c:param name="availabilitycheckform" value="LOGOUT"/>
                    </c:url>
                    <a href="${logOut}" id="log-out"><p class="top-button-right">Logout</p></a>
                    <div class="main-panel">
                        <br/>
                        <h3>Welcome, ${CUSTOMER_NAME}</h3>
                        <c:set var="firstTimeUser" value="${CUSTOMER_SERVICE_TABLE_LABEL}"/>
                        <c:if test="${not firstTimeUser.equals(\"empty\")}">
                            <c:import url="/user-choice/users-pending-services.jsp" />
                        </c:if>
                        <br/>
                        <c:url var="linkToDashboard" value="DriverControllerServlet">
                            <c:param name="availabilitycheckform" value="START_BOOKING"/>            
                            <c:param name="customer-name" value="${CUSTOMER_NAME}"/>
                            <c:param name="customer-id" value="${CUSTOMER_ID}"/>
                            <c:param name="service-type" value="0"/>
                        </c:url>

                        <div id="login-submit-button">              		
                            <a href="${linkToDashboard}"><div class="info-submit book-click">BOOK SERVICE</div></a>        
                        </div>
                    </div>
                </div>   
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div> 
            </div> <!-- end row 2 -->
        </div><!--container-->
        <c:set var="userNumber" value="${CUSTOMER_ID}"/>
        <c:choose>
            <c:when test="${userNumber eq null}">
                <c:redirect url="driver.jsp"/>
            </c:when>

        </c:choose>
        <%@include file="/basic/bottom.html" %>          
    </body>
</html>
