<%-- 
    Document   : mechanic
    Created on : 16-Mar-2019, 01:07:31
    Author     : PiotrB. CCT - sb17018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>garbox - Mechanic</title>
    </head>
    <body>
        <br/>
        <p>${LOGIN_FAIL}</p>
        <br/>
        <form action="MechanicLogginControllerServlet" method="POST">
            
            <input type="hidden" name="mechanicloggingform" value="LOGIN"/>
            
            login:<br/><input type="text" name="login"/><br/><br/>
            password:<br/><input type="password" name="pass"/>
            <br/><br/>
            <input type="submit" value="LOG IN"/>
            
        </form>
        <h1><a href="index.jsp">Back</a></h1>
    </body>
</html>
