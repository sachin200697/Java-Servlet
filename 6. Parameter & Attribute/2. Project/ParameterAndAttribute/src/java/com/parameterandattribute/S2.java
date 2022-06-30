
package com.parameterandattribute;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet S1</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //getting parameters
            int n1 =Integer.parseInt(request.getParameter("n1"));
            int n2 =Integer.parseInt(request.getParameter("n2"));
            
            //getting attributes
            int sum = (int)request.getAttribute("sum");
            
            out.println("<h1>");
            
            out.print("Sum is: " + sum);
            out.print("<br>");
            out.print("Multiplication is: " + n1*n2);
            
           
            out.println("</h1>");
            
           
            out.println("</body>");
            out.println("</html>");
            
            
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
