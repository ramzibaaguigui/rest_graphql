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

## Springdoc Swagger-UI Configuration

- **Swagger-UI Path:** /swagger-ui.html
- **API Docs Path:** /api-docs

## Instructions for Setup and Running

1. **Database Setup:**
   - Install and run MySQL on your machine.
   - Create a database named `books`.

2. **Spring Project Configuration:**
   - Update the `application.properties` file with the above database configuration.
   - Ensure Hibernate DDL auto mode is set to `update`.

3. **GraphQL Configuration:**
   - Enable GraphQL servlet and set the mapping URL in `application.properties`.

4. **GraphiQL Configuration (Optional):**
   - Enable GraphiQL for a user-friendly GraphQL interface.

5. **Voyager Configuration (Optional):**
   - Enable Voyager to explore GraphQL APIs visually.

6. **GraphQL Console Configuration:**
   - Enable the GraphQL console for testing and debugging.

7. **Springdoc Swagger-UI Configuration:**
   - Configure Springdoc Swagger-UI path and API docs path.

8. **Run the Application:**
   - Build and run your Spring Boot application using Maven:
     ```
     mvn spring-boot:run
     ```

9. **Accessing Endpoints:**
   - GraphQL endpoint: `http://localhost:8080/graphql`
   - GraphiQL interface (if enabled): `http://localhost:8080/graphiql`

10. **Start Querying and Developing:**
   - You're now ready to query your GraphQL API and develop your application features.

Follow these steps to set up and run your Spring project with GraphQL integration successfully.
