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
        <div id="display-calendar-panel">
            <div id="roster-table-frame">
                <label>Choose car to book service</label>
                <br/>
                <div id="pending-services">
                    <table id="pending-services-table">
                        <tr class="top-header">
                            <th>Make</th>
                            <th>Model</th>
                            <th>Registration</th>
                            <th>Colour</th>
                            <th>Type</th>
                            <th>Engine</th>                          
                        </tr>
                        <c:forEach var="userVehicle" items="${userVehicleList}">    
                            <tr>
                                <td>${userVehicle.vehicleMakeName}</td>
                                <td>${userVehicle.vehicleModelName}</td>
                                <td>${userVehicle.registration}</td>
                                <td>${userVehicle.colour}</td>
                                <td>${userVehicle.vehicleTypeName}</td>
                                <td>${userVehicle.engineTypeName}</td>
                            <tr> 	
                            </c:forEach>      		
                    </table>
                </div>
                <br/>
            </div>
        </div>               
    </body>
</html>
