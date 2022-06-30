RequestDispatcher: This is an interface that is used for two purposes: 

1. This is an interface that forward the request to an another Servlet using forward() method.

For example if we have to servlet =>
    1. For form validation 
    2. For Save data to mysql and then send response back to client

So in this case if a user fill a form and submit it, then we want that first data should validate and then 
data should go to database. 

To forward the request to secnod servlet we need to use RequestDispatcher interface.

2. To include the response of the second servlet into fisrt servlet using include() method.

