<%-- 
    Document   : SendMail
    Created on : Nov 8, 2016, 2:02:19 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                font-family: Verdana;
            }
            .bluebox{
                border: 2px solid blue;
                padding: 5px;
                margin-left: 10px;
                width: 300px;
                height: 500px;
                float: left;
            }
            textarea {
                width: 290px;
                height: 400px;
            }
            input{
                width: 290px;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <h1>        
            Send an email
        </h1> 
        <div class="bluebox"><p>In order to send an email from a java program it is necessary to have an SMTP mail 
                server running. It is possible to install an smtp server locally, 
                but it is a lot easier to use an online mail server from companies like 
                google or yahoo. In this example I have created a google account 
                just for sending mails.<br><br>The account is: 
                datamatikermail@gmail.com<br>with password: 
                datamatikermail123<br><br>In this form we can enter a recipient a 
                title and a message to send an email from this google account. 
                The sender is hardcoded into the service.SendMail.java file</p>
            <p>The project contains a folder called: dependencies that contains the 2 necessary jar files
                <br>These are also added to the project properties library jars.</p></div>
        <div class="bluebox"><form action="SendMail" method="POST">
                <!--<input type="text" name="from" value="" placeholder="from"/>-->
                <input type="text" name="to" value="" placeholder="send to"/>
                <input type="text" name="title" value="" placeholder="title"/>
                <textarea type="text" name="body" value="" placeholder="message body"></textarea>
                <input type="submit" value="Send email" name="submit" />
            </form></div>
    </body>
</html>
