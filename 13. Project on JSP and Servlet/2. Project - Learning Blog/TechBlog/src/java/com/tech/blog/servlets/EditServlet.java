/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tech.blog.servlets;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author sachink1
 */
@MultipartConfig
public class EditServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            
            //taking form data
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String about = request.getParameter("about");
            System.out.println(name+ email+password+about);
            Part p = null;
            try{
                p = request.getPart("image");
            }catch(Exception e){
                
            }
            
            //get image name 
            
            String imageName =null;
            if(p!=null){
                imageName = p.getSubmittedFileName();            
            }
            
            //get user from session
            HttpSession hs = request.getSession();
            User user = (User) hs.getAttribute("user");
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            String oldFileName = user.getProfile();
            if(imageName!=null)
            {
                user.setProfile(imageName);            
            }
            
            user.setAbout(about);
            
            //update the user
            UserDao dao = new UserDao(ConnectionProvider.getConnection());
            boolean isUpdated = dao.updateUser(user);
            
            //check if successfully updated or not
            if(isUpdated && p!=null){
                out.println("Success");
                
                //delete the old profile pic
                
                if(!oldFileName.equals("default.png")){
                    String oldFilePath = request.getRealPath("/") + "pics" + File.separator + oldFileName;
                    Helper.deleteFile(oldFilePath);
                }
                

                //save new profile pic
                InputStream is = p.getInputStream();                
                String path = request.getRealPath("/") + "pics" + File.separator + imageName; //new file path
                boolean isSaved = Helper.saveFile(is, path);
                if(isSaved){
                    Message m = new Message("Profile updated successfully!", "success", "alert-success");
                    hs.setAttribute("msg", m);
                }else{
                    Message m = new Message("Something went wrong!1111", "error", "alert-danger");
                    hs.setAttribute("msg", m);
                }
            }else{
                out.println("Failed");
                Message m = new Message("Something went wrong!", "error", "alert-danger");
                hs.setAttribute("msg", m);
            }
            
            response.sendRedirect("profile.jsp");
            
            out.println("<body>");
            out.println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
