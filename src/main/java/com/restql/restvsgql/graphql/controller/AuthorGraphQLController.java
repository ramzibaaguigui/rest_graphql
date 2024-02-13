package com.restql.restvsgql.graphql.controller;

import com.restql.restvsgql.model.Author;
import com.restql.restvsgql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphQLController {

    private AuthorService authorService;

    @Autowired
    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping(name = "allAuthors")
    public Iterable<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }


}
