/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.filter;

/**
 *
 * @author sachink1
 */
import java.io.IOException;
import javax.servlet.*;
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Before servlet execution");
        
        chain.doFilter(request, response);  //send request to next resources
        
        System.out.println("Aftet Servlet execution");
    }

    @Override
    public void destroy() {
        
    }
    
}
