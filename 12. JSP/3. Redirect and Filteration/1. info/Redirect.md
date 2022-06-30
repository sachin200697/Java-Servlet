## Redirect:

Suppose there are three pages: page1.jsp, page2.jsp, page3.jsp

On page one there is a link to click that will send to page2.jsp.

One page2.jsp, after execution of the content, instead of staying on this page we can redirect it to 
another page (page3.jsp) without user clicking.

## How:

<%
    response.sendRedirect("page3.jsp");
%>



## Filter:
       _________                                  ________              _________
      |         |                                |        |            |         |
      |  Client | ----------- resuest  ------->  | Filter |  --------> | Servlet |
      |         | <---------- response <-------  |        |  <-------- |         |
      |_________|                                |________|            |_________|

Filter are used to validate something that comming from client side and also to set cookies if rending 
response from server to client.

## Filter API:


1. Filter  : interface and Package javax.servlet
   Methods: inti()  -> run when filter object is created(child class)
            doFilter() -> have two part of code : one will run when request goes (clint -> servlet) and     
                          second will run when response goes (servlet->client).
            destroy() ->  when filter object about to destroy.

   These three methods are life cycle method.            

2. FilterChain : interface - to send current request to next resource or filter
3. FilterConfig : to pickup some config from web.xml


## How to apply filter

1. Create a class that implements Filter interface and implement all methods of Filter
2. Configure web.xml to map the filter
    <!--Filteration-->
    <filter>
        <filter-name>filter1</filter-name>
        <filter-class>com.filter.MyFilter</filter-class>
    </filter>
    
    <!--Maping of filter-->
    <filter-mapping>
        <filter-name>filter1</filter-name>
        <url-pattern>/servlet1</url-pattern>    
        //this is user pattern of the filter before which we want to exucute the filter
        //we can give one or more url-pattern
        // we can use /* url-pattern to apply filters for every servlet
    </filter-mapping>
