<!--We need to import Date before use-->
<%@page import="java.util.Date"%>




<h1 style="background: black; padding: 20px; color: white;">
    This is my header @ 
    
    <!--using expression tag to show date-->
    <%= new Date().toString() %>
</h1>