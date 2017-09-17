<%-- 
    Document   : uploadSimple
    Created on : Apr 22, 2016, 10:17:50 AM
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
        <h2>Upload</h2>
        <form action="FileUpload" method="post" enctype="multipart/form-data">
            <input type="file" name="file" size="50" /><br />
            <input type="submit" value="Upload File" />
            <input type="hidden" name= "location" value="toDisk">
    </body>
</html>
