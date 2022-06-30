<%-- 
    Document   : signup
    Created on : Apr 27, 2022, 10:29:27 AM
    Author     : sachink1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <style>
            body{
                height: 90vh;
                display: flex;
                flex-direction: column;
                
                align-items: center;
            }
            .loader{
                margin-top: auto;
                display: none;
            }
            .green{
                color: green;
            }
            .red{
                color: red;
            }
        </style>
    </head>
    
    <body>
        <h1>User Registration</h1>
        
        <form action="Register" method="post" id="myform">
            <h5 id="msg"></h5>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="user_name"></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="email" name="user_email"></td>
                </tr>  
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="user_password"></td>
                </tr>
                <tr>
                    <td>Choose Image: </td>
                    <td><input type="file" name="user_image"></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" name=""></td>
                </tr>
            </table>
        </form>
        
        
        <div class="loader">
            Loading....
        </div>
        
        <script>
            $("#myform").on("submit", function(event){
                //to not go to other page, and not to reload the page
                event.preventDefault(); 
                $("#myform").hide();
                $(".loader").show();
                                
                var f = new FormData(this);
                console.log(f); 
                
                //ajax request
                $.ajax({
                    url: "Register",
                    data: f,
                    type: "POST", 
                    success: function(data, textStatus, jqXHR){
                        console.log(data);
                        console.log("Success.....");
                        $("#myform").show();
                        $(".loader").hide();                      
                        
                        if(data==="success"){
                            $("#msg").html("User registered successfully");
                            $("#msg").addClass("green");
                        }else{
                            $("#msg").html("Something went wrong on server");
                            $("#msg").addClass("red");
                        }
                    },
                    error: function(data, textStatus, errorThrown){
                        console.log(data);
                        console.log("Error.....")
                        $("#myform").show();
                        $(".loader").hide();
                     
                    },
                    processData: false,
                    contentType: false
                });  //Register is the servlet on which we want to sent it
                
                
            });
        </script>
    </body>
</html>
