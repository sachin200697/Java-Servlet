<%-- 
    Document   : JSTLFunction
    Created on : Apr 29, 2022, 8:37:46 AM
    Author     : sachink1
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <c:set var="name" value="Sachin"></c:set>
        <c:out value="${fn:length(name)}"></c:out>
        <br>  
        <c:out value="${fn:toUpperCase(name)}"></c:out>
        <br>
        <c:out value="${fn:contains(name, 'Sac')}"></c:out>
    </body>
</html>
