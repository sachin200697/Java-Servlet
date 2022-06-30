URL Rewriting: Modify url to send extra into. We can also handle staleless problem using URL Rewriting.

URL:    https://www.blog.com/servlet1/

After URL Rewriting:  https://www.blog.com/servlet1?name=sachin&age=21

servlet1 can access name and age using req.getParameter("name") and req.getParameter("age")




## Hidden Form Filed:
We can also handle staleless problem using Hidden field as well.