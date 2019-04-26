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
        <title>GERBOX - Welcome in User's panel</title>

    </head>
    <body>
        <%@include file="/basic/header.jsp" %>
        <div class="container">
            <div class="row"> <!-- row 2 -->
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div>
                <div class="col-md-12 col-lg-10 col-xl-10 main-panel">
                    <div class="display-login-panel">
                        <p id="header-text">ENTER YOUR ACCOUNT</p>
                        <br/>
                        <p>${LOGIN_RESULT}</p>
                        <br/>
                        <form action="DriverControllerServlet" method="POST">
                            <input type="hidden" name="driverloggingform" value="LOGIN"/>
                            <div id="login-field">
                                <input type="text" name="login" id="driver-login" placeholder="USER NAME"/>
                            </div>
                            <br/>
                            <div>
                                <input type="password" name="pass" id="driver-pass" placeholder="PASSWORD"/>
                            </div>    
                            <br/>
                            <div id="submit-block"> 
                                <div id="login-submit-button">
                                    <input type="submit" id="login-submit" value="LOG IN"/>
                                    <div   id="submit-pointer">	
                                        <img src="img/pointer.png" width="30" height="30">
                                    </div>
                                </div>
                            </div>        
                        </form>
                        <p><a href="index.jsp">Back</a></p>
                    </div><!-- display panel-->    
                    <div style="clear: both"></div> 
                    <div class="button-gap"></div>
                </div>
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div>
            </div><!--row 2-->
        </div><!--container-->  
        <%@include file="/basic/bottom.html" %>  
    </body>
</html>
