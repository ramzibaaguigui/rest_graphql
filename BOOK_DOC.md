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
