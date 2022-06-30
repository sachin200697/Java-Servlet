/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.*;

/**
 *
 * @author sachink1
 */
public class PrintTableTag extends TagSupport{
    public int number;
    
    //it will be called automatically and number will set with the value provided in 
    // attribute of tag in jsp page
    public void setNumber(int n){
        this.number = n;
    }
    
    public String color;
    public void setColor(String color){
        this.color=color;
    }
    
    public int doStartTag() throws JspException{
        try{
            JspWriter out= pageContext.getOut();
        
            out.println("<div style='color: " + color + " '>");
            for(int i=1;i<=10;i++){ 
                out.println("<br>");
                out.println(i*number);
            }
            out.println("</div>");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return SKIP_BODY;
    }
}
