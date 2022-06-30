## Custom Tag

Package: javax.servlet.jsp.tagext.TagSupport
Interface : Tag(Parent - interface) -> TagSupport(Child - class)


## To create custom tag we need to follow below steps:

1. Create Tag Handler class inside tag package.
    sources -> right click -> new package (tags) -> right click -> new class (MyTagHandler) 

2. Create TLD (Tag Library Descripter) file:
    WEB-INF -> right click -> Tag lib desc(if not found then search in other) -> give name(mylib) -> finish

    Update WEB-INF/tlds/mylib.tld :

    <tag>
      <name>mytag</name>
      <tag-class>tags.MyTagHandler</tag-class>  //this is class name with package
    </tag>

3. User this tag in any .jsp file by taglib directive:
    <%@taglib uri="/WEB-INF/tlds/mylib prefix="t">    
    //here mylib is the name of tag that we define in newtag_library.tld file

    <t:mytag></t:mytag>


## Custom Tag with attributes

Steps:

1. Same - create tag handler class
2. Modified - create TLD file and update the file as below:
    
    <tag>
        <name>printTable</name>
        <tag-class>tags.PrintTableTag</tag-class>
        <attribute>
            <name>number</name>
            <required>true</required>
        </attribute>
        <attribute>
            <name>color</name>         
        </attribute>
    </tag>

3. Same - but provide attribute as well:
    <%@taglib uri="/WEB-INF/tlds/mylib prefix="t">    
    <t:printTable number="5"></t:printTable>
