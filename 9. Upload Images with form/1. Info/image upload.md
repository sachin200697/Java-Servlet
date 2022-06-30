To send images and any other file, we need to use FormData object of js.

And in servlet we need to use below code to get imamge:

import javax.servlet.http.Part;

add a annotation on class to tell that we are handling multip type data(images, text)
@MulitpartConfig            //import javax.servlet.annotation.MultipartConfig;

Part img = req.getPart("user_image");

String img_name = img.getSubmittedFileName();



alter table user add image varchar(100);    //add new column to add image


Ajax Request will be like this now:
We need to add two aditional parameter : 

processData: false,
contentType: false



Note: If we same the file in Servlet using FileOutputStream then file will be upload in the build folder not in the main folder becuase project is created by us so image will not be uploaded into that but build filder is created by servlet and we are writing it using servlet, so file will go inside build folder.

