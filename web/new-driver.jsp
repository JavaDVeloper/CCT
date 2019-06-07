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
                <div class="col-md-12 col-lg-10 col-xl-10">

                    <div class="main-panel">  
                        <br/>
                        <p class="warning">${LOGIN_RESULT}</p>
                        <br/>         
                        <div  class="thin-frame">
                            <label>SET YOUR ACCOUNT</label>
                            <br/>
                            <div class="display-panel">
                                <form action="DriverControllerServlet" method="POST">

                                    <input type="hidden" name="driverloggingform" value="SETTING_ACCOUNT"/>
                                    <p class="warning">${FIRST_NAME_EMPTY}</p>
                                    <div id="new-first-name-field"  class="input-frame">
                                        <input type="text" name="first-name" id="driver-new-first-name" class="input-text" placeholder="FIRST NAME" value="${FIRST_NAME_RETURNED}"/>
                                    </div>

                                    <br/>
                                    <p class="warning">${LAST_NAME_EMPTY}</p>
                                    <div id="new-last-name-field"  class="input-frame">
                                        <input type="text" name="last-name" id="driver-new-last-name" class="input-text" placeholder="LAST NAME" value="${LAST_NAME_RETURNED}"/>
                                    </div>

                                    <br/>
                                    <p class="warning">${LOGIN_EMPTY}</p>
                                    <div id="new-login-field"  class="input-frame">
                                        <input type="text" name="login" id="driver-new-login" class="input-text" placeholder="USER NAME / EMAIL" value="${LOGIN_RETURNED}"/>
                                    </div>

                                    <br/>
                                    <p class="warning">${PHONE_EMPTY}</p>            
                                    <div id="new-phone-field"  class="input-frame">
                                        <input type="text" name="phone" id="driver-new-phone" class="input-text" placeholder="PHONE NUMBER" value="${PHONE_RETURNED}"/>
                                    </div>
                                    <br/>

                                    <p class="warning">${PASSWORD_EMPTY}</p>                           
                                    <div id="new-password" class="input-frame">
                                        <input type="password" name="pass" id="driver-new-pass" class="input-text" placeholder="PASSWORD" value="${PASSWORD_RETURNED}"/>
                                    </div>    
                                    <br/>

                                    <div id="login-submit-button">
                                        <input type="submit" class="login-submit input-frame" value="SING UP" />
                                    </div>    
                                </form>
                            </div><!-- display panel-->    
                            <div style="clear: both"></div> 
                            <br/>
                        </div>
                    </div>
                    <p><a href="signin-login.jsp">Back</a></p>
                </div>
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div>
            </div><!--row 2-->
        </div><!--container-->  
        <%@include file="/basic/bottom.html" %>  
    </body>
</html>
