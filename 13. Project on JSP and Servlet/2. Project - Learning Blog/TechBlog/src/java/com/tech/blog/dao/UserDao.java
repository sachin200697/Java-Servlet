/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dao;

/**
 *
 * @author sachink1
 */

import com.tech.blog.entities.User;
import java.sql.*;
public class UserDao {
    private Connection con;
    private boolean isUpdated = false;

    public UserDao(Connection con) {
        this.con = con;
    }
    
    public boolean saveUser(User u){
        
        try{
            String s = "insert into user(name, email, password, gender, about) values(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(s);
            
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getGender());
            ps.setString(5, u.getAbout());
            
            ps.executeUpdate();
            
            isUpdated = true;
            
        }catch(Exception e){
            
        }
        
        return isUpdated;
        
    }
    
    //get user details but user email and password
    public User getUserByEmailAndPassword(String email, String password){
        User user = null;
        try{
            String q = "Select * from user where email = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet result =   ps.executeQuery();
            
            if(result.next()){
                user = new User();
                
                String name = result.getString("name");
                user.setName(name);
                
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setGender(result.getString("gender"));
                user.setAbout(result.getString("about"));
                user.setDateTime(result.getTimestamp("rdate"));
                user.setProfile(result.getString("profile"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return user;
    }
    
    public boolean updateUser(User user){
        boolean isUpdated = false;
        try{
            String query = "Update user set name = ?, email = ?, password = ?, gender = ?, about = ?, profile = ? where id = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getGender()); 
            ps.setString(5, user.getAbout());
            ps.setString(6, user.getProfile());
            ps.setInt(7, user.getId());
            
            ps.executeUpdate();
            isUpdated = true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return isUpdated;
    }
    
    public User getUserByUserId(int userid){
        User user = null;
        try{
            String q = "select * from user where id = ?";
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.setInt(1, userid);
            
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                user = new User();
                
                String name = result.getString("name");
                user.setName(name);
                
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setGender(result.getString("gender"));
                user.setAbout(result.getString("about"));
                user.setDateTime(result.getTimestamp("rdate"));
                user.setProfile(result.getString("profile"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return user;
    }
    
}
