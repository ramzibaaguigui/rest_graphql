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
