<%-- 
    Document   : PostMethodForm
    Created on : 14-02-2015, 14:29:35
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
        This form contains some test data in the form of a hidden input type and a text input type
        <form name="Form1" action="Control" method="POST">
            <input type="text" name="inputTxt" value="test" />
            <input type="hidden" name="origin" value="Data from the hidden field" />
            <input type="submit" value="Submit" name="submit" />
        </form>
    </body>
</html>
