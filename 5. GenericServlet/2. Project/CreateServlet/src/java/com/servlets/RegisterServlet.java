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
public class RegisterServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter p = res.getWriter();
        
        String name = req.getParameter("user_name");
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        String gender = req.getParameter("user_gender");
        String course = req.getParameter("user_course");
        String condition = req.getParameter("condition");
        
        if(condition != null){
            if(condition.equals("checked")){
                p.print("<h1>Form Data</h1>");
                p.print("<h3>Name " + name + "</h3>");
                p.print("<h3>Password " + password + "</h3>");
                p.print("<h3>Email " + email + "</h3>");
                p.print("<h3>Gender " + gender + "</h3>");
                p.print("<h3>Course " + course + "</h3>");
            }
            
            RequestDispatcher rd = req.getRequestDispatcher("/success");
            //rd.include(req, res); //all details will be display of this page and of SuccessServlet page
            rd.forward(req, res);   // only SuccessServlet page details will be display
        }
        else{
            //if user does not check the condition checkbox then show this
            p.print("<h1>Your have not accepted terms and conditions</h1>");
            
            
            //if we want to show the form as well to fill again then with the above response we can also
            // include the form as well to fill again using below code.
            //RequestDispatcher
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            //we need to give the file name or url pattern of servlet ex: "/web"
            rd.include(req, res);
        }
        
        
    }
}
