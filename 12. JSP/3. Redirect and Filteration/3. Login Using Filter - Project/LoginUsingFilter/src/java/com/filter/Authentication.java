/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filter;

/**
 *
 * @author sachink1
 */
import com.common.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class Authentication implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        
        HttpSession s = req.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username==null||password==null){
            response.setContentType("text/html");
            PrintWriter p = response.getWriter();
            p.print("<h1>Please try to login first</h1>");
            
        }
        
        //it is like checking in the database to authenticate the user
        //if user exists then store the informations of user from database to a session object
        // using User object, so that it can be used by other pages to decide which content
        // to display or which content not to display        
        if(username.equals("Sachin") && password.equals("1")){
            User u = new User(username, password);  
            
            s.setAttribute("user", u);
            chain.doFilter(request, response);
        }else{
            //don't set user and also don't sent it to the next page
            // it means we are restrecting user
            
            response.setContentType("text/html");
            PrintWriter p = response.getWriter();
            p.print("<h1>Incorrect Username or Password!");
            p.print("<h3><a href='index.html'>Go back</a></h3?");
        }
        
        System.out.println(username + " " + password);
        
    }

    @Override
    public void destroy() {
        
    }
    
}
