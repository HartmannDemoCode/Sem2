<%-- 
    Document   : ShowImages
    Created on : Apr 19, 2016, 3:34:05 PM
    Author     : tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, usingdb.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Show images in scriplets!</h3>
        <img src="<% out.print(request.getContextPath()); %>/ImageViewer?imgno=1">
        <img src="<% out.print(request.getContextPath()); %>/ImageViewer?imgno=2">
        
        <h3>Show all images loop with scriplets!</h3>
        <% 
        ImageMapper im = new ImageMapper();
        List<Image> images = im.loadImages();
        
        for(int i = 1; i <= images.size(); i++){
            //out.print("<img src=\""+request.getContextPath()+"/ImageViewer?imgno="+i+"\"><br>");
        };
        %>
        <h3>Show images in jstl - this only works if we have come via the servlet.</h3>
       
        <c:forEach var="img" items="${images}">
            <img src="ImageViewer?imgno=${img.id}"><br>
            <span>${img.description}</span><br>
        </c:forEach>
    </body>
</html>
