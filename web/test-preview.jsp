<%-- 
    Document   : test-preview
    Created on : 16-Mar-2019, 06:37:57
    Author     : PiotrB. CCT - sb17018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Preview</title>
    </head>

    <body>

            <c:forEach var="tempElement" items="${LIST_OF_MAKES}">
                <option>${tempElement.name}</option>
            </c:forEach>

                <c:set var="dayParam" value="${SINGLE_DAY}"/>
                
                ${dayParam.getDayOfMonth()}

    </body>
</html>
