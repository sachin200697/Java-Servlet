/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dao;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sachink1
 */
public class PostDao {
    private Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Category> getAllCategories(){
        ArrayList<Category> list = new ArrayList();
        
        try{
            String q = "select * from categories";
            Statement stm= con.createStatement();
            ResultSet rs = stm.executeQuery(q);
            
            while(rs.next()){
                int cid = rs.getInt("cid");
                String name = rs.getString("name");
                String description = rs.getString("description");
                System.out.println(name + description);
                list.add(new Category(cid, name, description));
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public boolean savePost(Post p){
        boolean isSaved = false;
        try{
            String q = "insert into posts(title, content, code, pic, catid, userid) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(q);
            
            pstm.setString(1, p.getTitle());
            pstm.setString(2, p.getContent());
            pstm.setString(3, p.getCode());
            pstm.setString(4, p.getPic());
            pstm.setInt(5, p.getCatid());
            pstm.setInt(6, p.getUserid());
            
            pstm.executeUpdate();
            
            isSaved = true;
            
        }catch(Exception e){
            e.printStackTrace();
        }       
        
        return isSaved;
    }
    
    public List<Post> getAllPosts(){
        List<Post> list = new ArrayList();
        try{
            String q = "select * from posts";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(q);
            while(rs.next()){
                Post p = new Post(rs.getInt("pid"), rs.getString("title"), rs.getString("content"),
                rs.getString("code"), rs.getString("pic"), rs.getTimestamp("date"), rs.getInt("catid"),
                rs.getInt("userid"));
                
                list.add(p);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    
    public List<Post> getPostByCatId(int cid){
        List<Post> list = new ArrayList();
        try{
            String q = "select * from posts where catid = ?";
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.setInt(1, cid);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Post p = new Post(rs.getInt("pid"), rs.getString("title"), rs.getString("content"),
                rs.getString("code"), rs.getString("pic"), rs.getTimestamp("date"), rs.getInt("catid"),
                rs.getInt("userid"));
                
                list.add(p);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
    
    public Post getPostByPostId(int pid){
        Post p = null;
        try{
            String q = "select * from posts where pid = ?";
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.setInt(1, pid);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                p = new Post(rs.getInt("pid"), rs.getString("title"), rs.getString("content"),
                rs.getString("code"), rs.getString("pic"), rs.getTimestamp("date"), rs.getInt("catid"),
                rs.getInt("userid"));                              
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return p;
    }
    
}
