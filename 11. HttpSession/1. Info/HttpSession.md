## HttpSession: When a client sent a request then a HttpSession object is created with the client id.
             In this object we can store the info and different servlet can access it.

## HttpSession can end only in three conditions:
1. Time expired for session
2. Client close the browser
3. Invalidate the session implecitely(by developer)

## Structure:
Package: javax.servlet.http
Interface: HttpSession

## HttpSession methods:

HttpSession hs = req.getSession();  // req = HttpServletRequest object
//we can pass true or false in getSession method 
//true = to create new session
//false = to get old session

1. hs.setAttribute(key, value)    //key = string , value = any object
2. hs.getAttribute(key)   //will return object
3. hs.removeAttribute(key)
4. hs.invalidate()    //to expire the session //will remove all attributes
5. hs.getId()   //to get the session id to check it is pervious user or new user.