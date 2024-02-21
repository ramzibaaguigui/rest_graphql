package com.restql.restvsgql;

import com.restql.restvsgql.model.Publisher;
import com.restql.restvsgql.service.AuthorService;
import com.restql.restvsgql.service.BookService;
import com.restql.restvsgql.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private AuthorService authorService;
    private BookService bookService;
    private PublisherService publisherService;


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @Autowired
    public HomeController(AuthorService authorService, BookService bookService, PublisherService publisherService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.publisherService = publisherService;
    }

    @GetMapping("/home")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok("hello world");
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {
        bookService.deleteAll();
        authorService.deleteAll();
        publisherService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
