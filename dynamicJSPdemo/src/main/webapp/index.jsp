<%-- 
    Document   : index
    Created on : Dec 8, 2016, 12:46:06 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@ taglib prefix="topbar" tagdir="/WEB-INF/tags/navigation" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #tagbody{
                color: red;
            }
        </style>
    </head>
    <body>
        <topbar:topbar/>
        <h1><tags:demo message="Her skrives dynamisk data"/></h1>
        <tags:demo2 msg="content of msg" mylist="${list}">
            All this content in here is red because
            it is the body of the demo2 tag
        </tags:demo2>
            
        

    </body>
</html>
