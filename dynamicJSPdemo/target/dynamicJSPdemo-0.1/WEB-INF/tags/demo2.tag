<%-- 
    Document   : demo2
    Created on : Dec 8, 2016, 1:10:44 PM
    Author     : Thomas Hartmann - tha@cphbusiness.dk
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="msg" required="true"%>
<%@attribute name="mylist" required="true" type="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- any content can be specified here e.g.: --%>

<h2>From index comes msg: ${msg} and from mylist comes these:</h2>
    <ul>
        <c:forEach items="${mylist}" var="item">
          <li>${item}</li>
        </c:forEach>
    </ul>
    <h2>From the body of this tag (as it was used in the jsp page comes this: </h2>
    <div id="tagbody"><jsp:doBody/></div>
    <!--jsp:doBody is used in order to show larger content (instead of writing it inside an 
    attribute og the tag element. Rather it is the content between the start and end-tag of this tag.-->