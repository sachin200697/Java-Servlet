<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>This is index.jsp page</h2>
        
        
        <!--If we don't use score then name will be accessible only in this page-->
        <!--scope = "application" to use it in test.jsp page-->
        <c:set var="name" value="Sachin Kumar" scope="application"></c:set>
        
        <c:out value="${name}"></c:out>
        
        <c:set var="i" value="10"></c:set>
        <c:out value="${i}"></c:out>
        <c:remove var="i"></c:remove>
        
        <!--will not print value of i as it is removed now-->
        <c:out value="${i}">This is default value and will be display if variable i not found</c:out>    
        
        <c:if test="${name != null}">
            <h1> This is true </h1>
        </c:if>
        
            
        <!--Switch--> 
        <c:set var="age" value="19"></c:set>
        <c:choose>
            <c:when test="${age<18}">
                <h2>Child</h2>
            </c:when>
                
            <c:when test="${age<35}">
                <h2>Young </h2>
            </c:when>
                
                <c:otherwise>
                    <h2> Old Person</h2>
                </c:otherwise>
        </c:choose>
                    
                    
        <!--Loop-->
        <c:forEach var="j" begin="1" end="10">
            <h3>Value of j is <c:out value="${j}"></c:out></h3>
        </c:forEach>
            
        <c:set var="animals" value='Sachin, Pradeep'></c:set>
        
        <c:forEach var="j" items="${animals}">
            <h3>Value of j is <c:out value="${j}"></c:out></h3>
        </c:forEach>
            
        <!--redirect to some other page-->
        <%--<c:redirect url="test.jsp"></c:redirect>--%>
        
        <!--if we want to redirect by appending some values to url then we can use like below-->
        <c:url var="myUrl" value="test.jsp">
            <c:param name="usename" value="sk"></c:param>
            <c:param name="password" value="123"></c:param>
        </c:url>
        <c:out value="${myUrl}"></c:out>
        <%--<c:redirect url="${myUrl}"></c:redirect>--%>
        
        
        <%
            int num=5;
            %>
            <c:out value="${num}"></c:out>
        
    </body>
</html>
