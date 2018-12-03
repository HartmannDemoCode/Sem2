<%-- 
    Document   : uploadimage
    Created on : Nov 17, 2016, 8:52:11 AM
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
        <h1>Upload Image from your local machine to DB</h1>
        <form action="Upload2DBControl" method="POST" enctype="multipart/form-data">
            <input type="text" name="imagename" placeholder="enter filename"/><br>
            <input type="file" name="imagefile"/><br>
            <input type="submit" value="Submit" />
        </form>
        
        <h1>Upload Image from your local machine to disk</h1>
        <form action="Upload2DiskControl" method="POST" enctype="multipart/form-data">
            <input type="file" name="imagefile"/><br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
