/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author sachink1
 */

@MultipartConfig
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {        
            
            String name = request.getParameter("user_name");
            String email = request.getParameter("user_email");
            String password = request.getParameter("user_password");   
            
            //to get the image
            Part image = request.getPart("user_image"); //in Part we can store image or file
            String image_name = image.getSubmittedFileName();
            
            //save file to a folder, so that we can retrieve it later using the 
            // file will be uploaded into build folder -> web -> img
            // name stored in database
            InputStream is = image.getInputStream();
            byte []imageData = new byte[is.available()];            
            is.read(imageData);
            
            // File.separator is forward slash / or backward slash \, depending upon OS
            String path = request.getRealPath("/") + "img" + File.separator + image_name; //getRealPath will give the path of Web Pages folder
            
            //out.println(path);
            
            FileOutputStream fos= new FileOutputStream(path);
            fos.write(imageData);
            fos.close();
            
            
            //jdbc connectivity
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_practice", "sachin", "sachin");
                
                String q1 = "insert into user(name, email, password, image) values(?, ?, ?, ?)";
                PreparedStatement pstm = con.prepareStatement(q1);
                
                pstm.setString(1, name);
                pstm.setString(2, email);
                pstm.setString(3, password);
                pstm.setString(4, image_name);  //save the name of file in database
                
                pstm.executeUpdate();
                
                out.print("success");
                
            }catch(Exception e){
                e.printStackTrace();
                out.print("fail");
            }
            
            // request.getContextPath() //  /Register
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
