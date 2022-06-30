<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.Category"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.entities.Message"%>
<%@page import="com.tech.blog.entities.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>

        <%
            User user = (User) session.getAttribute("user");

            if (user == null) {
                response.sendRedirect("login.jsp");
            }
        %>

        <!--navbar start-->

        <nav class="navbar">
            <ul class="navbar__ul">
                <li class="navbar__li">
                    <a href="#" class="navbar__a"><i class="fa fa-home"> </i> Tech Blog</a>
                </li>
                <li class="navbar__li">
                    <a href="#" class="navbar__a">Learning</a>
                </li>        
                <li class="navbar__li">
                    <a href="#" class="navbar__a navbar__a__category">
                        <span>Categories</span>

                        <ul class="navbar__category">
                            <li class="navbar__category__li">
                                <a class="navbar__category__a" href="www.google.com">Catdsfsdfs 1</a>
                            </li>
                            <li class="navbar__category__li">
                                <a class="navbar__category__a" href="#">Cat 2</a>
                            </li>
                            <li class="navbar__category__li">
                                <a class="navbar__category__a" href="#">Cat 4</a>
                            </li>
                            <li class="navbar__category__li">
                                <a class="navbar__category__a"  href="#">Cat 5</a>
                            </li>
                            <li class="navbar__category__li">
                                <a class="navbar__category__a"  href="#">Cat 6</a>
                            </li>
                        </ul>
                    </a>
                </li>
                <li class="navbar__li">
                    <a href="#" class="navbar__a"><i class="fa fa-volume-control-phone"></i> Contact</a>
                </li>
                <li class="navbar__li">
                    <a href="#" class="navbar__a" onclick='doPost()'> Do Post</a>
                </li>



            </ul>

            <div>

                <a href="LogoutServlet" class="navbar__a"><i class="fa fa-volume-control-phone"></i> Logout</a>

                <a href="#" class="navbar__a" onclick="showProfile()"><%= user.getName()%></a>
            </div>

        </nav>

        <!--navbar end-->


        <div>
            <%
                Message m = (Message) session.getAttribute("msg");
                if (m != null) {
            %>
            <h3 class="<%= m.getClass()%>"><%= m.getContent()%></h3>
            <%
                    session.removeAttribute("msg");
                }
            %>

        </div>

        <div class="profile" style="border: 1px solid black; display: none; border: 1px solid black">                                              
            <img src="pics/<%= user.getProfile()%>" style="width:200px; height: 200px; border-radius: 100px;"/>
            <h3><%= user.getName()%></h3> 

            <div class="profile-details">
                <table>
                    <tr>
                        <td>Id</td>
                        <td><%= user.getId()%></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><%= user.getEmail()%></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><%= user.getGender()%></td>
                    </tr>                
                    <tr>
                        <td>About</td>
                        <td><%= user.getAbout()%></td>
                    </tr>
                    <tr>
                        <td>Register Date</td>
                        <td><%= user.getDateTime()%></td>
                    </tr>
                </table>    
            </div>



            <div class="profile-edit">
                <h2>Please Edit Carefully</h2>
                <form action="EditServlet" method="post" enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td>Id</td>
                            <td><%= user.getId()%></td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td><input type="text" name="name" value="<%= user.getName()%>"></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input type="email" name="email" value="<%= user.getEmail()%>"></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password" value="<%= user.getPassword()%>"></td>
                        </tr>
                        <tr>
                            <td>Gender</td>
                            <td><%= user.getGender()%></td>
                        </tr>                
                        <tr>
                            <td>About</td>
                            <td><textarea name="about" cols="40" rows="5" ><%= user.getAbout()%></textarea></td>
                        </tr>
                        <tr>
                            <td>New Profile Pic</td>
                            <td><input type="file" name="image" /></td>
                        </tr>
                        <tr>
                            <td>Register Date</td>
                            <td><%= user.getDateTime()%></td>
                        </tr>
                        <tr>
                            <td>                            
                            </td>
                            <td>
                                <input type="submit" value="Submit">
                            </td>
                        </tr>
                    </table>   
                </form>
            </div>   

            <button class="profile-edit-button">Edit</button>
        </div>      

        <div id="form-post-container" style="display:none; border: 1px solid black;">
            <form action="AddPostServlet" method="post" enctype="multipart/form-data" id="form-post">
                <h2>Provide post details</h2>
                <div>
                    <select name="cid">
                        <option selected="true" disabled>-- select category --</option>

                        <%
                            PostDao p = new PostDao(ConnectionProvider.getConnection());

                            ArrayList<Category> list = p.getAllCategories();
                            for (Category c : list) {

                        %>
                        <option value="<%= c.getCid()%>"><%= c.getName()%></option>
                        <%
                            }
                        %>                                    
                    </select>
                </div><br>
                <div>
                    <input type='text' placeholder='Enter post title' name="title">
                </div>
                <br>
                <div>
                    <textarea name='content' rows="5" cols='40' placeholder='Enter post content'></textarea>
                </div>
                <br>
                <div>
                    <textarea name='code' rows="5" cols='40' placeholder='Enter your code, if any'></textarea>
                </div>
                <br>
                <div>
                    Choose you pic: 
                    <input type='file' name='pic'>
                </div>
                <div>

                    <input type='submit' value="Post">
                </div>
            </form>
        </div>

        <main id="main">
            <div class="categories"> 
                <ul>
                    <li><button onclick="getPosts(0, this)" class="post-button" id="all-posts">All Categories</button></li>
                    <%
//                        PostDao p = new PostDao(ConnectionProvider.getConnection());
//                        ArrayList<Category> list = p.getAllCategories();
                        for (Category c : list) {
                    %>
                    <li><button onclick="getPosts(<%= c.getCid()%>, this)" class="post-button"> <%= c.getName()%></button></li>
                        <% }%>
                </ul>
            </div>
            <div class="content">
                <div id="loader">
                    <i class="fa fa-refresh fa-3x fa-spin"></i>
                </div>
                <div id="post-content"></div>
            </div>
        </main>


        <!--adding jquery for ajax calls-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="js/myscript.js" type="text/javascript"></script>

        <script>
                        $(document).ready(function () {
                            $(".profile-edit").hide();
                            let editStatus = false;

                            //$(".profile-edit-button").click(function(){});  //we can also use it
                            $(".profile-edit-button").on("click", function (event) {
                                editStatus = !editStatus;
                                if (editStatus) {
                                    $(this).text("Back");
                                    $(".profile-edit").show();
                                    $(".profile-details").hide();
                                } else {
                                    $(this).text("Edit");
                                    $(".profile-edit").hide();
                                    $(".profile-details").show();
                                }
                            });


                            $("#form-post").on("submit", function (event) {
                                event.preventDefault();
                                var f = new FormData(this);
                                $.ajax({
                                    url: "AddPostServlet",
                                    type: "POST",
                                    data: f,
                                    success: function (data, statusCode, jqXHR) {
                                        alert("Post created successfully");
                                        console.log(data);
                                    },
                                    error: function (jqXHR, errorCode, errorThrown) {
                                        alert("Something went wrong!!");
                                        console.log(jqXHR);
                                    },
                                    processData: false,
                                    contentType: false
                                })
                            })
                        });

                        function doPost() {
                            $("#form-post-container").toggle();

                        }
                        
                        function showProfile() {
                            $(".profile").toggle();

                        }
        </script>

        <!--ajax request to load all posts-->
        <script>
            function getPosts(cid, currentHtmlElement){
                //we will get currentHtmlElement by passing this argument in getPosts function
                
                //to make active first remove active from all elements
                $(".post-button").removeClass("active");
                this.add
                
                $("#loader").show();
                $.ajax({
                    url: "load_post.jsp",
                    data: {cid: cid},
                    success: function (data, textStatus, jqXHR) {
                        //alert("success");
                        $("#loader").hide();
                        
                        //make link active
                        $(currentHtmlElement).addClass("active");
                        
                        $("#post-content").html(data);
                        console.log(data);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        //alert("error");
                        console.log(jqXHR);
                    }
                })
            }
            
            $(document).ready(function () {
                getPosts(0, $("#all-posts"));
            });
        </script>
    </body>
</html>
