<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>GERBOX - Welcome!</title>
    </head>
    <body>
        <%@include file="/basic/header.jsp" %>
        <c:set var="fromServlet" value="${REDIRECTED_FROM_SERVLET}"/>
        <c:set var="userNumber" value="${CUSTOMER_ID}"/>
        <c:choose>
            <c:when test="${(userNumber == 0) or (fromServlet eq \"from_servlet\") }">
                <c:redirect url="index.jsp"/>
            </c:when>
            <%--<c:otherwise>--%>
                <%--<c:if test="${userNumber eq null}">--%>
                    <%--<c:redirect url="driver.jsp"/>--%>
                <%--</c:if>--%>
            <%--</c:otherwise>--%>
        </c:choose>
        <div class="container">
            <div class="row"> <!-- row 2 -->
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div>   
                <div class="col-md-12 col-lg-10 col-xl-10">
                    <div class="main-panel">  
                        <br>
                        <ul class="logo-bulletpoint">
                            <li><p class="text-content">We provide all types of servicing from basic to major.</p></li>
                        </ul>


                        <br/>         
                        <div class="thin-frame">
                            <label>YOUR ARE</label>
                            <br/>
                            <div class="display-panel">
                                <div class="display">
                                    <c:url var="mechanicDashboard" value="MechanicControllerServlet">
                                        <c:param name="availabilitycheckform" value="DISPLAY_SERVICES"/>
                                    </c:url>
                                    <a href="${mechanicDashboard}">
                                        <div id="display-picture-mechanic">
                                        </div>
                                    </a>		               		
                                    <div class="display-description-mechanic">
                                        Mechanic         
                                    </div>
                                </div>

                                <div class="display">
                                    <a href="signin-login.jsp">
                                        <div id="display-picture-driver">                      
                                        </div>
                                    </a>    
                                    <div class="display-description-driver">
                                        Driver
                                    </div>
                                </div>
                            </div><!--display panel-->
                        </div><!--service-type-frame-->		
                        <div style="clear: both"></div> 
                        <br/>
                    </div><!--main panel-->
                    <br/>
                    <ul class="logo-bulletpoint">
                        <li><p class="text-content">All servicing is carried out adhering to the manufacturers specification sheet for a vehicle’s make and model.</p></li>
                        <li><p class="text-content">A full vehicle inspection is performed and we will bring any additional defects to your attention upon which the best course of action can be agreed.</p></li>
                    </ul>
                    <br/>
                </div>  
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div> 
            </div> <!-- end row 2 -->
        </div> <!--container-->
        <%@include file="/basic/bottom.html" %>
    </body>
</html>