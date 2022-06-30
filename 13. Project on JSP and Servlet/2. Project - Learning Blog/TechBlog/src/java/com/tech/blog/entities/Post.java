/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.entities;

import java.sql.Timestamp;

/**
 *
 * @author sachink1
 */
public class Post {
    private int pid, catid, userid;
    String title, content, code, pic;
    private Timestamp date;

    public Post(int pid, String title, String content, String code, String pic, Timestamp date, int catid, int userid) {
        this.pid = pid;
        this.catid = catid;
        this.title = title;
        this.content = content;
        this.code = code;
        this.pic = pic;
        this.date = date;
        this.userid = userid;
    }

    public Post(String title, String content, String code, String pic, Timestamp date, int catid, int userid) {
        this.catid = catid;
        this.title = title;
        this.content = content;
        this.code = code;
        this.pic = pic;
        this.date = date;
        this.userid = userid;
    }

    public Post() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }        
    
}
