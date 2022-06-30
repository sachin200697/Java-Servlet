Parameters: Provided by user or web.xml to configure the web.
            Form data provided by user is also known as parameters.

We can not modify the parameters, only can get the value and use it.

var value = req.getParameter("name_of_parameter");


Attributes: These values are set by a servlet for another servlet. A servlet can set, get and remove the
            value of attribute.
To set an attribute two things required: key and Object.
req.setAttribute(String key, Object obj);
Ex:
    req.setAttribute("user", user);  
    User u = (User)req.getAttribute("user");    //typecast Object to User
    req.removeAttribute("user");



