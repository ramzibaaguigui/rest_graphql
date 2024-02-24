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

