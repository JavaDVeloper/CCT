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
        <input type="hidden" id="refreshed" value="no">
        <div class="container">
            <div class="row"> <!-- row 2 -->
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div>
                <div class="col-md-12 col-lg-10 col-xl-10">
                    <a href="signin-login.jsp"><p class="top-button">Back</p></a>
                    <div class="main-panel">  
                        <br/>
                        <p class="warning-top">${LOGIN_FAILURE}</p>
                        <div class="thin-frame">
                            <label>ENTER YOUR ACCOUNT</label>
                            <br/>
                            <div class="display-panel">
                                <form action="DriverControllerServlet" method="POST">
                                    <input type="hidden" name="driverloggingform" value="LOGIN"/>
                                    <p class="warning">${LOGIN_EMPTY}</p>
                                    <div class="input-frame">
                                        <div id="login-field">
                                            <input type="text" name="login" id="driver-login" class="input-text select-option" placeholder="USER NAME/EMAIL" value="${LOGIN_RETURNED}"/>
                                        </div>
                                    </div>
                                    <br/>

                                    <p class="warning">${PASSWORD_EMPTY}</p>
                                    <div class="input-frame">
                                        <div> 
                                            <input type="password" name="pass" id="driver-pass" class="input-text select-option" placeholder="PASSWORD" value="${PASSWORD_RETURNED}"/>
                                        </div>
                                    </div>    
                                    <br/>
                                    <div> 
                                        <div>
                                            <div class="submit-pointer">
                                            </div>
                                            <!--!!! those 3 only to fill fake fields when user's credentials are check but all fields needs to be filled up-->
                                            <!--xxxxxxxxxxxxxxxxxx--> 
                                            <input type="hidden" name="first-name" value="x"/>
                                            <input type="hidden" name="last-name" value="x"/>
                                            <input type="hidden" name="phone" value="x"/>
                                            <!--xxxxxxxxxxxxxxxxxx-->
                                            <input type="submit" class="input-frame login-submit" value="LOG IN"/>
                                        </div>
                                    </div>        
                                </form>
                            </div><!-- display panel--> 

                            <div style="clear: both"></div>
                            <br/>
                        </div>
                    </div>
                </div>
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div>
            </div><!--row 2-->
        </div><!--container-->  
        <%@include file="/basic/bottom.html" %>  
    </body>
</html>
