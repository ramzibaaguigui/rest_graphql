package com.restql.restvsgql.graphql.config;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.restql.restvsgql.repository.AuthorRepository;
import com.restql.restvsgql.repository.BookRepository;
import com.restql.restvsgql.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public Query(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }




}
