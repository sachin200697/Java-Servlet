<%-- 
    Document   : error.jsp
    Created on : May 2, 2022, 1:49:31 PM
    Author     : sachink1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry! Something went wrong..</title>
    </head>
    <body>
        <h1>Sorry ! Something went wrong....</h1>
        <%= exception %>
        <button><a href="index.jsp">Home</a></button>
    </body>
</html>
