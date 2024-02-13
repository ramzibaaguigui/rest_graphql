package com.restql.restvsgql.graphql.config;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.restql.restvsgql.model.Book;
import com.restql.restvsgql.repository.AuthorRepository;
import com.restql.restvsgql.repository.BookRepository;
import com.restql.restvsgql.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public Mutation(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public Iterable<Book> recentBooks() {
        return bookRepository.findAll();

    }
}
