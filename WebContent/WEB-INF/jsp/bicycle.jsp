<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,ua.scarick.bicycles_servlet.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Должны показываться велосипеды</title>
</head>
<body>
	 <body>      
 
        <hr><ol> <%
             
        List<BicycleStorage> bicycles = (List<BicycleStorage>)request.getAttribute("bicycles");        
            for (BicycleStorage bicycle : bicycles) { %>
                <li> <%= bicycle %> </li> <%
            } %>
        </ol><hr>
 		
        
     </body>

</body>
</html>