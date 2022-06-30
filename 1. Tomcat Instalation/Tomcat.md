https://tomcat.apache.org/download-90.cgi

Download this file: 32-bit/64-bit Windows Service Installer (pgp, sha512)

## Installation: 

1. While installing we need to make sure that we need to provide a port on which nothing is running already to run the tomcat server without any issue.

To check if anything is running on some port or not:
#> netstat -a -n -o | find "9494"

9494 is the port no, if some above command give a list of processes running on the port then don't use it.
But if nothing is on this port then we can use it to running the server.

2. Give a user name like : sachin and password

3. In Roles: we need to add another role(manager-script), change the Roles like below:
    admin-gui,manager-gui,manager-script

## validation 

To check it has intalled successfully. Chose to launh the server(at the time of instalation)
Then in browser: localhost:9494     //9494 is the port that we provide. it should show the homepage of tomcat server.

On the open page we can check status -> then give username and password that we set in installation process.


5. Now we need to give permissions to Tomcat.
    program files -> Apache software foundation -> on Tomcat folder -> right click -> properties -> security -> give all permissions to user and admin and for others as well(it may possible that permissions already granted). 
    -> if user is not present in the security tab (SYSTEM, administrator and local services will be already there) then add user(like sachink1 for me add (sachink1@amdocs.com))

6. To Start/Stop server:
    -> press window -> search tomcat -> open Monitor Tomcat -> Start/Stop    


To Stop tomcat forcefully:
1. n order to find tomcat PID run:
ps -ef | grep tomcat

2. then use this command:

3. kill -9 PID

Or in one command:
kill -9 $(ps -ef | grep tomcat | grep -v "grep" | awk '{print $2}')    