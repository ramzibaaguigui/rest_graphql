package com.restql.restvsgql.service;

import com.restql.restvsgql.exception.AuthorNotFoundException;
import com.restql.restvsgql.exception.BookNotFoundException;
import com.restql.restvsgql.model.Author;
import com.restql.restvsgql.model.Book;
import com.restql.restvsgql.model.Publisher;
import com.restql.restvsgql.repository.AuthorRepository;
import com.restql.restvsgql.repository.BookRepository;
import com.restql.restvsgql.repository.PublisherRepository;
import com.restql.restvsgql.rest.payload.CreateBookPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BookService(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            PublisherRepository publisherRepository
    ) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<Book> getRecentBooks(int count) {
        // sort the books by date
        return bookRepository.findAll().stream().sorted(
                        Comparator.comparingLong(
                                (Book book) -> book.getCreatedAt().getTime()).reversed()
                )
                .limit(count)
                .collect(Collectors.toList());
    }

    public Book getBookById(Long bookId) throws BookNotFoundException {
        Optional<Book> book =
                bookRepository.findBookByIdEquals(bookId);

        if (book.isPresent()) {
            return book.get();
        }
        throw new BookNotFoundException(bookId);
    }

    public List<Book> getAuthorBooks(Long authorId)
            throws AuthorNotFoundException {
        Optional<Author> author = authorRepository.findAuthorByIdEquals(authorId);

        if (author.isPresent()) {

            return authorRepository.getReferenceById(authorId)
                    .getBooks();
        }
        throw new AuthorNotFoundException(authorId);
    }


    public Book createBook(CreateBookPayload payload) {

        List<Author> authors = authorRepository.findAuthorsByIdIn(payload.getAuthorsIds());
        Publisher publisher = publisherRepository.getReferenceById(payload.getPublisherId());

        Book book = new Book();
        book.setTitle(payload.getTitle());
        book.setIsbn(payload.getIsbn());
        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setCreatedAt(Date.from(Instant.now()));

        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) throws BookNotFoundException {
        Optional<Book> book = bookRepository.findBookByIdEquals(bookId);

        if (book.isPresent()) {
            bookRepository.delete(book.get());
        } else {
            throw new BookNotFoundException(bookId);
        }
    }
}
