<%-- 
    Document   : showimages
    Created on : Nov 17, 2016, 8:52:28 AM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page import="presentation.ImageControl, data.ImageMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show all images</title>
        <style>
            .button{
                vertical-align: middle;
                display: block;
                width: 50%;
                margin: 0 auto;
            }

            .container {
                background: bisque;
                display: table;
                width:20%;
            }
            .formcontainer{
                background: chocolate;
                display: table-cell;
                vertical-align: middle;
            }



        </style>
    </head>
    <body>
        <%  ImageMapper im = new ImageMapper();
//            if (session.getAttribute("images") == null) {
//                response.sendRedirect("ImageControl");
//                return;
//            }
        %>
        <h1>See the images here: </h1>
        <% int[] imageIds = im.getAllImageIds();
            for (int i = 0; i < imageIds.length; i++) {
                int id = imageIds[i];
        %><div class="container"><img src="ImageViewer?id=<%= id%>"><div class="formcontainer"><form action="ImageControl" method="POST"><input type="hidden" name="delete" value="<%= id%>"><input type="submit" value="Slet" class="button"></form></div></div><br>
                    <%
        }

                    %>
    </body>
</html>
