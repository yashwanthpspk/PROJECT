# User Management System

A simple Spring Boot web application that allows users to submit their details through a form and stores them in a MySQL database.

## Prerequisites

- Java 21 or later
- Maven 3.6.3 or later
- MySQL Server 8.0 or later

## Setup Instructions

1. **Database Setup**
   - Install MySQL if you haven't already
   - Create a new database named `userdb`
   - Update the database credentials in `src/main/resources/application.properties` if needed:
     ```
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

2. **Build the Application**
   ```bash
   ./mvnw clean install
   ```

3. **Run the Application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the Application**
   - Open your web browser and go to: http://localhost:8080/

## Features

- Add new users with name, email, and phone number
- Form validation (client-side and server-side)
- View all registered users
- Responsive design that works on mobile and desktop

## Project Structure

- `src/main/java/com/springboottomcat/simpleproject/`
  - `controller/` - Web controllers
  - `model/` - Entity classes
  - `repository/` - Data access layer
  - `service/` - Business logic
  - `dto/` - Data Transfer Objects
  - `SimpleprojectApplication.java` - Main application class

- `src/main/resources/`
  - `templates/` - Thymeleaf templates
  - `application.properties` - Application configuration

## Technologies Used

- Spring Boot 3.5.5
- Spring Data JPA
- MySQL
- Thymeleaf
- Bootstrap 5.3
- Maven

## License

This project is open source and available under the [MIT License](LICENSE).
