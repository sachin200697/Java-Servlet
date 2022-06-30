<%-- 
    Document   : login.jsp
    Created on : Apr 29, 2022, 3:01:28 PM
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
        <title>Registration Page</title>
         <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <div class="form-container">
            <form action="RegisterServlet" method="post" class="register-form">
                <h1>Register here</h1>
                <div>
                    <label>User Name</label><br>
                    <input type="text" name="name" placeholder="Enter Name">
                </div>
                <div>
                    <label>Email address</label><br>
                    <input type="email" name="email" placeholder="Enter Email">
                </div>
                <div>
                    <label>Password</label><br>
                    <input type="password" name="password" placeholder="Password">
                </div>   
                <div>
                    <label>Gender</label><br>
                    <input type="radio" name="gender" value="male"> Male
                    <input type="radio" name="gender" value="female"> Female
                </div>
                <div>
                    <label>Tell something about yourself</label><br>
                    <textarea name="about" rows="5" cols="60" placeholder="Tell something"></textarea>
                </div>
                <div>
                    <input type="checkbox" name="condition" value="checked">
                    <label>Terms and conditions.</label>                    
                </div>
                <div id="registration-wait" style="display:none;"> <h5>Please wait!</h5></div>
                <div>
                    
                    <input type="submit" id="registration-submit-button">
                </div>
            </form>
        </div>
        
        
        
        
        <!--adding jquery for ajax calls-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="js/myscript.js" type="text/javascript"></script>
        <script>  
            $(document).ready(function(){               
                $(".register-form").on('submit', function(event){
                    event.preventDefault();
                    
                    $("#registration-wait").show();
                    $("#registration-submit-button").hide();
                    //we can also pass this 
                    var formData = new FormData(document.getElementsByClassName("register-form")[0]);                                       
                    //console.log(this);                    
                    //console.log(formData);
                    
                    $.ajax({
                        url: "RegisterServlet", 
                        type: "POST",
                        data: formData,
                        success: function(data, textStatus, jqXHR){
                            console.log(data);
                            if(data.trim() !== "success"){
                                alert(data);
                            }
                            else{
                                alert("You have registered successfully!! Regidected to login...");
                                window.location = "login.jsp";
                            }
                            $("#registration-wait").hide();
                            $("#registration-submit-button").show();
                        },
                        error: function(jqXHR, textStatus, errorThrown){
                            console.log(jqXHR);
                            $("#registration-wait").hide();
                            $("#registration-submit-button").show();
                        },
                        processData: false,
                        contentType: false
                    });
                });
            });
        </script>
            
      
    </body>
</html>
