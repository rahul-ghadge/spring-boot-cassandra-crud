# spring-boot-cassandra-crud
Spring boot CRUD (Create, Read, Update, Delete) demo application with cassandra DB - 
In this application, we have implemented CRUD (Create, Read, Update, Delete) operations using spring data and cassandra DB.  


## Prerequisites 
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [Cassandra](https://cassandra.apache.org/)


## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)
- cqlsh (Cassandra query language shell) - for monitoring stored data



### Install JDK8
Step 1: Download JDK8 from [JDK site](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

Step 2: Install downloaded executable file.

Step 3: Add JDK8 path as environment variable.



### Setup CQLSH (Cassandra query language shell) - for monitoring stored data
Step 1: **Python2.7** is mandatory for cqlsh to handle user requests. Download Python2.7 from [Python site](https://www.python.org/downloads/release/python-2718/)

Step 2: Install downloaded executable file.

Step 3: Add Python2.7 path as environment variable.




### Setup Cassandra
Step 1: Download the latest version of apache-cassandra-x.xx.x from [Cassandra site](https://cassandra.apache.org/download/)

Step 2: Unzip the compressed zip file using a compression tool to any location. Ex. c:\apache-cassandra-x.xx.x

Step 3: Add c:\apache-cassandra-x.xx.x\bin path as environment variable






## For API document using OpenAPI UI 

> http://localhost:8080/swagger-ui-custom.html



### API Endpoints

- #### Super Hero CRUD Operations
    > **GET Mapping** http://localhost:8080/super-hero  - Get all Super Heroes
    
    > **GET Mapping** http://localhost:8080/super-hero/1  - Get Super Hero by ID
       
    > **POST Mapping** http://localhost:8080/super-hero  - Add new Super Hero in DB  
    
      Request Body  
      ```
        {
            "id": 1,
            "name": "Tony",
            "superName": "Iron Man",
            "profession": "Business",
            "age": 50,            
            "superPowers": {
                "strength": "a lot",
                "durability": "a lot",
                "canFly": true
            }
        }
      ```
    
    > **PUT Mapping** http://localhost:8080/super-hero  - Update existing Super Hero for given ID 
                                                       
      Request Body  
      ```
        {
            "id": 1,
            "name": "Tony",
            "superName": "Iron Man",
            "profession": "Business",
            "age": 50,         
            "superPowers": {
                "strength": "Only if he is in a suit",
                "durability": "a lot",
                "canFly": true
            }
        }
      ```
    
    > **DELETE Mapping** http://localhost:8080/super-hero/1  - Delete Super Hero by ID



### Console Output

![Alt text](https://github.com/rahul-ghadge/spring-boot-cassandra-crud/blob/master/src/main/resources/spring-data-cassandra-output.PNG?raw=true "Spring Data Cassandra output")
