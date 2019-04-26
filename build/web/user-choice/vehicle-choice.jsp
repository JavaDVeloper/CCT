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
        <title>GERBOX - vehicle choice</title>
    </head>
    <body>
        <h3>Choose your vehicle:</h3>
        <table border="2" class="hour-row">
            <tr>
                <td>
                    <form action="DriverControllerServlet" method="GET">    
                        <input type="hidden" name="availabilitycheckform" value="AVAILABILITY_CHECK"/>

                        <!--xxxxxxxxxxxxxxxx FIRST FIELD TO CHOOSE xxxxxxxxxxxxxxxx-->
                        <c:set var="select_chosen" value="${CHOSEN_VEHICLE_MODEL}"/>

                        <!--to check if option is chosen-->
                        <c:if test="${select_chosen.equals(\"0\")}">
                            ${select_chosen=""}
                        </c:if>    

                        <p>${select_chosen}</p>

                        <select name="vehicle-model" id="vehicle-model" value="${tempElement.name}">
                            <option value="0">
                                Choose model
                            </option>

                            <c:forEach var="tempElement" items="${LIST_OF_VEHICLE_MODELS}">
                                <c:set var="selection" value=""/>
                                <c:if test="${tempElement.name.equals(select_chosen)}">
                                    <c:set var="selection" value="selected"/>
                                </c:if>
                                <option value="${tempElement.name}" ${selection}>${tempElement.name}</option>
                            </c:forEach>
                            <option value="other">
                                OTHER
                            </option>         
                        </select>
                        <input type="text" id="other-model-to-put" value="Enter your model"/>
                        <br/>

                        <!--xxxxxxxxxxxxxxxx SECOND FIELD TO CHOOSE xxxxxxxxxxxxxxxx-->                        
                        <c:set var="select_chosen" value="${CHOSEN_VEHICLE_MAKE}"/>

                        <!--to check if option is chosen-->
                        <c:if test="${select_chosen.equals(\"0\")}">
                            ${select_chosen=""}
                        </c:if>    

                        <p>${select_chosen}</p>

                        <select name="vehicle-make" id="vehicle-make">
      
                            <option value="0">
                                Choose make
                            </option>

                            <c:forEach var="tempElement" items="${LIST_OF_VEHICLE_MAKES}">
                                <c:set var="selection" value=""/>
                                <c:if test="${tempElement.name.equals(select_chosen)}">
                                    <c:set var="selection" value="selected"/>
                                </c:if>
                                <option value="${tempElement.name}" ${selection}>${tempElement.name}</option>
                            </c:forEach>
                            <option value="other">
                                OTHER
                            </option>    
                        </select>
                        <input type="text" id="other-make-to-put" value="Enter your make"/>
                        <br/>

                        <!--xxxxxxxxxxxxxxxx THIRD FIELD TO CHOOSE xxxxxxxxxxxxxxxx-->                            
                        <c:set var="select_chosen" value="${CHOSEN_VEHICLE_TYPE}"/>

                        <!--to check if option is chosen-->
                        <c:if test="${select_chosen.equals(\"0\")}">
                            ${select_chosen=""}
                        </c:if>    

                        <p>${select_chosen}</p>

                        <select name="vehicle-type" id="vehicle-type">
                            //removed  value="${tempElement.name}"
                            <option value="0">
                                Choose type
                            </option>

                            <c:forEach var="tempElement" items="${LIST_OF_VEHICLE_TYPES}">
                                <c:set var="selection" value=""/>
                                <c:if test="${tempElement.name.equals(select_chosen)}">
                                    <c:set var="selection" value="selected"/>
                                </c:if>
                                <option value="${tempElement.name}" ${selection}>${tempElement.name}</option>
                            </c:forEach>                    
                        </select>     

                        <!-- xxxxxxxxxxxxxxxx FORTH FIELD TO CHOOSE xxxxxxxxxxxxxxxx-->                            
                        <c:set var="select_chosen" value="${CHOSEN_ENGINE_TYPE}"/>

                        <!--to check if option is chosen-->
                        <c:if test="${select_chosen.equals(\"0\")}">
                            ${select_chosen=""}
                        </c:if>    

                        <p>${select_chosen}</p>

                        <select name="engine-type" id="engine-type">
                            //removed  value="${tempElement.name}"                            
                            <option value="0">
                                Choose engine
                            </option>

                            <c:forEach var="tempElement" items="${LIST_OF_ENGINE_TYPES}">
                                <c:set var="selection" value=""/>
                                <c:if test="${tempElement.name.equals(select_chosen)}">
                                    <c:set var="selection" value="selected"/>
                                </c:if>
                                <option value="${tempElement.name}" ${selection}>${tempElement.name}</option>
                            </c:forEach>                    
                        </select>
                        <br/>
                        <br/>
                        <!-- xxxxxxxxxxxxxxxx FIFTH FIELD TO CHOOSE /optional/ xxxxxxxxxxxxxxxx-->
                        <input type="text" id="vehicle-registration" value="REGISTRATION"/>
                        <br/>
                        <br/>
                        <input type="text" id="vehicle-color" value="COLOUR"/>
                        <br/>
                        <br/>
                        <input type="submit" value="CHECK AVAILABILITY"/></a>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
