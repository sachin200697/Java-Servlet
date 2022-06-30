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
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class MyHttpServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        
        PrintWriter p = res.getWriter();
        
        p.print("This is working now");
    }
    
    
    //to override any method press alt+insert => select method 
    
}
