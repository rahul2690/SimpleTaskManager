# SimpleTaskManager Backend

Welcome to TaskManager Backend

Backend Is Built Using
 1. Spring Boot
 2. PostgresDB
 3. Spring Boot CRUD repository(it handles transactions by @Transaction AOP default on its Methods)
 3. Java 8
 
 Improvements that can be done 
 1. Use of Swagger(Open Api Spec) to Automate creation of Initial Backend project Stucture
 2. It will create Dtos,RestController and you need to Write FacadeImplementations and Converters for Model Objects
 3. More ITs and UTS
 4. DAO could be used but using Spring Boot's Crud Repository so did not used
 5. Creating Task automatically.
 6. Here I am using Simple Spring Provided Scheduler to Create Task ,it could be made more complex in micro service world

 Assumptions
 1. You have JAVA 8 running
 2. postgesDB Running locally at 5432 port, 
     User -postgres
     Password -postgres
