# Microservice Demo Project

This is a demo of a Spring Boot 3 application with scalable microservices that showcases features including
local and `Docker` configurations, `Eureka` service discovery, `Spring API Gateway`, `Zipkin` for distributed tracing,
`RabbitMQ` for async message communication, and `Feign Clients` for internal service communication. It's **NOT**
focusing on `Hibernate`, `Spring Data JPA`, JPA Entities, and transaction management via Spring Proxies.

## Prerequisites

Before you begin, make sure you have the following tools and dependencies installed on your system:

- Java Development Kit (JDK) 17
- Docker
- Maven

## Project Structure

The project is structured into several microservices and components:

- `eureka-server`: Eureka service discovery server.
- `api-gw`: Spring API Gateway.
- `zipkin`: Zipkin for distributed tracing.
- `amqp`: RabbitMQ configurations.
- `clients`: Common module defining REST endpoints for internal service communication.
- `data-access-layer`: Common module defining JPA entities and database migrations.
- `rest-api`: A microservice for processing REST requests.
- `task-executor`: A microservice for resource intensive, long-running task execution.

## Getting Started

1. Clone the project repository.
2. Run the Docker containers: `docker compose up -d`
   ![Docker containers in Docker Desktop](https://cdn.discordapp.com/attachments/799052286273388555/1163448862070030386/image.png)
3. Access the Eureka dashboard to verify service discovery.
   ![Eureka dashboard](https://cdn.discordapp.com/attachments/799052286273388555/1163432030919479316/image.png)
4. Access the Zipkin dashboard for distributed tracing.
   ![Zipkin dashboard](https://cdn.discordapp.com/attachments/799052286273388555/1163454949045309460/image.png)
5. Access the RabbitMQ dashboard to trace message traffic in queue.
   ![RabbitMQ dashboard](https://cdn.discordapp.com/attachments/799052286273388555/1163421295585796106/image.png)

## The demo process

1. We send a REST API request to the `publish-and-hello` endpoint of the rest-api service. This service responds
   immediately.
2. Before returning, it makes a synchronous Feign Client HTTP call to the task-executor
   service's `hello` endpoint, demonstrating internal service communication, which is also immediate.
3. It also adds a message to the RabbitMQ message queue asynchronously. Since the request is processed when a consumer
   dequeues the message when it is able to, this call is also immediate.
4. The message is processed by the `@RabbitListener` method in the `TaskExecutorRabbitMQConsumer` class in the
   task-executor service. If this process needs extra resources, we can scale it horizontally and independently of 
   other services in a container orchestrator, like `Kubernetes`.

## Run the demo

1. Send a REST API request to the API Gateway to see all microservice and component in action:
   `curl -X POST -d "Ez egy queue üzenet." http://localhost:8100/api/v1/rest-api/publish-and-hello`
2. You can see the flow of the request processing in Zipkin:
   ![Zipkin dashboard](https://cdn.discordapp.com/attachments/799052286273388555/1163421092535353385/image.png)

## Clean Up

`docker compose down`