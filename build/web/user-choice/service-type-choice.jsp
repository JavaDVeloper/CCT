<%-- 
    Document   : service-type-choice
    Created on : 07-Apr-2019, 07:44:26
    Author     : PiotrB. CCT - sb17018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GERBOX - service type choice</title>
    </head>
    <body>
        <div class="thin-frame">
            <label>Choose a type of the service</label>
            <br/>

                <c:set var="selectChosen" value="${CHOSEN_SERVICE_TYPE}"/> 
                <!--to check if option is chosen-->
                <c:if test="${selectChosen.equals(\"0\")}">
                    ${selectChosen=""}
                </c:if>    
                <form action="DriverControllerServlet" method="GET">    
                    <input type="hidden" name="availabilitycheckform" value="AVAILABILITY_CHECK"/>
                    <c:set var="customerName" value="${CUSTOMER_NAME}"/>
                    <input type="hidden" name="customer-name" value="${customerName}"/>
                    <c:set var="customerId" value="${CUSTOMER_ID}"/>
                    <input type="hidden" name="customer-id" value="${customerId}"/>
                    <div class="input-frame"> 
                        <select name="service-type" id="service-type" class="select-option">
                            <option value="0">
                                choose service
                            </option>
                            <c:forEach var="tempElement" items="${LIST_OF_SERVICE_TYPES}">
                                <c:set var="selection" value=""/>
                                <c:if test="${tempElement.name.equals(selectChosen)}">
                                    <c:set var="selection" value="selected"/>
                                </c:if>
                                <option value="${tempElement.name}" ${selection}>
                                    ${tempElement.name}
                                </option>
                            </c:forEach>                    
                        </select>
                    </div>
                    <br/>
                    <div>	
                        <div id="login-submit-button">              		
                            <input type="submit" class="login-submit input-frame" value="CHECK AVAILABILITY"/>
                        </div>
                    </div>	
                </form>
             <br/>
        </div>
    </body>
</html>
