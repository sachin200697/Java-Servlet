
Stateless: Not remembering the state. Every request treated as new request.

Problem: Suppose there are three things:

1. index.html : Have form from which sending the name of user.
2. Servlet1 : Fetch the user name using getParameter, Show the user name and also provide a like to go to 
              Servlet2
3. Servlet2 : Try to getch user name and show the name.

for the flow:
index.html -> Servlet1 -> Send response back to client with a link to go to servlet2 -> Click link -> Servlet2
-> But now Servlet2 can not get the name of user by using getParameter( to do this either we need to use ResuestDispatcher or need to provide two links on the index.htmt, one for servlet1 and secnod for servlet2)


To resolve this issue, we use session tracking tech.

## Session Tracking Techniques:

1. Cookies
2. Hidden Form Field
3. URL Rewriting 
4. HttpSession


## 1. Cookie

Package: javax.servlet.http 
Class: Cookie

To make a Cookie:     Cookie c = new Cookie("key", "value");
Then add cookie to response:     res.addCookie(c);
To get the value:     Cookie [] arr = req.getCookies(); //return null or array of cookies 

for a single Cookie c:   String key = c.getName();
                         String value = c.getValue();

## Limitations of Cookie                         

1. Can store only text data. Not images and videos.
2. Can store only a singe word. Space is not allowed so it can not store a sentence with spaces.