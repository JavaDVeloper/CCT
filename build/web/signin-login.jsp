<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>GARBOX - Welcome!</title>
    </head>
    <body>
        <%@include file="/basic/header.jsp" %>
        <div class="container">
            <div class="row"> <!-- row 2 -->
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div>   
                <div class="col-md-12 col-lg-10 col-xl-10">
                  <a href="index.jsp"><p class="top-button">Back</p></a>
                    <div class="main-panel">  
                        <br/>
                        <p class="warning-top">${NOT_NEW_USER_INFO}</p>     
                        <div class="thin-frame">
                            <label>CHOOSE YOUR OPTION</label>
                            <br/>
                            <div class="display-panel">
                                <div class="display">
                                    <a href="new-driver.jsp">
                                        <div id="display-picture-new-driver">
                                            <!--<img src="img/mech_login_img.png" alt="Mechanic login page"/> -->
                                        </div>
                                    </a>		               		
                                    <div class="display-description-new-driver">
                                        New customer        
                                    </div>
                                </div>

                                <div class="display">
                                    <a href="driver.jsp">
                                        <div id="display-picture-existing-driver">                      
                                            <!-- <img src="img/driver_login_img.png" alt="Driver login page"/> -->
                                        </div>
                                    </a>    
                                    <div class="display-description-existing-driver">
                                        Existing customer
                                    </div>
                                </div>
                            </div><!--display panel-->
                        </div><!--service-type-frame-->	
                        <div style="clear: both"></div> 
                        <br/>
                    </div><!--main panel-->
                </div>  
                <div class="col-md-0 col-lg-1 col-xl-1">
                </div> 
            </div> <!-- end row 2 -->
        </div> <!--container-->
        <%@include file="/basic/bottom.html" %>
    </body>
</html>