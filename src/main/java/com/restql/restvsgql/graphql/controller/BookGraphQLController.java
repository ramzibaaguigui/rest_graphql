package com.restql.restvsgql.graphql.controller;

import com.restql.restvsgql.model.Book;
import com.restql.restvsgql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookGraphQLController {

    private final BookService bookService;

    @Autowired
    public BookGraphQLController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> recentBooks(@Argument int count) {
        try {
            return bookService.getRecentBooks(count);
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

}
