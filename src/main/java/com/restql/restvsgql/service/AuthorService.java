package com.restql.restvsgql.service;

import com.restql.restvsgql.graphql.Input.AuthorInput;
import com.restql.restvsgql.model.Author;
import com.restql.restvsgql.repository.AuthorRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {


    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(
            AuthorRepository authorRepository
    ) {
        this.authorRepository = authorRepository;
    }


    public void deleteAll() {
        authorRepository.deleteAll();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.getReferenceById(id);
    }

    public Author createAuthor(AuthorInput input) {
        Author author = new Author();
        System.out.println("received the following name: " + input.getName());
        author.setName(input.getName());
        author.setBooks(new ArrayList<>());
        author =  authorRepository.save(author);
        System.out.println(author);
        return author;
    }
}
