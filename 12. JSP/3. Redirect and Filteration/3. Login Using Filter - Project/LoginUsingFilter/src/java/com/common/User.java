/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.common;

/**
 *
 * @author sachink1
 */
public class User {
    private String username, password;
    
    public User(String username, String password){
        this.username=username;
        this.password=password;
    }
    
    public String getUserName(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setUserName(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
