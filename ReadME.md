#  Git Hub Issues

Git Hub Issue service is a spring boot application build on Java 8, using gradle as its build tool

  Prerequisite:
  
     - JDK 1.8
     - access to localhost:8080
     
  ## Build  and run Locally
  Unix -
  ```$bash
       ./gradlew clean build
       ./gradlew bootRun
  ```
  
  Windows
  ```$bash
         gradlew clean build
         gradlew bootRun
   ```
   
   ## Api Endpoint 
   
   ```$json
   
   POST: http://localhost:8080/
   Payload: 
   {
   	"repositories":[
   		"octocat/Hello-World",
       "spring-projects/spring-data-examples"
   	]
   }
    
```