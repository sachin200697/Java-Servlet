JSP provides build-in objects that we can use on jsp page:

out.println("<h1>Hello</h1>");  //object of PrintWriter (JspWriter)

request.getParameter("Key");    //object of HttpServletRequest

response.sendRedirect();        //object of HttpServletResponse

config.                         //object of ServletConfig

application                     //object of ServletContext

session.isNew()                 //object of HttpSession
//to check if session is new or not   
session.setAttribute("name", "SK");
//session = request.getSession()   

page                            //current jsp page's object  

exception                       // to print exception message  // Throwable object

pageContext                     //object of PageContext
//it is used to set values in page scope/session scope/application scope, so that we can use these values.
// we can use pageContext or session to set the value at session scope