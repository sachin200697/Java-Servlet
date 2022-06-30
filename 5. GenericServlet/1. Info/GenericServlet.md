## GerericServlet

GenericServlet has already implemented Servlet interface and has defined the body of 4 methods out of 5 methods. So instead of implementing the Servlet interface it is simple to extends GerericServlet class to create servlet.


GenericServlet does not define body for 'service' (means it is still abstract) method, so we need to define it.  

We can create more then one servlet and we need to define servlet and do mapping  for every servlet in web.xml file.

## HttpServlet

This class present in javax.servlet.http package and extends GerericServlet. Becuase GenericServlet class does
not handle get and put requests becuase it does not have http related functionality. So this new class includes the http features that helps to handle requests like:
get: doGEt()
post: doPost()
put: doPut()