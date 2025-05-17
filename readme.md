# Fintech Employee Onboarding - Quick Start

## Prerequisites
- JDK 17+
- Maven 3.6.3+
- PostgreSQL 15+

## Setup
1. Create DB:
```sql
CREATE DATABASE onboarding;
CREATE USER admin WITH PASSWORD 'secret';
GRANT ALL PRIVILEGES ON DATABASE onboarding TO admin;

## - Configure application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/onboarding
spring.datasource.username=admin
spring.datasource.password=secret

## Build & Run:

mvn clean install
mvn spring-boot:run

- Access
Swagger UI: http://localhost:8080/swagger-ui.html

Default Users:

Admin: admin/admin123

HR: hr/hr123

# Get token
curl -X POST "http://localhost:8080/api/auth/login" \
-H "Content-Type: application/json" \
-d '{"username":"admin","password":"admin123"}'

# Use token in subsequent requests
curl -H "Authorization: Bearer YOUR_TOKEN" http://localhost:8080/api/employees