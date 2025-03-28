# Restaurant Review API

## 📌 Overview
The **Restaurant Review API** is a RESTful web service that allows users to manage restaurants and their reviews. Built using **Spring Boot 3.x** and **Java 17**, it supports CRUD operations, analytics, and authentication using Spring Security.

## 🏗️ Architecture
The application follows a **layered architecture**:
- **Controller Layer**: Handles HTTP requests (REST endpoints)
- **Service Layer**: Implements business logic
- **Repository Layer**: Interfaces with the database using JPA
- **Database Layer**: Uses an in-memory **H2 database** for data persistence

## 🛠️ Tech Stack
- **Backend**: Java 17, Spring Boot 3.x, Spring Security, Spring Data JPA
- **Database**: H2 (In-memory)
- **Documentation**: Swagger UI (OpenAPI)
- **Build Tool**: Maven

## ⚙️ Installation & Setup
### 1️⃣ Clone the Repository
```sh
git clone https://github.com/yourusername/restaurant-review-api.git
cd restaurant-review-api
```

### 2️⃣ Configure the Application
The database is already configured in `application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:restaurantdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### 3️⃣ Build & Run
```sh
mvn clean install
mvn spring-boot:run
```

## 🔑 Authentication
- Default user: **user**
- Default password: Printed in the console (Spring Security)
- Uses Basic Authentication for API access

## 📌 API Endpoints
### **Restaurant Endpoints**
- `POST /api/restaurants` → Add a restaurant
- `GET /api/restaurants/{id}` → Get restaurant by ID
- `GET /api/restaurants` → List all restaurants
- `PUT /api/restaurants/{id}` → Update restaurant
- `DELETE /api/restaurants/{id}` → Delete restaurant

### **Review Endpoints**
- `POST /api/reviews` → Add a review
- `GET /api/reviews/{id}` → Get review by ID
- `GET /api/reviews` → List all reviews
- `PUT /api/reviews/{id}` → Update review
- `DELETE /api/reviews/{id}` → Delete review

### **Analytics Endpoint**
- `GET /api/analytics/average-rating/{restaurantId}` → Get average rating of a restaurant

## 📊 Database Access
H2 Console is available at:
```
http://localhost:8080/h2-console
```
Use **JDBC URL**: `jdbc:h2:mem:restaurantdb`, username: `sa`, password: (empty).

## 📖 API Documentation
Swagger UI is available at:
```
http://localhost:8080/swagger-ui/index.html
```

## 📬 Contact
For issues, open a ticket on the [GitHub repository](https://github.com/yourusername/restaurant-review-api/issues).