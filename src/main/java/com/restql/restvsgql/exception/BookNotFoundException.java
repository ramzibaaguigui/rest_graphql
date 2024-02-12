package com.restql.restvsgql.exception;

public class BookNotFoundException extends Exception{

    private Long bookId;

    public BookNotFoundException(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String getMessage() {
        return "BookNotFoundException: Cannot find book with id " + this.bookId;
    }
}
