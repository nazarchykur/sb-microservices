
# sb-microservices using cloud

## Overview

This project is a microservices-based application that utilizes Docker Compose for containerization and orchestration. It aims to provide a scalable and modular solution for **sb-microservices**. The application is composed of multiple independent microservices, each responsible for specific functionalities. The microservices are deployed using Docker Compose, allowing for easy management and deployment of the entire application stack.

![schema.png](screenshots%2Fschema.png)

## Microservices

The application consists of the following microservices:

* **api-gateway**: Acts as the entry point for client requests, providing a centralized routing and load balancing layer for the microservices.
* **config-server**: Manages centralized configuration for the microservices, allowing them to retrieve their configurations at runtime.
* **discovery**: Handles service registration and discovery using Eureka, enabling microservices to locate and communicate with each other dynamically.
* **schools**: Manages operations related to schools.
* **students**: Manages operations related to students.

Each microservice is independently developed, deployed, and can scale horizontally as needed. The modular nature of microservices allows for flexibility in development, deployment, and maintenance, as each microservice can be updated and scaled individually.

## Docker Compose

The project utilizes Docker Compose to manage and orchestrate the deployment of the microservices. The docker-compose.yml file defines the configuration for the required services, including the PostgreSQL database, PgAdmin for administration, and Zipkin for distributed tracing. By using Docker Compose, the entire application stack can be easily started and stopped with a single command, simplifying development, testing, and deployment processes.

The docker-compose.yml file includes configurations for network connections, volume mounting, and environment variables. It ensures that the microservices are deployed in separate containers, allowing for isolation and scalability.

## Getting Started

To get started with the project, follow these steps:

1. Install Docker and Docker Compose on your system.
2. Clone the project repository to your local machine.
3. Navigate to the project directory.
4. Run the command `docker compose up` to start the microservices and associated services.
5. Access the application through the appropriate API endpoints or the configured API Gateway URL.
6. Make sure to customize the environment variables, network configurations, and any other settings as needed for your specific environment.

## Microservices

### api-gateway

#### Description: 

The API Gateway microservice acts as the entry point for all client requests and serves as a centralized routing and load balancing layer for the other microservices.

#### Dependencies:

* _spring-boot-starter-actuator_: Enables monitoring and management endpoints for the API Gateway.
* _spring-cloud-starter-config_: Provides integration with the configuration server for centralized configuration management.
* _spring-cloud-starter-gateway_: Implements the Spring Cloud Gateway for routing and filtering requests.
* _spring-cloud-starter-netflix-eureka-client_: Integrates with Eureka for service discovery.
* _io.micrometer:micrometer-tracing-bridge-brave_: Facilitates tracing using Brave with Micrometer.
* _io.zipkin.reporter2:zipkin-reporter-brave_: Enables Zipkin reporting for distributed tracing.

### config-server

#### Description:

The Config Server microservice is responsible for centralized configuration management. It serves configuration files to the other microservices.
#### Dependencies:
* _org.springframework.cloud:spring-cloud-config-server_: Implements the Spring Cloud Config Server for centralized configuration management.

### discovery

#### Description: 
The Discovery microservice handles service registration and discovery using Eureka. It allows microservices to locate and communicate with each other dynamically.
#### Dependencies:
* _spring-cloud-starter-netflix-eureka-client_: Integrates with Eureka for service registration and discovery.
* _spring-cloud-starter-config_: Provides integration with the configuration server for centralized configuration management.

### schools

#### Description: 
The Schools microservice manages operations related to schools.
#### Dependencies:
* _spring-boot-starter-actuator_: Enables monitoring and management endpoints for the Schools microservice.
* _spring-boot-starter-data-jpa_: Provides support for data access using the Java Persistence API (JPA).
* _spring-boot-starter-web_: Implements web-related functionality for the Schools microservice.
* _spring-cloud-starter-config_: Provides integration with the configuration server for centralized configuration management.
* _spring-cloud-starter-netflix-eureka-client_: Integrates with Eureka for service discovery.
* _spring-cloud-starter-openfeign_: Facilitates communication with other microservices using Feign.
* _io.micrometer:micrometer-tracing-bridge-brave_: Facilitates tracing using Brave with Micrometer.
* _io.zipkin.reporter2:zipkin-reporter-brave_: Enables Zipkin reporting for distributed tracing.
* _org.projectlombok:lombok_: Enhances code readability by reducing boilerplate code (compile-only).
* _org.postgresql:postgresql_: Provides the PostgreSQL database driver (runtime-only).

### students

#### Description: 
The Students microservice manages operations related to students.
#### Dependencies:
* _spring-boot-starter-actuator_: Enables monitoring and management endpoints for the Schools microservice.
* _spring-boot-starter-data-jpa_: Provides support for data access using the Java Persistence API (JPA).
* _spring-boot-starter-web_: Implements web-related functionality for the Schools microservice.
* _spring-cloud-starter-config_: Provides integration with the configuration server for centralized configuration management.
* _spring-cloud-starter-netflix-eureka-client_: Integrates with Eureka for service discovery.
* _io.micrometer:micrometer-tracing-bridge-brave_: Facilitates tracing using Brave with Micrometer.
* _io.zipkin.reporter2:zipkin-reporter-brave_: Enables Zipkin reporting for distributed tracing.
* _org.projectlombok:lombok_: Enhances code readability by reducing boilerplate code (compile-only).
* _org.postgresql:postgresql_: Provides the PostgreSQL database driver (runtime-only).


## Microservice Communication

The microservices in this project communicate with each other through the following mechanisms:

* **API Gateway**: Acts as a central entry point for client requests and routes them to the appropriate microservices based on the specified paths.
* **Eureka**: The Discovery microservice handles service registration and discovery using Eureka. It allows microservices to locate and communicate with each other dynamically.
* **Feign**: Microservices communicate with each other using Feign, which simplifies the creation of REST clients. It abstracts away the low-level details of HTTP communication and provides a declarative way to define API bindings.
* **Configuration Server**: The Config Server microservice provides centralized configuration management. It serves configuration files to the other microservices, allowing them to retrieve their configurations at runtime.

# Microservice Startup Order

To ensure proper functionality, start the microservices in the following order:

1. **config-server**: The Config Server should be started first to provide the configuration for the other microservices.
2. **discovery**: The Discovery microservice should be started next to handle service registration and discovery.
3. **schools and students**: These microservices can be started simultaneously since they are independent of each other.
4. **api-gateway**: Finally, start the API Gateway to handle client requests and route them to the appropriate microservices.

By following this order, the microservices will be able to register with Eureka, discover other services, and correctly retrieve their configurations from the Config Server.

### Using Postman lets call some endpoints:

![img_6.png](screenshots%2Fimg_6.png)

![img_7.png](screenshots%2Fimg_7.png)

### PGAdmin
![img_11.png](screenshots%2Fimg_11.png)

### Zipkin:
![img_10.png](screenshots%2Fimg_10.png)