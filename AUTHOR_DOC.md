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

