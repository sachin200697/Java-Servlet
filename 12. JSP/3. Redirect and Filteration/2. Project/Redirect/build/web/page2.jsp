<%-- 
    Document   : page2
    Created on : Apr 28, 2022, 12:33:27 PM
    Author     : sachink1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Page Two</h1>
        
        <%
            response.sendRedirect("page3.jsp");
        %>
    </body>
</html>
