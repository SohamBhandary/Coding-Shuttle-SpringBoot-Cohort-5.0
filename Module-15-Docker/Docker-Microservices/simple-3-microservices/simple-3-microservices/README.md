# Simple 3-Microservice Spring Boot Project

No database. No Eureka. No Kafka.

## Services

- user-service -> 8081
- product-service -> 8082
- order-service -> 8083

## Communication

Order Service uses OpenFeign to call both User Service and Product Service.

```text
                 ┌───────────────┐
                 │  Order Service│ :8083
                 └───────┬───────┘
                    Feign│   │Feign
                         │   │
                 ┌───────▼┐ ┌▼──────────────┐
                 │  User  │ │   Product     │
                 │ :8081  │ │    :8082      │
                 └────────┘ └───────────────┘
```

## Run

Start all three applications.

Then call:

GET http://localhost:8083/orders/101

Order Service calls:

GET http://localhost:8081/users/1
GET http://localhost:8082/products/1

No DB is required.
