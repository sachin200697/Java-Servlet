
<%@page import="com.tech.blog.entities.User"%>
<%@page import="com.tech.blog.dao.LikeDao"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<div class="post-container">
    <%
       //fetch used to like the post
       User user = (User)session.getAttribute("user");
      int cid = Integer.parseInt(request.getParameter("cid"));
      PostDao pdao = new PostDao(ConnectionProvider.getConnection());;
      List<Post> list;
      if(cid==0){
        list = pdao.getAllPosts();
      }else{
        list = pdao.getPostByCatId(cid);
      }
      
      if(list.size()==0){
        out.println("<h3>No post present in this category</h3>");
        return;
      }
      
      for(Post p : list){
    %>
    
    <div class="post">
        <h3><%=p.getTitle()%></h3>
        <p><%= p.getContent() %></p>        
        <p><img src="blog_pics/<%= p.getPic() %>" ></p>        
        
        <div>
            <a href="show_post_details.jsp?post_id=<%= p.getPid() %>">Read More</a>&nbsp;&nbsp;&nbsp;
            <%
                LikeDao ldao = new LikeDao(ConnectionProvider.getConnection());                
            %>
            <a href="#" onclick="doLike(<%=p.getPid() %>,<%= user.getId()%>)"> <i class="fa fa-thumbs-o-up"></i><span id="count-like"><%=ldao.countLikeOnPost(p.getPid())%></span> </a>&nbsp;&nbsp;&nbsp;
            <a href="#"> <i class="fa fa-commenting-o"></i><span>10</span></a>
        </div>
    </div>
    
    <%
        }
        %>
    
</div>