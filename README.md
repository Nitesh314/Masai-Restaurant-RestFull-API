# The Fodie Express - Online Food Delivery App

The Fodie Express is an online food delivery app designed to form a bridge between customers and restaurants. It addresses the challenge of delivering food to the customer's doorstep, featuring a fully functional application built with the MVC design pattern in Spring Boot. The project includes proper exception handling, input validation, user authentication, and more.

## Features

- User Registration, Login, and Logout
- View all available items
- View restaurants
- Find items by category
- Add to cart and edit cart
- Place orders
- Get order details
- Get bills

## Technologies Used

- Java Core
- Spring Boot
- Spring Data JPA
- JPQL
- MySQL
- Hibernate
- Swagger
- Lombok

## Getting Started

1. Clone this repository.
2. Update the database configuration in `application.properties`.
   - Update port number, username, and password as per your local database config.

```properties
server.port=8888
spring.datasource.url=jdbc:mysql://localhost:3306/emcommarcedb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=YourUserName
spring.datasource.password=YourPassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER
