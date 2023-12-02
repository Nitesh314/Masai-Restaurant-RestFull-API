# The Fodies Express (Online Food Delivery System)
<img src="https://scontent.fnag4-1.fna.fbcdn.net/v/t39.30808-6/327231728_5786631991444916_2751410172400524542_n.png?_nc_cat=100&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=Pi4coVylRn0AX9zx4gV&_nc_ht=scontent.fnag4-1.fna&oh=00_AfCdrC-3-A5XbXxztdZBOMb-WsGTsjvllvGlpN5bJ7Ez8Q&oe=656F42CD">
## Online Food Delivery App strictly followed MVC architecture

 - I developed this REST API for an E-commerce REST API. This API performs all the fundamental CRUD operations of any e-commerce application platform with user validation at every step.

## Functionality at a glance
-   User can register/login-logout
-   can view all items
-   can view restaurants
-   Find items by category
-   Add to cart/edit into the cart
-   Place Order
-   Get order details
-   Get Bills

## Technology used  
- Java
- MySQL
- Spring Boot
- Spring data JPA
- RESTful api
- Hibernate
- Swagger
- Lombok
- Maven
- Postman
- Spring tool suite eclipse
- Git & GitHub
## Lessons Learned
- Gain excessive knowledge on application of Java, MySQL and SpringBoot.
- Gain knowledge on creating RESTful API.
- Enjoyed the process of learning and creating the application.

## Backend Work
-  Proper Exception Handling
-  Proper Input Validation
-  Data Stored in the database(MySQL)
-  User Authentication of signup, Login, and Logout

## Overview of Our work
## Er Diagram
<img src="https://img.seromitschu.repl.co/o7noQ.png" />
## All Modules
All modules of our project
<img src="https://img.seromitschu.repl.co/qiQyq.png"/>
## Restaurant Module
<img src="https://img.seromitschu.repl.co/ca7fg.png"/>
## Customer Module
<img src="https://img.seromitschu.repl.co/5VJNm.png"/>
## Restaurant-Login Module
<img src="https://img.seromitschu.repl.co/mU2sK.png"/>
## Customer-Login Module
<img src="https://img.seromitschu.repl.co/SYsVy.png"/>
## Item Module
<img src="https://img.seromitschu.repl.co/JBVdo.png"/>
## FoodCart Module
<img src="https://img.seromitschu.repl.co/qdBco.png"/>
## OrderDetails Module
<img src="https://img.seromitschu.repl.co/bTwAP.png"/>
## Bill Module
<img src="https://img.seromitschu.repl.co/CU9bh.png"/>

## Installation and Run
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username, and password as per our local database config.
    -   server.port=8585
    -   spring.datasource.url=jdbc:mysql://localhost:3306/emcommarcedb
    -   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    -   spring.datasource.username=**Your UserName**
    -   spring.datasource.password=**YourPassword**
    -   spring.jpa.hibernate.ddl-auto=update
    -   spring.jpa.show-sql=true
    -   spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
    
-to check the swagger http://localhost:8585/swagger-ui/



## Unique Features
- In this application, whenever the user and restaurant perform any action, always they have to use a username. So, first, login or sign up to get the username 
  and then proceed with the task.




