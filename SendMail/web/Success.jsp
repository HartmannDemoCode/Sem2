<%-- 
    Document   : succes
    Created on : Nov 8, 2016, 2:09:26 PM
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
        <h1>Success</h1>
        You have send an email with the following content:
        <% out.println(request.getParameter("body")); %>
    </body>
</html>
