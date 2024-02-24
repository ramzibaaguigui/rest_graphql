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

------------------------------------------------------------------------------
# Author REST Controller API Documentation

## Base URL

`/rest/author`

## Get Author by ID

- **URL:** `/rest/author/{id}`
- **Method:** `GET`
- **Description:** Retrieves the author details based on the provided ID.
- **Parameters:**
   - `{id}` (Long): The unique identifier of the author.
- **Response:**
   - **200 OK:** Author details successfully retrieved.
   - **404 Not Found:** If the author with the given ID does not exist.

## Get All Authors

- **URL:** `/rest/author/allAuthors`
- **Method:** `GET`
- **Description:** Retrieves details of all authors.
- **Response:**
   - **200 OK:** Successfully retrieved a list of authors.

## Get Authors by Book ID

- **URL:** `/rest/author/{bookId}/authors`
- **Method:** `GET`
- **Description:** Retrieves authors of a book based on the provided book ID.
- **Parameters:**
   - `{bookId}` (Long): The unique identifier of the book.
- **Response:**
   - **200 OK:** Authors of the book successfully retrieved.
   - **404 Not Found:** If the book with the given ID does not exist.

## Create Author

- **URL:** `/rest/author/create`
- **Method:** `POST`
- **Description:** Creates a new author with the provided details.
- **Request Body:**
   - `CreateAuthorPayload`:
      - `name` (String): The name of the author.
- **Response:**
   - **200 OK:** Author successfully created.
   - **400 Bad Request:** If the request body is malformed or missing required fields.

## Delete Author

- **URL:** `/rest/author/{authorId}`
- **Method:** `DELETE`
- **Description:** Deletes the author with the provided ID.
- **Parameters:**
   - `{authorId}` (Long): The unique identifier of the author to be deleted.
- **Response:**
   - **200 OK:** Author successfully deleted.
   - **404 Not Found:** If the author with the given ID does not exist.



----------------------------------------------

# Book REST Controller API Documentation

## Base URL

`/rest/book`

## Get Recent Books

- **URL:** `/rest/book/recent`
- **Method:** `GET`
- **Description:** Retrieves a specified number of recent books.
- **Parameters:**
   - `count` (int): The number of recent books to retrieve.
- **Response:**
   - **200 OK:** Recent books successfully retrieved.
   - **400 Bad Request:** If the request parameters are invalid or missing.

## Create Book

- **URL:** `/rest/book/create`
- **Method:** `POST`
- **Description:** Creates a new book with the provided details.
- **Request Body:**
   - `CreateBookPayload`:
      - `title` (String): The title of the book.
      - `isbn` (String): The ISBN of the book.
      - `publisherId` (Long): The ID of the publisher.
      - `authorsIds` (List of Long): The IDs of the authors associated with the book.
- **Response:**
   - **200 OK:** Book successfully created.
   - **400 Bad Request:** If the request body is malformed or missing required fields.

## Delete Book

- **URL:** `/rest/book/delete/{id}`
- **Method:** `DELETE`
- **Description:** Deletes the book with the provided ID.
- **Parameters:**
   - `{id}` (Long): The unique identifier of the book to be deleted.
- **Response:**
   - **200 OK:** Book successfully deleted.
   - **400 Bad Request:** If the book with the given ID does not exist or deletion fails.

## Get All Books

- **URL:** `/rest/book/allBooks`
- **Method:** `GET`
- **Description:** Retrieves details of all books.
- **Response:**
   - **200 OK:** Successfully retrieved a list of books.


------------------------------------------------------------
# Publisher REST Controller API Documentation

## Base URL

`/rest/publisher`

## Create Publisher

- **URL:** `/rest/publisher`
- **Method:** `POST`
- **Description:** Creates a new publisher with the provided details.
- **Request Body:**
   - `CreatePublisherPayload`:
      - `name` (String): The name of the publisher.
      - `address` (String): The address of the publisher.
      - `phone` (String): The phone number of the publisher.
- **Response:**
   - **200 OK:** Publisher successfully created.
   - **400 Bad Request:** If the request body is malformed or missing required fields.

--------------------------------------------------------------------
# Author GraphQL Controller API Documentation

## Queries

### Get All Authors

- **Query Name:** `allAuthors`
- **Description:** Retrieves all authors.
- **Returns:** Iterable of Author objects containing details of all authors.

### Get Author by ID

- **Query Name:** `author`
- **Description:** Retrieves the author with the specified ID.
- **Parameters:**
   - `id` (Long): The unique identifier of the author.
- **Returns:** Author object containing details of the author with the specified ID.

## Mutations

### Add Author

- **Mutation Name:** `addAuthor`
- **Description:** Adds a new author with the provided details.
- **Input:**
   - `AuthorInput`: Input object containing details of the author to be added.
- **Returns:** Author object containing details of the newly added author.

### Delete Author

- **Mutation Name:** `deleteAuthor`
- **Description:** Deletes the author with the specified ID.
- **Input:**
   - `AuthorInput`: Input object containing the ID of the author to be deleted.
- **Returns:** Void.

-------------------------------------------------------------------------
# Book GraphQL Controller Documentation

## Queries

### 1. Recent Books

- **Query Name:** `recentBooks`
- **Description:** Retrieves a specified number of recent books.
- **Parameters:**
   - `count` (Integer): The number of recent books to retrieve.
- **Returns:** Iterable of Book objects containing details of recent books.
- **Example:**
  ```graphql
  query {
    recentBooks(count: 5) {
      id
      title
      isbn
      publisher {
        id
        name
      }
      authors {
        id
        name
      }
      createdAt
    }
  }

### 2. All Books

- **Query Name:** `allBooks`
- **Description:** Retrieves details of all books.
- **Returns:** Iterable of Book objects containing details of all books.
- **Example:**
  ```graphql
  query {
    allBooks {
      id
      title
      isbn
      publisher {
        id
        name
      }
      authors {
        id
        name
      }
      createdAt
    }
  }

### 3. Query Books

- **Query Name:** `queryBooks`
- **Description:** Retrieves books based on the provided query.
- **Parameters:**
   - `query` (String): The query string to search for books.
- **Returns:** Iterable of Book objects containing details of books matching the query.
- **Example:**
  ```graphql
  query {
    queryBooks(query: "Spring") {
      id
      title
      isbn
      publisher {
        id
        name
      }
      authors {
        id
        name
      }
      createdAt
    }
  }


--------------------------------------------------------------------
# Publisher GraphQL Controller Documentation

## Mutations

### 1. Add Publisher

- **Mutation Name:** `addPublisher`
- **Description:** Creates a new publisher with the provided details.
- **Input:**
   - `PublisherInput`: Input object containing details of the publisher to be created.
- **Returns:** Publisher object containing details of the newly created publisher.

## Queries

### 2. Get Publisher

- **Query Name:** `getPublisher`
- **Description:** Retrieves the publisher with the specified ID.
- **Parameters:**
   - `publisherId` (Long): The ID of the publisher to retrieve.
- **Returns:** Publisher object containing details of the requested publisher.

### 3. All Publishers

- **Query Name:** `allPublishers`
- **Description:** Retrieves details of all publishers.
- **Returns:** List of Publisher objects containing details of all publishers.
