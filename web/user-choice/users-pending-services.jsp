<%-- 
    Document   : users-pending-services
    Created on : 02-May-2019, 23:33:55
    Author     : PiotrB. CCT - sb17018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GERBOX - pending service</title>
    </head>
    <body>            
        <div>
            <div class="thin-frame">
                <c:set var="firstTimeUser" value="${CUSTOMER_SERVICE_TABLE_LABEL}"/>
                <label>Your ${firstTimeUser} service</label>
                <br/>
                <div id="pending-services">
                    <table id="pending-services-table">
                        <tr class="top-header">
                            <th>Make</th>
                            <th>Model</th>
                            <th>Registration</th>
                            <th>Service type </th>
                            <th>In</th>
                            <th>Out</th>
                            <th>Status</th>                            
                        </tr>
                        <c:forEach var="pendingService" items="${CUSTOMER_SERVICES}">    
                            <tr>
                                <td>${pendingService.vehicleMake}</td>
                                <td>${pendingService.vehicleModel}</td>
                                <td>${pendingService.vehicleRegistration}</td>
                                <td>${pendingService.serviceType}</td>
                                <td>${pendingService.serviceStart}</td>
                                <td>${pendingService.serviceFinish}</td>
                                <td>${pendingService.serviceStatus}</td>
                            </tr> 	
                        </c:forEach>      		
                    </table>
                </div>
                <br/>
            </div>
        </div>               
    </body>
</html>
