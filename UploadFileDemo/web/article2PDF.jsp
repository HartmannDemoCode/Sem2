<%-- 
    Document   : article2PDF
    Created on : May 2, 2016, 1:51:43 PM
    Author     : tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entities.Article, usingdb.DB, java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultSet rs = DB.getConnection().prepareStatement("SELECT headline, caption, body, inserted FROM article").executeQuery();
            Article article = null;
            if (rs.next()) {
                article = new Article(rs.getString("headline"), rs.getString("caption"), rs.getString("body"), rs.getDate("inserted"));
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.print(article.getHeader()); %></title>
        <style>
            #date{
                position: relative;
                left: 80%;
                /*border: 3px solid lightsteelblue;*/
                padding-left: 5px;
            }
            #container{
                position: relative;
                margin: auto;
                width: 500px;
            }
            h1, h3, p {
                border: 2px solid lightseagreen;
                padding: 4px;
            }
            #print{
                -webkit-appearance: button;
                -moz-appearance: button;
                appearance: button;

                text-decoration: none;
                color: initial;
            }
        </style>
    </head>
    <body>

        <div id="container">
            <a href="Print2PDF" id="print">print as PDF</a>
            <div id="date"><% out.print(article.getInserted()); %></div>
            <h1><% out.print(article.getHeader()); %></h1>
            <h3><% out.print(article.getCaption()); %></h3>
            <p><% out.print(article.getBody());%></p>
        </div>
    </body>
</html>
