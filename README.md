# User Registration Rest API
This API is designed to support the new user registration system for the new electric system.

## Technical details
* This service is built using Spring Boot and JDK 11.
* There is user data pre-populated in the system, two users with surname `Scott` available for query.
* A RESTful API is also available to add more users to the system.
* A REESTful API is also available for listing all the users in the system. For detailed list of API's available and there usage a swagger ui is hosted.

## Usage

### Build package or Build docker image
`./mvnw package`

or

` ./mvnw spring-boot:build-image`

### Run the test
`./mvnw -Dtest=RegistrationApplicationTests test`

### Run the app using maven or docker run
`./mvnw spring-boot:run`

or 

` docker run -p 8080:8080  docker.io/library/registration:0.1`

### Rest API Reference
Swagger ui is hosted at `http://localhost:8080/swagger-ui.html` which has elaborate documentation of the RESTful API's available and there usage.



