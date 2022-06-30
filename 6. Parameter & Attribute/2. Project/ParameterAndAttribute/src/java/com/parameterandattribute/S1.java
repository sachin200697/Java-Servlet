
package com.parameterandattribute;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
          
            //getting parameters
            int n1 =Integer.parseInt(request.getParameter("n1"));
            int n2 =Integer.parseInt(request.getParameter("n2"));
            
            //setting attributes
            request.setAttribute("sum", (n1+n2));   // n1+n2 = Integer object     
            
            //forward request using RequestDispatcher
            RequestDispatcher rd = request.getRequestDispatcher("S2");  //it can be "/S2" as well
            rd.forward(request, response);
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
