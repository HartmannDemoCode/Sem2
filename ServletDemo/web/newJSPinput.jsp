<%-- 
    Document   : newJSP
    Created on : Sep 18, 2017, 12:53:46 PM
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
        <form action="NewServlet" method="POST">
            <input type="text" name="username" value="" />
            <input type="submit" value="submit" name="submit" />
        </form>
    </body>
</html>
