<%-- 
    Document   : error_page
    Created on : Apr 28, 2022, 9:25:20 AM
    Author     : sachink1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--To tell this is error page and it will handle the error-->
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sorry Something went wrong</h1>
        
        <h3><%= exception %></h3>
    </body>
</html>
