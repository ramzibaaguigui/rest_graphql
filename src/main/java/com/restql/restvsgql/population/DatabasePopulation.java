package com.restql.restvsgql.population;

import com.restql.restvsgql.model.Author;
import com.restql.restvsgql.model.Book;
import com.restql.restvsgql.model.Publisher;
import com.restql.restvsgql.repository.AuthorRepository;
import com.restql.restvsgql.repository.BookRepository;
import com.restql.restvsgql.repository.PublisherRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

@Component
public class DatabasePopulation implements CommandLineRunner {

    private static final String ALPHABET =
            "abcde fgh ijkl mnopqr stuvw xyzAB CDEFGH IJKLMN OPQRST UVWX YZ";

    private static final String NUMERIC =
            "0123456789";

    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;


    @Autowired
    public DatabasePopulation(BookRepository bookRepository,
                              PublisherRepository publisherRepository,
                              AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (isDatabaseEmpty()) {
            fillDatabase();

        }

    }

    private boolean isDatabaseEmpty() {
        return bookRepository.findAll().isEmpty();
    }

    private void fillDatabase() {
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        List<Publisher> publishers = new ArrayList<>();

        // generating books
        for (int i = 0; i < 50; i++) {
            books.add(generateBook());
        }

        // generating authors
        for (int i = 0; i < 10; i++) {
            authors.add(generateAuthor());
        }

        // generating publishers
        for (int i = 0; i < 5; i++) {
            publishers.add(generatePublisher());
        }

        // saving authors and publishers to the database
        authors = authorRepository.saveAll(authors);
        publishers = publisherRepository.saveAll(publishers);

        Random random = new Random();
        // assigning authors to books
        for (Book book : books) {

            int authorCount = Math.abs(random.nextInt() % 3) + 1;
            Set<Author> currentBookAuthors = new HashSet<>();

            for (int j = 0; j < authorCount; j++) {
                currentBookAuthors.add(authors.get(
                        Math.abs(random.nextInt() % authors.size())
                ));
            }
            book.setAuthors(new ArrayList<>(currentBookAuthors));

            // set the publisher
            book.setPublisher(publishers.get(Math.abs(random.nextInt() % publishers.size())));

            // save the book
            bookRepository.save(book);
        }

    }

    private Book generateBook() {
        Book book = new Book();
        book.setTitle(RandomStringUtils.random(40, ALPHABET));
        book.setIsbn(RandomStringUtils.random(12));
        book.setCreatedAt(Date.from(Instant.now()));
        return book;
    }

    private Author generateAuthor() {
        Author author = new Author();
        author.setName(RandomStringUtils.random(15, ALPHABET));
        return author;
    }

    private Publisher generatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName(RandomStringUtils.random(23));
        publisher.setAddress(RandomStringUtils.random(22));
        publisher.setPhone(RandomStringUtils.random(10, NUMERIC));
        return publisher;
    }
}
