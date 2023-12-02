# The Fodies Express (Online Food Delivery System)
<img src="https://scontent.fnag4-1.fna.fbcdn.net/v/t39.30808-6/327231728_5786631991444916_2751410172400524542_n.png?_nc_cat=100&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=Pi4coVylRn0AX9zx4gV&_nc_ht=scontent.fnag4-1.fna&oh=00_AfCdrC-3-A5XbXxztdZBOMb-WsGTsjvllvGlpN5bJ7Ez8Q&oe=656F42CD">
## Online Food Delivery App strictly followed MVC architecture

 - I developed this REST API for an E-commerce REST API. This API performs all the fundamental CRUD operations of any e-commerce application platform with user validation at every step.

## Module
<img src="https://github.com/sgrprmnk/befitting-advice-51/blob/main/model.png">



## Entity Relationship Diagram

<img src="https://img.seromitschu.repl.co/AnpYz.png">


## Functionality (Swagger UI) 
<a href="https://github.com/sgrprmnk/befitting-advice-51/blob/main/functionalityDocumentation_swagger.pdf">Click Here for functionality details</a>
## Functionality at a glance
-   User can register/login-logout
-   can view all items
-   can view restaurants
-   Find items by category
-   Add to cart/edit into the cart
-   Place Order
-   Get order details
-   Get Bills
<img src="https://github.com/sgrprmnk/befitting-advice-51/blob/main/functionalityAtGlance.png">

## REST API
<a href="https://github.com/sgrprmnk/befitting-advice-51/blob/main/api-docs.pdf">Click Here for api details</a>

## Backend Work
-  Proper Exception Handling
-  Proper Input Validation
-  Data Stored in the database(mySQL)
-  User Authentication of signUp, Login and Logout

## Installation and Run
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per our local database config.
    -   server.port=8888
    -   spring.datasource.url=jdbc:mysql://localhost:3306/emcommarcedb
    -   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    -   spring.datasource.username=**Your UserName**
    -   spring.datasource.password=**YourPassword**
    -   spring.jpa.hibernate.ddl-auto=update
    -   spring.jpa.show-sql=true
    -   spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
    
-to check the swagger http://localhost:8888/swagger-ui/

### App is live on AWS find the link below:
#### http://hoodiefoodie-env.eba-8rymyyiz.ap-south-1.elasticbeanstalk.com/

### It is also live on swagger find the link below:
#### http://hoodiefoodie-env.eba-8rymyyiz.ap-south-1.elasticbeanstalk.com/swagger-ui/

## Tech Stacks
<p>
   <img src="https://img.icons8.com/color/64/000000/java.png"/>
   <img src="https://img.icons8.com/color/48/null/spring-logo.png"/>
   <img src="https://github.com/efat56/striped-pear-8171/blob/main/Images/hibernate_logo_icon_171004.png" />
   <img src="https://img.icons8.com/ios/50/null/mysql-logo.png"/>
</p>

-   Java Core
-   Spring Boot
-   Spring Data JPA
-   JPQL
-   MySQL
-   Hibernate
-   Swagger
-   Lombok

## Unique Features
- Used Id as a String and unique in every cases
- Can be Multilanguage(Regional Language)



