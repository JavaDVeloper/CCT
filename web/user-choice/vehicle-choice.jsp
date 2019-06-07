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

        <!--xxxxxxxxxxxxxxxx FIRST FIELD TO CHOOSE xxxxxxxxxxxxxxxx-->
        <c:set var="selectChosen" value="${CHOSEN_VEHICLE_MODEL}"/>
        <!--to check if option is chosen-->
        <c:if test="${selectChosen.equals(\"0\")}">
            ${selectChosen=""}
        </c:if>    
        <div>
            <label>Give details of the vehicle</label>
            <!-- <br/> -->
            <p class="warning">${VEHICLE_MODEL_EMPTY}</p>
            <div class="input-frame">
                <select name="vehicle-model" id="vehicle-model" class="select-option" >
                    <option>
                        choose model
                    </option>
                    <c:forEach var="tempElement" items="${LIST_OF_VEHICLE_MODELS}">
                        <c:set var="selection" value=""/>
                        <c:if test="${tempElement.name.equals(selectChosen)}">
                            <c:set var="selection" value="selected"/>
                        </c:if>
                        <option value="${tempElement.name}" ${selection}>${tempElement.name}</option>
                    </c:forEach>
                    <option value="other">
                        OTHER
                    </option>         
                </select>
            </div>
            <div class="input-frame hidden-text-frame other-model-to-put" id="other-model-to-put">
                <input type="text" class="input-text" name="other-model" placeholder="enter your model" value="" />	
            </div>

            <!--xxxxxxxxxxxxxxxx SECOND FIELD TO CHOOSE xxxxxxxxxxxxxxxx-->                        
            <c:set var="selectChosen" value="${CHOSEN_VEHICLE_MAKE}"/>

            <!--to check if option is chosen-->
            <c:if test="${selectChosen.equals(\"0\")}">
                ${selectChosen=""}
            </c:if>    

            <p class="warning">${VEHICLE_MAKE_EMPTY}</p>
            <div class="input-frame">             		
                <select name="vehicle-make" id="vehicle-make" class="select-option" >
                    <option>
                        choose make
                    </option>
                    <c:forEach var="tempElement" items="${LIST_OF_VEHICLE_MAKES}">
                        <c:set var="selection" value=""/>
                        <c:if test="${tempElement.name.equals(selectChosen)}">
                            <c:set var="selection" value="selected"/>
                        </c:if>
                        <option value="${tempElement.name}" ${selection}>${tempElement.name}</option>
                    </c:forEach>
                    <option value="other">
                        OTHER
                    </option>    
                </select>
            </div>
                <div class="input-frame hidden-text-frame other-make-to-put" id="other-make-to-put">
                    <input type="text" class="input-text other-make-to-put" name="other-make" placeholder="enter your make"/>
                </div>

            <!--xxxxxxxxxxxxxxxx THIRD FIELD TO CHOOSE xxxxxxxxxxxxxxxx-->                            
            <c:set var="selectChosen" value="${CHOSEN_VEHICLE_TYPE}"/>

            <!--to check if option is chosen-->
            <c:if test="${selectChosen.equals(\"0\")}">
                ${selectChosen=""}
            </c:if>    

            <p class="warning">${VEHICLE_TYPE_EMPTY}</p>
            <div class="input-frame">                		
                <select name="vehicle-type" id="vehicle-type" class="select-option" >
                    <option>
                        choose type
                    </option>
                    <c:forEach var="tempElement" items="${LIST_OF_VEHICLE_TYPES}">
                        <c:set var="selection" value=""/>
                        <c:if test="${tempElement.name.equals(selectChosen)}">
                            <c:set var="selection" value="selected"/>
                        </c:if>
                        <option value="${tempElement.name}" ${selection}>${tempElement.name}</option>
                    </c:forEach>                    
                </select>
            </div>                                        

            <!-- xxxxxxxxxxxxxxxx FORTH FIELD TO CHOOSE xxxxxxxxxxxxxxxx-->                            
            <c:set var="selectChosen" value="${CHOSEN_ENGINE_TYPE}"/>

            <!--to check if option is chosen-->
            <c:if test="${selectChosen.equals(\"0\")}">
                ${selectChosen=""}
            </c:if>    

            <p class="warning">${ENGINE_TYPE_EMPTY}</p>
            <div class="input-frame">                		
                <select name="engine-type" id="engine-type" class="select-option" >
                    //removed  value="${tempElement.name}"                            
                    <option>
                        choose engine
                    </option>
                    <c:forEach var="tempElement" items="${LIST_OF_ENGINE_TYPES}">
                        <c:set var="selection" value=""/>
                        <c:if test="${tempElement.name.equals(selectChosen)}">
                            <c:set var="selection" value="selected"/>
                        </c:if>
                        <option value="${tempElement.name}" ${selection}>${tempElement.name}</option>
                    </c:forEach>                    
                </select>        
            </div>
                    
            <!-- xxxxxxxxxxxxxxxx FIFTH FIELD TO PUT xxxxxxxxxxxxxxxx-->
            <p class="warning">${VEHICLE_REGISTRATION_EMPTY}</p>
            <div class="input-frame">
                <input type="text" name="vehicle-registration" id="vehicle-registration" class="input-text select-option" placeholder="Put registration in"/>                		       
            </div>
            
            <!-- xxxxxxxxxxxxxxxx SIXTH FIELD TO PUT xxxxxxxxxxxxxxxx-->
            <p class="warning">${VEHICLE_COLOR_EMPTY}</p>
            <div class="input-frame">
                <input type="text" name="vehicle-color" id="vehicle-color" class="input-text select-option" placeholder="Put color in"/>                		       
            </div>
        </div>
    </body>
</html>
