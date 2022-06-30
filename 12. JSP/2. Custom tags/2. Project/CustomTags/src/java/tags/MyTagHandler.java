/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author sachink1
 */
public class MyTagHandler extends TagSupport{
    
    @Override
    public int doStartTag() throws JspException{
        
        try{
            JspWriter out = pageContext.getOut();
            out.println("<h1>This is my coutom tag with h1 heading</h1>");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return SKIP_BODY;   //to not run the body of tag
    }
    
}
