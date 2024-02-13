package com.restql.restvsgql.service;

import com.restql.restvsgql.model.Author;
import com.restql.restvsgql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
