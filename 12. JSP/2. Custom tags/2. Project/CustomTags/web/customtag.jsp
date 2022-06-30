<%-- 
    Document   : customtag
    Created on : Apr 28, 2022, 10:45:41 AM
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
        <h1>Hello World!</h1>
        
        <%@taglib uri="/WEB-INF/tlds/mylib" prefix="t" %>     
        <!--mytag is the name of tag defined in mylib.tld file-->
        <t:mytag></t:mytag>
        
        <t:printTable number="5" color="red"></t:printTable>
        
        <t:printTable number="10" color="green"></t:printTable>
    </body>
    
    
</html>
