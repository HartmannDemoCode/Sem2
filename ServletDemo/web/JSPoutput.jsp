<%-- 
    Document   : JSPoutput
    Created on : Sep 18, 2017, 12:56:31 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Hello <% out.println(request.getAttribute("username")); %>
                
                
    </body>
</html>
