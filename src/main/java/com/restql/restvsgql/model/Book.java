package com.restql.restvsgql.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "books")
@Entity
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn")
    @NonNull
    private String isbn;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne()
    @JoinColumn(name = "publisher_id")
    @NonNull
    private Publisher publisher;


    @JsonIgnore
    @ManyToMany
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name= "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author) {
        this.authors.add(author);
    }


}