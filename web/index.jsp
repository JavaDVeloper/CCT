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
    <div class="row"> <!-- row 2 -->
        <div class="col-md-0 col-lg-1 col-xl-1">
        </div>   
        <div class="col-md-12 col-lg-10 col-xl-10 main-panel">
            <p id="header-text">CHOOSE YOUR OPTION</p>
                <div class="display-panel">
                    <div class="display">
            		<a href="mechanic.jsp">
                            <div id="display-picture-mechanic">
                            <!--<img src="img/mech_login_img.png" alt="Mechanic login page"/> -->
                            </div>
			</a>		               		
                	<div class="display-description-mechanic">
			Mechanic         
                	</div>
                    </div>

                    <div class="display">
                        <a href="driver.jsp">
                            <div id="display-picture-driver">                      
                            <!-- <img src="img/driver_login_img.png" alt="Driver login page"/> -->
                            </div>
                        </a>    
                	<div class="display-description-driver">
                	Driver
                	</div>
                    </div>
                </div>
                                  
                <div style="clear: both"></div> 
		<div class="button-gap"></div>
	</div>   
        <div class="col-md-0 col-lg-1 col-xl-1">
        </div> 
    </div> <!-- end row 2 -->
    
    <%@include file="/basic/bottom.html" %>

</body>
</html>