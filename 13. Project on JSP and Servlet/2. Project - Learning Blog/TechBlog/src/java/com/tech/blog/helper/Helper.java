/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author sachink1
 */
public class Helper {
    public static boolean deleteFile(String path){
        boolean isDeleted = false;
        try{
            File f = new File(path);
            isDeleted = f.delete();
        }catch(Exception e){
            e.printStackTrace();
        }
        return isDeleted;
    }
    
    public static boolean saveFile(InputStream is, String path){
        boolean isSaved = false;
        try{
            byte[] imgData = new byte[is.available()];
            is.read(imgData);                        
            FileOutputStream fos = new FileOutputStream(path);            
            fos.write(imgData);
            fos.flush();
            fos.close();
            
            isSaved = true;
        }catch(Exception e){
            
        }
        
        return isSaved;
    }
    
}
