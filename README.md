# cgi_internship_2025
Test project for CGI summer internship Tallinn 2025.

## Project Overview

The Flight Selection Application is a Spring Boot-based application that helps travelers choose flights and select seats according to their preferences. It allows users to search for flights, sort them by date, price, or availability, and pick seats based on preferences like legroom or window/aisle seats.

## Technologies Used

- **Java 21** - Main programming language
- **Spring Boot 3** - Backend framework
- **Spring Data JPA** - Data persistence and ORM
- **Hibernate** - ORM framework for database operations
- **H2 Database** - Simple database for development and testing
- **Gradle** - Build automation tool
- **Lombok** - Reduces boilerplate code
- **Thymeleaf** - Frontend template engine

## Project Structure

```
src/main/java/com/yourcompany/flightselection
├── controller    # Handles incoming HTTP requests and responses
├── data          # Data initialization and generating future flights
├── dto           # Data Transfer Objects for communication between layers
├── model         # Entity classes mapped to database tables
├── repository    # Interfaces for data access using Spring Data JPA
├── service       # Business logic and data processing
```

## Data Flow

1. **Controller Layer:** Handles HTTP requests and delegates tasks to the service layer.
2. **Service Layer:** Contains business logic and interacts with the repository layer.
3. **Repository Layer:** Handles data access through JPA and custom queries.
4. **Model Layer:** Represents the data structures and mappings to the database.
5. **DTO Layer:** Transforms data between the application and the API responses.

## Database Structure

The database consists of the following entities:

- **Flight**: Represents individual flights with attributes like date, price, and available seats.
- **FlightSchedule**: Defines regular flight schedules for a specific route.
- **Route**: Describes typical flight routes and durations.
- **AircraftType**: Stores aircraft models and configurations.
- **Seat**: Holds information about the properties of a seat.
- **SeatMapping**: Maps seats onto the specific aircraft model.
- **Airport**: Represents departure and arrival airports.
- **Airline**: Stores airline details and associations with their active routes.
- **Ticket**: Marks a certain seat being taken on a certain flight.
  
See the detailed entity relationship diagram in the docs folder.  

## Getting Started

### Prerequisites

- JDK 21
- Gradle

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/hhelerin/cgi_internship_2025.git
   cd cgi_internship_2025
   ```
2. Build the project:
   ```bash
   ./gradlew clean build
   ```
3. Run the application:
   ```bash
   ./gradlew bootRun
   ```
   
## Project development process
Author: Helerin Heinsalu  
Time spent: about 30 hours   
  
Read about the development process from the project diary (written in Estonian), found in the docs folder. 
