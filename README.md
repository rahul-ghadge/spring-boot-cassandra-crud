# com.arya.cassandra
Spring boot CRUD (Create, Read, Update, Delete) demo application with cassandra DB



### API Endpoints

- #### Super Hero CRUD Operations
    > **GET Mapping** http://localhost:8080/super-hero  - Get all Super Heroes
    
    > **GET Mapping** http://localhost:8080/super-hero/1  - Get Super Hero by ID
       
    > **POST Mapping** http://localhost:8080/super-hero  - Add new Super Hero in DB  
    
      Request Body  
      ```
        {
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
            "id": "1"
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

