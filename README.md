Test Exercise: Building a Java Spring Boot microservice

Instructions: You are tasked with creating a Java Spring Boot microservice application with the following requirements. You can choose any IDE or tool of your choice.
Project Setup:
•	Create a new Spring Boot project using Spring Initializr or your preferred IDE. Include the necessary dependencies: Spring Boot, Spring Data JPA, PostgreSQL, Spring Boot Test, MapStruct, Liquibase.
Library Record microservice:
•	Define an entity class (e.g., LibraryRecord)
•	Implement a RESTful CRUD API for library records.
o	POST /library-records to create a new library record
o	GET /library-records/{id} to retrieve a library record by ID
o	GET /library-records to retrieve all library records
o	PUT /library-records/{id} to update a library record
o	DELETE /library-records/{id} to delete a library record
•	Use Swagger to document the API
•	Use MapStruct for data mapping.
•	Use Java 17
•	Follow basic clean code principles.
•	Cover changes with unit tests and SpringBootTest integration tests with test coverage of more than 80%.
•	Initialize a Git repository and push your code to a Git hosting platform like GitHub or GitLab.

User microservice (Additional Task):
•	Implement a second microservice for managing user records or a related topic.
•	In the Library Record microservice, use FeignClient to make HTTP requests to the User microservice for user-related operations.
•	Define FeignClient interfaces for communication between the microservices.
•	Implement an API endpoint in the User microservice that can be called from the Library Record microservice, demonstrating the integration.
•	Implement additional API endpoint in Library Record microservice to demonstrate the integration with User microservice

Submission:

•	Once you have completed the exercise, share your Git repository links for both the Library Record microservice and the User microservice with us for review.

•	Provide a brief README.md file in each repository with any specific instructions or information about your implementation.
