package com.restql.restvsgql.graphql.controller;

import com.restql.restvsgql.graphql.Input.AuthorInput;
import com.restql.restvsgql.model.Author;
import com.restql.restvsgql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
public class AuthorGraphQLController {

    private final AuthorService authorService;

    @Autowired
    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping(name = "allAuthors")
    public Iterable<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }


    @QueryMapping("author")
    public Author getAuthorById(@Argument Long id) {
        return authorService.getAuthorById(id);
    }


    @MutationMapping("addAuthor")
    public Author addAuthor(@Argument AuthorInput input) {
        return authorService.createAuthor(input);
    }

    @MutationMapping("deleteAuthor")
    public void deleteAuthor(@Argument AuthorInput input) {
        Long id = input.getId();
        authorService.deleteAuthor(id);
    }



}
