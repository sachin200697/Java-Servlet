By defalut if a client request without specifying any file name then index.html will be serve. But if we want 
that if someone ask for home page(only url not the file name) then our home.html(or any other name except index) then we can configure it using welcome-file-list tag.


in web.xml file:
-----------------

<welcome-file-list>
    <!-- first it will check for home.html -->
    <welcome-file>home.html</welcome-file>

    <!-- if home.html not found then it will serach for default.html and will send it  -->
    <welcome-file>default.html</welcome-file>
</welcome-file-list>