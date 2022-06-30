Package: javax.servlet

## Inside this package there is an interface Servlet with following methods:

1. public abstract void init(javax.servlet.ServletConfig);
2. public ServletConfig getServletConfig();
3. public void service(javax.servlet.ServletRequst, javax.servlet.ServletResponse);
4. public abstract java.lang.String getServletInfo();
5. public abstract void destroy();

Note: 1, 3 and 5 method are lifecycle method and they will run automatically.
      2, and 4 are non lifecycle methods and will run only when we call them.


## Create Web Project. Structure of the project:
Web Pages -> in this folder craete html pages
Source Package -> make java packages and programs
Libraries -> add external libraries like mysql-connector


## Steps to create servlet:

1. Create a class that implements Servlet interface from javax.servlet package
2. Implement all methods of Servlet. (5 methods mentioned above).
3. Mapping -> 
    Need to do mapping in web.xml (name of web.xml file is DeploymenetDescripter)

    Web Pages -> WEB-INF -> right click -> New -> Standard Deployment Descripter (web.xml). if not find this 
    option then go to others then search web.xml -> next -> finist

    In this new created web.xml file:

    After <web-app ............> tag declare Servlet tag

     <!--Declare servlet-->
    <servlet>
        <!--We can provide any name-->
        <servlet-name>first</servlet-name>
        
        <!--we need to give package name followed with class name in which Servlet was implemented-->
        <servlet-class>com.servlets.FirstServlet</servlet-class>
    </servlet>
    
    <!--Mapping-->
    <servlet-mapping>
        <!--We need to provide same name as proivded above in servlet declaration's servlet-name -->
        <servlet-name>first</servlet-name>
        
        <!--This is imp. Server will identify with the below mentioned url, 
        which name and then which class it needs to run.  localhost:9494/appoication_name/web -->
        <url-pattern>/web</url-pattern>
        
    </servlet-mapping>