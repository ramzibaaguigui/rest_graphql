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
