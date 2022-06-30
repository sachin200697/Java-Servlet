<%-- 
    Document   : sql
    Created on : Apr 29, 2022, 8:51:55 AM
    Author     : sachink1
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
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
        
        <sql:setDataSource driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/practice" user="sachin" password="sachin" var="ds"></sql:setDataSource>
        
        <!--ds is the variable declared in sql:setDataSource to hold to data of table-->
        <sql:query dataSource="${ds}" var="resultSet">Select * from user;</sql:query>
        
        <table>            
            <tr>
                <td>Id</td>
                <td>Name</td>
            </tr>
            
            <c:forEach items="${resultSet.rows}" var="row">
            <tr>
                <td><c:out value="${row.id}"></c:out></td>
                <td><c:out value="${row.name}"></c:out></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
