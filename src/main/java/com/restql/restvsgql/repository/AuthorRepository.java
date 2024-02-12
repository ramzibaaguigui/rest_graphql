package com.restql.restvsgql.repository;

import com.restql.restvsgql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorByIdEquals(Long authorId);

    List<Author> findAuthorsByIdIn(List<Long> ids);


}
