<%-- 
    Document   : login.jsp
    Created on : Apr 29, 2022, 3:01:28 PM
    Author     : sachink1
--%>
<%@page import="com.tech.blog.entities.Message"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--import java.sql package's all class to work with databases-->
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
         <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <div>
            <form action="LoginServlet" method="post" id="login-form">
                <h1>Login Here</h1>
                
                <%
                    Message m = (Message)session.getAttribute("msg");
                    if(m!=null){              
                %>
                <div class=" <% m.getClass(); %>">
                    <%= m.getContent() %>
                </div>
                <%
                    session.removeAttribute("msg");
                    }
                %>
                <div>
                    <label>Email address</label>
                    <input type="email" name="email" placeholder="Enter Email">
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Password">
                </div>  
                <div id="login-wait" style="display:none;"> <h5>Please wait!</h5></div>
                <div>
                    
                    <input type="submit" id="login-submit-button">
                </div>
            </form>
        </div>
        
        
        
        
        <!--adding jquery for ajax calls-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="js/myscript.js" type="text/javascript"></script>
        
        <script>
//            $(document).ready(function(){
//                $("#login-form").on('submit', function(event){
//                    event.preventDefault();
//                    $("#login-wait").show();
//                    $("#login-submit-button").hide();
//                    //we can also pass this 
//                    var formData = new FormData(document.getElementById("login-form"));                                       
//                    //console.log(this);                    
//                    //console.log(formData);
//                    
//                    $.ajax({
//                        url: "LoginServlet", 
//                        type: "POST",
//                        data: formData,
//                        success: function(data, textStatus, jqXHR){
//                            console.log(data);
//                            
//                            $("#login-wait").hide();
//                            $("#login-submit-button").show();
//                        },
//                        error: function(jqXHR, textStatus, errorThrown){
//                            console.log(jqXHR);
//                            $("#login-wait").hide();
//                            $("#login-submit-button").show();
//                        },
//                        processData: false,
//                        contentType: false
//                    });
//                });
//            });
        </Script>
    </body>
</html>
