# SimpleTaskManager
Simple Full Stack Task Managment Service, allowing user to update task written in Angular and Spring Boot

Read Me

This is simple Task Managment Project
It uses postgresDB , and assumes it is 
  Running locally at 5432 port, 
  User -postgres
  Password -postgres

 Backend Is Built Using
 1. Spring Boot
 2. PostgresDB
 3. Spring Boot CRUD repository(it handles transactions by @Transaction AOP default on its Methods)
 3. Java 8

 FrontEnd is Built using
 1. Angular 5
 2. ngrx/store , ngrx/effects
 3. VMware Clarity directives and components

 To Build project Run
    cd <root-dir>
    mvn clean install -DskipTests

  To run
    mvn spring-boot :run
    Alternatively you can run it as
    java -jar <path-to-backend-target-folder>\task-manager-snapshot-<verison>.jar

 Application will run at

 http://<machine-ip>:8080
 http://localhot:8080
