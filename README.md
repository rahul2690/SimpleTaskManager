# SimpleTaskManager
## Simple Full Stack Task Managment Service, allowing user to update task written in Angular and Spring Boot

## Welcome to Task Managment Portal
   Here User can update your tasks

   Getting Started
   1. User can see all Tasks assigned to you.
   2. By Default new tasks created have Status NOT_STARTED and Due date of 3 days
   3. User can Update Title,Description,Status,Priority,Due Date 
   4. User can also set Remind me At date, so tasks will not be shown till Remind me At.
   5. User can search particular Task by id using ID filter.
   6. User can sort and see all Task by Priority Basis.
   7. Tasks are added every 10 Seconds

   Now you can go and looks at your Tasks :)
   
## Project Details
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

 http://machine-ip:8080
 
 http://localhot:8080
