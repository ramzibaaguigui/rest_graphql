package com.restql.restvsgql.repository;


import com.restql.restvsgql.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findPublisherByIdEquals(Long publisherId);
}
