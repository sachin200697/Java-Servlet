<%-- 
    Document   : index
    Created on : Apr 29, 2022, 11:25:12 AM
    Author     : sachink1
--%>

<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--import java.sql package's all class to work with databases-->
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <%@include file="navbar.jsp"  %>
        
        <!--for conectviry-->
        <%
            Connection con = ConnectionProvider.getConnection();
            %>
        <%--<%= con %>--%>
        
        <div>
            <h1>Welcome to TechBlog</h1>
            <div>
                <p>Computer programming is the process of performing a particular computation 
                   (or more generally, accomplishing a specific computing result), usually by 
                   designing/building an executable computer program.  
                </p>    
                <p>
                    The source code of 
                   a program is written in one or more languages that are intelligible to programmers, 
                   rather than machine code, which is directly executed by the central processing unit.
                </p>
                
                <div>
                    <button>Start It't Free</button>
                    <button><a href="login.jsp">Login</a></button>
                </div>
            </div>
        </div>
        
        <div class="row">
        <div class="card">
            <h1>Welcome to TechBlog</h1>
            <div>                 
                <p>
                    The source code of which is directly executed by the central processing unit.
                </p>                
                <div>                    
                    <button>Login</button>
                </div>
            </div>
        </div>
        
        
        <div class ="card">
            <h1>Welcome to TechBlog</h1>
            <div>                 
                <p>
                    The source code of which is directly executed by the central processing unit.
                </p>                
                <div>                    
                    <button>Login</button>
                </div>
            </div>
        </div>

        
        <div class="card">
            <h1>Welcome to TechBlog</h1>
            <div>                 
                <p>
                    The source code of which is directly executed by the central processing unit.
                </p>                
                <div>                    
                    <button>Login</button>
                </div>
            </div>
        </div>

        
            <div class="card">
            <h1>Welcome to TechBlog</h1>
            <div>                 
                <p>
                    The source code of which is directly executed by the central processing unit.
                </p>                
                <div>                    
                    <button>Login</button>
                </div>
            </div>
        </div>

        
            <div class="card">
            <h1>Welcome to TechBlog</h1>
            <div>                 
                <p>
                    The source code of which is directly executed by the central processing unit.
                </p>                
                <div>                    
                    <button>Login</button>
                </div>
            </div>
        </div>

        
        <div class="card">
            <h1>Welcome to TechBlog</h1>
            <div>                 
                <p>
                    The source code of which is directly executed by the central processing unit.
                </p>                
                <div>                    
                    <button>Login</button>
                </div>
            </div>
        </div>
            
            </div>

        
        <!--adding jquery for ajax calls-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="js/myscript.js" type="text/javascript"></script>
        
        <script>
           
        </script>
    </body>
</html>
