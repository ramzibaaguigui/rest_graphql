package com.restql.restvsgql.exception;

public class AuthorNotFoundException extends Exception{

    private Long authorId;

    public AuthorNotFoundException(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String getMessage() {
        return "AuthorNotFoundException: Cannot find author with id " + this.authorId;
    }
}
