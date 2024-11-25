# To Do Application

## Overview  
- This is a **To-Do Application** built using **Spring Boot**.  
- The application allows users to manage tasks and user information.  
- Includes CRUD operations for tasks and users, with:  
  - Layered architecture  
  - DTOs for request and response handling  
  - Database integration using **JPA**  

---

## Features  

### Task Management  
-  **Create Task**: Users can create tasks with a title and description.  
-  **Read Task**: Retrieve a list of all tasks or a specific task by its ID.  
-  **Update Task**: Update details of an existing task.  
-  **Delete Task**: Remove a task by its ID.  

### User Management  
-  **Create User**: Register a new user with name, username, email, and password.  
-  **Read User**: Fetch all users or retrieve a specific user by ID.  
-  **Update User**: Modify the details of an existing user.  
-  **Delete User**: Remove a user by their ID.  

---

## Layered Architecture  

-  **Controller Layer**: Handles HTTP requests and responses.  
-  **Service Layer**: Implements business logic.  
-  **Converter Layer**: Converts between DTOs and entity models.  
-  **Repository Layer**: Performs database operations.  
-  **Model Layer**: Represents database tables.  

---

## API Endpoints  

### Task Endpoints  
- **GET /api/v1.0/tasks**: Fetch all tasks.  
- **POST /api/v1.0/tasks**: Create a new task.  
- **PUT /api/v1.0/tasks/{id}**: Update an existing task.  
- **DELETE /api/v1.0/tasks/{id}**: Delete a task by its ID.  

### User Endpoints  
- **GET /api/v1.0/users**: Fetch all users.  
- **POST /api/v1.0/users**: Create a new user.  
- **PUT /api/v1.0/users/{id}**: Update an existing user.  
- **DELETE /api/v1.0/users/{id}**: Delete a user by their ID.  

---

## Technologies Used  

-  **Spring Boot**: Framework for building the application.  
-  **Spring Data JPA**: For ORM and database interaction.  
-  **Lombok**: Simplifies boilerplate code for models.  
-  **PostgreSQL**: Database for development and testing.  
-  **Bean Validation**: Validates incoming request payloads.  
