<%-- 
    Document   : cars
    Created on : Sep 17, 2017, 10:42:37 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, domain.Car, control.Collection2Html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Cars from collection in the session: </h2>
        <% List<Car> cars = (List<Car>)session.getAttribute("carList"); %>
        <table><thead><tr><th>Make</th><th>Model</th><th>Year</th></tr></thead>
            <tbody>
                <% for(Car car : cars){ %>
                <tr><td><%=car.getMake()%></td><td><%=car.getModel()%></td><td><%=car.getYear()%></td></tr>
              <%  } %>
            </tbody></table>
           
            
            
            
            
            
            ----------------------------- Table from the view converter ----------------------------
            <%=Collection2Html.carList2HtmlTable((List<Car>)session.getAttribute("carList")) %>
    </body>
</html>
