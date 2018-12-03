<%-- 
    Document   : demo
    Created on : Dec 8, 2016, 12:39:24 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h2>Her er message skrevet ud fra tag: ${message}</h2>
<p>Her er lidt text fra det indsatte tag..</p>
