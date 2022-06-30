/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

/**
 *
 * @author sachink1
 */
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
public class FirstServlet implements Servlet{  
    ServletConfig conf;
    
    //Life-Cycle Methods
    public void init(ServletConfig conf){
        this.conf = conf;
        System.out.println("Creating Object..........");
    }
    
    //it throws two exceptions ServletException and IOException so we need to throws them
    public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException{
        
        System.out.println("Servicing..........");
        
        //writing to the web page
        res.setContentType("text/html");
        PrintWriter p = res.getWriter();
        p.println("<h1>Hello Friends</h1>");
        p.println("<h2>This is my first Servlet web project</h2>");
        p.println("<h3>" + new Date().toString() + "</h3>");
        
        //use http://localhost:9494/CreateServlet/web to get above response on web page
        
    }
    
    public void destroy(){
        System.out.println("Going to destroy object........");
    }
    
    //Non Life-Cycle Methods
    public ServletConfig getServletConfig(){
        return this.conf;
    }
    
    public String getServletInfo(){
        return "This servled is crated by Sachin Kumar";
    }
    
}
