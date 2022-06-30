package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDao {
    private Connection con;

    public LikeDao(Connection con) {
        this.con = con;
    }
    
    public boolean insertLike(int pid, int uid){
        boolean isInserted = false;
        try{
            String q = "insert into likes(pid, uid) values(?, ?)";
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.setInt(1, pid);
            pstm.setInt(2, uid);
            pstm.executeUpdate();
            
            isInserted = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return isInserted;
    }
    
    public int countLikeOnPost(int pid){
        int count=0;
        try{
            String q = "Select count(*) from likes where pid = ?";
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.setInt(1, pid);            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);   //we can also give column name as "count(*)"
                //we can check the column name by executing the query 
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }
    
    public boolean isLikedByUser(int pid, int uid){
        boolean isLiked = false;
        try{
            String q = "insert into likes(pid, uid) values(?, ?)";
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.setInt(1, pid);
            pstm.setInt(2, uid);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                isLiked = true;
            }
        }catch(Exception e){
            
        }
        return isLiked;
    }
    
    
    public boolean deleteLike(int pid, int uid){
        boolean isDeleted = false;
        try{
            String q = "delete from likes where pid = ? and uid = ?";
            PreparedStatement pstm = con.prepareStatement(q);
            pstm.setInt(1, pid);
            pstm.setInt(2, uid);
            pstm.executeUpdate();
            
            isDeleted = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return isDeleted;
    }
    
}
