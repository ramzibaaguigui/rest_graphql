package com.restql.restvsgql.graphql.controller;

import com.restql.restvsgql.model.Book;
import com.restql.restvsgql.service.BookService;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller

public class BookGraphQLController {

    private final BookService bookService;

    @Autowired
    public BookGraphQLController(BookService bookService) {
        this.bookService = bookService;

    }

        @QueryMapping()
        public Iterable<Book> recentBooks(@Argument("count") @DefaultValue("10") Integer count, @RequestBody String query) {
            System.out.println("Called the recent books endpoint");
            System.out.println("the value present for count is: " + count);
            System.out.println("we are here");

            List<Book> books = new ArrayList<>();
            return books;
        }

//
//        @QueryMapping()
//        public Iterable<Book> allBooks() {
//            return bookService.getAllBooks();
//        }
//
//
        @QueryMapping("allBooks")
        public Iterable<Book> allTheBooks() {
            System.out.println("called allTheBooks function");
            return bookService.getAllBooks();
        }



}
