package com.restql.restvsgql.rest;

import com.restql.restvsgql.model.Book;
import com.restql.restvsgql.rest.payload.CreateBookPayload;
import com.restql.restvsgql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest/book")
public class BookRestController {

    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/recent")
    public ResponseEntity<?> getRecentBooks(@Param("count") int count) {
        try {
            return ResponseEntity.ok(
                    bookService.getRecentBooks(count)
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookPayload payload) {
        try {
            return ResponseEntity.ok(
                    bookService.createBook(payload)
            );

        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long bookId) {
        try {
            bookService.deleteBook(bookId);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/allBooks")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(
                bookService.getAllBooks()
        );
    }
}
