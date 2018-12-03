<%-- 
    Document   : errorview
    Created on : Dec 4, 2017, 1:26:28 PM
    Author     : tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ERROR: <%=request.getAttribute("error")%>
    </body>
</html>
