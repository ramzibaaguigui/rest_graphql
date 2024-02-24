# Spring Project Setup Guide

## Database Configuration

1. **Database Management:** Hibernate
2. **DDL Auto Mode:** Update
3. **Database URL:** jdbc:mysql://localhost:3306/books?createDatabaseIfNotExist=true
4. **Username:** root
5. **Password:** [Your MySQL Password]
6. **Driver Class Name:** com.mysql.cj.jdbc.Driver
7. **Hibernate Dialect:** org.hibernate.dialect.MySQLDialect

## Spring Data Repositories

- **Enabled:** true

## Logging Configuration

- **Root Logging Level:** debug

## GraphQL Configuration

- **Mapping URL:** /graphql
- **Enabled:** true

## GraphiQL Configuration

- **Enabled:** true
- **Mapping URL:** /graphiql

## Voyager Configuration

- **Enabled:** true
- **Mapping URL:** /voyager

## GraphQL Console

- **Enabled:** true


## Instructions for Setup and Running

1. **Database Setup:**
   - Install and run MySQL on your machine.
   - Create a database named `books`.

2. **Spring Project Configuration:**
   - Update the `application.properties` file with the above database configuration.
   - Ensure Hibernate DDL auto mode is set to `update`.

3. **Run the Application:**
   - Build and run your Spring Boot application using Maven:
     ```
     mvn spring-boot:run
     ```

4. **Accessing Endpoints:**
   - GraphQL endpoint: `http://localhost:8080/graphql`
   - GraphiQL interface (if enabled): `http://localhost:8080/graphiql`


Follow these steps to set up and run your Spring project with GraphQL integration successfully.
