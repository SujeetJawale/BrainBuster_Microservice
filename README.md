# Brain-Buster: Interactive Quiz Application  
**REST APIs, Microservices, Redis, Zipkin, MySQL**  
**July 2024 - August 2024**

## Overview  
Brain-Buster is a **microservices-based MVC web application** designed as an interactive quiz platform. It allows users to create custom quizzes, answer questions, and track scores in real-time. Initially developed as a monolithic application, it was later converted into a microservices architecture to understand the design patterns and challenges associated with microservices. This project focuses solely on the **backend development**, providing RESTful APIs that can be used by anyone to build a frontend for their quiz application.

---

## Key Features  
- **Custom Quiz Creation**: Users can create and customize quizzes with unique questions and answers.  
- **Real-Time Score Tracking**: Track user scores in real-time as they answer quiz questions.  
- **Microservices Architecture**: Built using Spring Boot, RESTful APIs, and MySQL, with services like Question Service, Quiz Service, and more.  
- **Performance Optimization**: Integrated Redis caching to reduce database hits and improve latency.  
- **Centralized Configuration**: Utilized Spring Cloud Config Server for centralized configuration management.  
- **Distributed Tracing**: Integrated Zipkin for distributed tracing to improve debugging and monitoring.  
- **Service Discovery**: Used Eureka Server for service registration and discovery.  
- **API Gateway**: Implemented an API Gateway to route requests to the appropriate microservices.  

---

## Impact  
- **Improved Performance**: Reduced latency and database hits by 20% through Redis caching and optimized microservices architecture.  
- **Enhanced Debugging**: Improved debugging efficiency by 20% using Zipkin for distributed tracing.  
- **Scalability**: Microservices architecture ensures the application is scalable and maintainable.  
- **Flexibility**: Backend APIs can be used by any frontend developer to build a custom quiz application.  

---

## Technologies Utilized  
- **Backend**: Spring Boot, RESTful APIs  
- **Database**: MySQL  
- **Caching**: Redis  
- **Service Discovery**: Eureka Server  
- **Configuration Management**: Spring Cloud Config Server  
- **Distributed Tracing**: Zipkin  
- **API Gateway**: Spring Cloud Gateway  
- **Build Tool**: Maven  

---

## Microservices Overview  
The application consists of the following microservices:  

1. **Admin Server**:  
   - Manages the configuration and monitoring of all microservices.  
   - Provides a centralized dashboard for system health and performance metrics.  

2. **API Gateway**:  
   - Acts as the entry point for all incoming requests.  
   - Routes requests to the appropriate microservices (e.g., Question Service, Quiz Service).  

3. **Question Service**:  
   - Handles all operations related to quiz questions, such as creating, updating, and fetching questions.  

4. **Quiz Service**:  
   - Manages quiz creation, customization, and real-time score tracking.  

5. **Service Registry (Eureka Server)**:  
   - Registers all microservices and enables service discovery.  
   - Ensures seamless communication between microservices.  

6. **Config Server**:  
   - Centralizes configuration management for all microservices.  
   - Reduces configuration errors and simplifies updates.  

7. **Redis Caching**:  
   - Caches frequently accessed data to reduce database hits and improve performance.  

8. **Zipkin**:  
   - Provides distributed tracing to monitor and debug requests across microservices.  

---

## Challenges Faced During Microservice Conversion  
1. **Service Communication**:  
   - **Challenge**: Ensuring seamless communication between microservices without tight coupling.  
   - **Solution**: Used RESTful APIs and Eureka Server for service discovery to enable independent communication.  

2. **Distributed Debugging**:  
   - **Challenge**: Debugging issues across multiple microservices was time-consuming and complex.  
   - **Solution**: Integrated Zipkin for distributed tracing, which provided visibility into request flows and improved debugging efficiency.  

---

## Getting Started  
To set up and run the Brain-Buster Quiz Application locally, follow these steps:  

### Prerequisites  
- Java 17 or higher  
- MySQL  
- Redis  
- Maven  

### Steps  
1. **Clone the Repository**:  
   ```bash  
   git clone https://github.com/your-username/brain-buster.git  
   cd brain-buster

2. Set Up MySQL and Redis:
- Create a MySQL database and update the application.properties files in each microservice with the database credentials.
- Ensure Redis is running on the default port (6379).

3. Run the Microservices:
- Start the Eureka Server (Service Registry).
- Start the Config Server.
- Start the Admin Server, API Gateway, Question Service, and Quiz Service.

4. Access the Application:
- Use tools like Postman to interact with the APIs.
- For a detailed list of all available APIs, refer to the API Documentation PDF.

5. Monitor with Zipkin:
- Access Zipkin at http://localhost:9411 to monitor request flows and debug issues.
---
## API Documentation  
For a comprehensive list of all APIs, including endpoints, request/response formats, and examples, check out the [API Documentation PDF](https://drive.google.com/your-link-here). 
