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

