package com.restql.restvsgql.rest;


import com.restql.restvsgql.rest.payload.CreateAuthorPayload;
import com.restql.restvsgql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/rest/author")
public class AuthorRestController {

    private final AuthorService authorService;

    @Autowired
    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                authorService.getAuthorById(id)
        );
    }

    @GetMapping("/allAuthors")
    public ResponseEntity<?> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{bookId}/authors")
    public ResponseEntity<?> getBookAuthors(@PathVariable("book_id") Long bookId) {
       return ResponseEntity.ok(
               authorService.getBookAuthors(bookId)
       );
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAuthor(@RequestBody CreateAuthorPayload payload) {
        return ResponseEntity.ok(
                authorService.createAuthor(payload)
        );
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAuthor(@PathVariable("authorId") Long id) {

        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}
