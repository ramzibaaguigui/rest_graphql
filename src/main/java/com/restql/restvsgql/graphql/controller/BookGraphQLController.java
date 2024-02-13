package com.restql.restvsgql.graphql.controller;

import com.restql.restvsgql.graphql.Input.BookInput;
import com.restql.restvsgql.model.Book;
import com.restql.restvsgql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller

public class BookGraphQLController {

    private final BookService bookService;

    @Autowired
    public BookGraphQLController(BookService bookService) {
        this.bookService = bookService;

    }

    @QueryMapping("recentBooks")
    public Iterable<Book> recentBooks(@Argument Integer count) {
        System.out.println("Called the recent books endpoint");
        System.out.println("the value present for count is: " + count);
        System.out.println("we are here");

        return bookService.getRecentBooks(count);
    }

    @QueryMapping("allBooks")
    public Iterable<Book> allTheBooks() {
        System.out.println("called allTheBooks function");
        return bookService.getAllBooks();
    }


    @QueryMapping("queryBooks")
    public Iterable<Book> queryBooks(@Argument String query) {
        return bookService.queryBooks(query);
    }


    @MutationMapping("addBook")
    public Book addBook(@Argument BookInput input) {
        return bookService.addBook(input);
    }



}
