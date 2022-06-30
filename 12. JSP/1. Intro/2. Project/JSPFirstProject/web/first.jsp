<%-- 
    Document   : first
    Created on : Apr 27, 2022, 4:39:17 PM
    Author     : sachink1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--It can be true if it is an error page--> 
<%@page isErrorPage="false" %>

<!--It can be flase if we dont want to use session on this page-->
<%@page session="true" %>  


<!--handle error or exception-->
<%@page errorPage="error_page.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@include file="header.jsp" %>
        <h1>Hello World!</h1>
        
        <%!
            //we can declare variables and methods in this tag
            int a = 50;
            int b = 10;
            String name = "Sachin Kumar";
            
            public int sum(int a, int b){
                return a+b;
            }

            public String reverse(String s){
                StringBuffer sb = new StringBuffer(s);
                return sb.reverse().toString();
            }
        %>
        
        
        <%
            out.println(a);
            out.println("<br>");
            out.println(b);
            out.println("<br>");
            out.println(sum(a, b));
            out.println("<br>");            
            out.println(reverse(name));
        %>
        <br> 
        <br>
        <h1><%= sum(a,b) %></h1>
        
        
        <!--Prefix tells that we will start out tag with the given character or string-->
        <!--using uri we can tell which part we are going to use-->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
        
        <c:set var="name" value="Sachin Kumar"></c:set>
        <c:out value="${name}"></c:out>
        
        <c:set var="sum" value="10"></c:set>
        <c:if test="${sum==10}">
            <h1>Condition is True</h1>
        </c:if>
            
            
            
        <!--error code that will generate the error and it will be handled by error_page.jsp-->
        <%!
            int p = 10;
            int q = 0;
        %>
        
        <h2>Division is <%= p/q %> </h2>
    </body>
</html>
