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
- cqlsh (cassandra query language shell) - for monitoring stored data



###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-cassandra-crud**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-spring-boot-cassandra-crud/target/spring-boot-cassandra-crud-0.0.1-SNAPSHOT.jar```**

Or
> run main method from `SpringBootCassandraCrudApplication.java` as spring boot application.  


||
|  ---------    |
| **_Note_** : In `SpringBootCassandraCrudApplication.java` class we have autowired SuperHero repository. <br/>If there is no record present in DB for SuperHero model class, static data is getting inserted in DB from `HelperUtil.java` class when we are starting the app for the first time.| 


---
### For API document using OpenAPI UI 

> **http://localhost:8080/swagger-ui-custom.html**

![Swagger Documentation](https://github.com/rahul-ghadge/spring-boot-cassandra-crud/blob/master/src/main/resources/static/spring-boot-cassandra-crud-Swagger.PNG?raw=true "Spring Data Cassandra Swagger")

---

### Install JDK8
Step 1: Download JDK8 from [JDK site](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).  
Step 2: Install downloaded an executable file.  
Step 3: Add JDK8 path as environment variable.  



### Setup cqlsh (cassandra query language shell) - for monitoring stored data
Step 1: **Python2.7** is mandatory for cqlsh to handle user requests. Download Python2.7 from [Python site](https://www.python.org/downloads/release/python-2718/).  
Step 2: Install downloaded an executable file.  
Step 3: Add Python2.7 path as environment variable.  




### Setup Cassandra
Step 1: Download the latest version of apache-cassandra-x.xx.x from [Cassandra site](https://cassandra.apache.org/download/).  
Step 2: Unzip the compressed zip file using a compression tool to any location. Ex. c:\apache-cassandra-x.xx.x  
Step 3: Add c:\apache-cassandra-x.xx.x\bin path as environment variable.  


---

#### Start the Cassandra and cqlsh 

##### Start Cassandra
Make sure bin path is set for cassandra in environment variable.  
> `cassandra`

If no error on the console means cassandra is started and running.


##### Start cqlsh 
Make sure path is set for the python in environment variable.  
> `cqlsh`

If no error on the console means **cqlsh** is connected.


### Code Snippets
1. #### Maven Dependencies
    Need to add below dependency to enable cassandra in **pom.xml**.    
    ```
	<dependency>
	    <groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-cassandra</artifactId>
	</dependency>
   		
   <!-- For Boilerplate code (Getters/Setters/Constructors) -->
   <dependency>
   		<groupId>org.projectlombok</groupId>
   		<artifactId>lombok</artifactId>
   		<optional>true</optional>
   </dependency>
    ```
    
    For API documentation using swagger and OpenApi UI add below dependency.
	```
	<dependency>
	    <groupId>org.springdoc</groupId>
		<artifactId>springdoc-openapi-ui</artifactId>
		<version>1.4.4</version>
	</dependency>
	```
   
2. #### Properties file
     Placed properties in **application.yml** file related to cassandra which we are reading in **CassandraConfig.java** class
     and configuring cassandra connection for Cassandra.  
     API documentation related swagger UI path is also placed here which will enable Swagger API Doc on same path.  
     **src/main/resources/application.yml**     
     ```
     spring:
       data:
         cassandra:
           contact-points: localhost
           port: 9042
           keyspace-name: simple_crud
           #username: cassandra
           #password: cassandra
           #schema-act: create_if_not_exists
     
     springdoc:
       version: 1.0.0
       swagger-ui:
         path: /swagger-ui-custom.html
     ```


3. #### Model class
    Below are the model classes which we will store in cassandra and perform CRUD operations.  
    **com.arya.cassandra.model.SuperHero.java**  
    **com.arya.cassandra.model.SuperPowers.java**  
    ```
    @Data
    @Builder
    @Table("super_hero")
    public class SuperHero implements Serializable {    
        @PrimaryKey
        private Long id;    
        private String name;    
        @Column("super_name")
        private String superName;    
        private String profession;    
        private int age;    
        @Column("super_powers")
        private SuperPowers superPowers;    
    }
   
   
   @Data
   @Builder
   @UserDefinedType("super_powers")
   public class SuperPowers implements Serializable {   
       private String strength;   
       private String durability;   
       private boolean canFly;
   }
    ```


4. #### Cassandra Configuration
   This is the most important class in this application, where all cassandra related configuration is placed 
   and using this class we are connecting to cassandra and creating **KEYSPACE** and **TABLES** also while starting the application.

   ```
   import org.springframework.beans.factory.annotation.Value;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
   import org.springframework.data.cassandra.config.SchemaAction;
   import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
   import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
   import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
   
   import java.util.Collections;
   import java.util.List;
   
   @Configuration
   public class CassandraConfig extends AbstractCassandraConfiguration {
   
       @Value("${spring.data.cassandra.keyspace-name: simple_crud}")
       private String KEYSPACE;
   
       @Value("${spring.data.cassandra.contact-points: localhost}")
       private String CONTACT_POINT;
   
       @Value("${spring.data.cassandra.port: 9042}")
       private int PORT;
   
   
       @Override
       public String getContactPoints() {
           return CONTACT_POINT;
       }
   
       @Override
       protected int getPort() {
           return PORT;
       }
   
       @Override
       public SchemaAction getSchemaAction() {
           return SchemaAction.CREATE_IF_NOT_EXISTS;
       }
   
       @Override
       protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
           return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(KEYSPACE)
                   .ifNotExists()
                   .with(KeyspaceOption.DURABLE_WRITES, true)
                   .withSimpleReplication(3L));
       }
   
       @Override
       protected String getLocalDataCenter() {
           return "datacenter1";
       }
   
       //@Override
       //protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
       //    return Collections.singletonList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
       //}
   
       @Override
       protected String getKeyspaceName() {
           return KEYSPACE;
       }
      
       @Override
       public String[] getEntityBasePackages() {
           return new String[] {"com.arya.cassandra.model"};
       }   
   }
   ```
   
   
   
5. #### CRUD operation for Super Heroes

    In **com.arya.cassandra.controller.SuperHeroController.java** class, 
    we have exposed 5 endpoints for basic CRUD operations
    - GET All Super Heroes
    - GET by ID
    - POST to store Super Hero in DB
    - PUT to update Super Hero
    - DELETE by ID
    
    ```
    @RestController
    @RequestMapping("/super-heroes")
    public class SuperHeroController {
        
        @GetMapping("/save")
        public ResponseEntity<List<SuperHero>> save();
   
        @GetMapping
        public ResponseEntity<List<SuperHero>> findAll();
    
        @GetMapping("/{id}")
        public ResponseEntity<SuperHero> findById(@PathVariable String id);
    
        @PostMapping
        public ResponseEntity<SuperHero> save(@RequestBody SuperHero superHero);
    
        @PutMapping
        public ResponseEntity<SuperHero> update(@RequestBody SuperHero superHero);
    
        @DeleteMapping("/{id}")
        public ResponseEntity<SuperHero> delete(@PathVariable String id);
    }
    ```
   
    In **com.arya.cassandra.repository.SuperHeroRepository.java**, we are extending `CassandraRepository<Class, ID>` interface which enables CRUD related methods.
    ```
    @Repository
    public interface SuperHeroRepository extends CassandraRepository<SuperHero, Long> {
    }
    ```
   
   In **com.arya.cassandra.service.impl.SuperHeroServiceImpl.java**, we are autowiring above interface using `@Autowired` annotation and doing CRUD operation.


6. #### Query operation for SuperHero
   In **com.arya.cassandra.controller.SuperHeroQueryController.java** class Cassandra queries API Endpoints are placed.
   we are autowiring SuperHeroQueryService interface using `@Autowired` annotation and reaching to Service layer.  
   In **com.arya.cassandra.service.impl.SuperHeroQueryServiceImpl.java**, 
   we are autowiring SuperHeroQueryRepository interface using `@Autowired` annotation and reaching to DAO layer.
   In **com.arya.cassandra.repository.impl.SuperHeroQueryRepositoryImpl.java**, 
   we are autowiring `CassandraOperations` interface which enables CRUD related methods.
   ```
   @Autowired
   private CassandraOperations cassandraTemplate;
   ``` 
    


<br/>

### API Endpoints

- #### Super Hero CRUD Operations
    > **GET Mapping** http://localhost:8080/super-heroes  - Get all Super Heroes
    
    > **GET Mapping** http://localhost:8080/super-heroes/1  - Get Super Hero by ID
       
    > **POST Mapping** http://localhost:8080/super-heroes  - Add new Super Hero in DB  
    
     Request Body  
     ```
     {
         "id": 1,
         "name": "Tony",
         "superName": "Iron Man",
         "profession": "Business",
         "age": 50,            
         "superPowers": {
             "strength": "Suit",
             "durability": "Month",
             "canFly": true
         }
     }
     ```
    
    > **PUT Mapping** http://localhost:8080/super-heroes  - Update existing Super Hero for given ID 
    
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
             "durability": "Month",
             "canFly": true
         }
     }
     ```
    
    > **DELETE Mapping** http://localhost:8080/super-heroes/1  - Delete Super Hero by ID



### Output

![Alt text](https://github.com/rahul-ghadge/spring-boot-cassandra-crud/blob/master/src/main/resources/static/spring-data-cassandra-output.PNG?raw=true "Spring Data Cassandra output")
