/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.helper;

/**
 *
 * @author sachink1
 */
import java.sql.*;
public class ConnectionProvider {
    private static Connection c;
    
    public static Connection getConnection(){
        try{
            if(c==null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/techblog";
                String user = "sachin";
                String password = "sachin";
                c = DriverManager.getConnection(url, user, password);

                if(c.isClosed()){
                    return null;
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return c;
    }
    
}
