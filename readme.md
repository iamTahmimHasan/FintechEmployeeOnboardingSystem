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