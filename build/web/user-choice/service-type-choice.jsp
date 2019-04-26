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
        Choose service type:
        <form action="DriverControllerServlet" method="GET">    
            <input type="hidden" name="availabilitycheckform" value="AVAILABILITY_CHECK"/>

                <c:set var="select_chosen" value="${CHOSEN_SERVICE_TYPE}"/>
                
                <!--to check if option is chosen-->
                <c:if test="${select_chosen.equals(\"0\")}">
                    ${select_chosen=""}
                </c:if>    
                
                <p>${select_chosen}</p>
  
                <select name="service-type" id="service-type">
                    //removed  value="${tempElement.name}"
                    <option value="0">
                        Choose service
                    </option>
 
                <c:forEach var="tempElement" items="${LIST_OF_SERVICE_TYPES}">
                    <c:set var="selection" value=""/>
                    <c:if test="${tempElement.name.equals(select_chosen)}">
                        <c:set var="selection" value="selected"/>
                    </c:if>
                    <option value="${tempElement.name}" ${selection}>${tempElement.name}</option>
                </c:forEach>                    
                </select>   
                <br/><br/>
            <input type="submit" value="CHECK AVAILABILITY"/></a>
        </form>
    </body>
</html>
