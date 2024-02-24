package com.restql.restvsgql.rest;


import com.restql.restvsgql.model.Publisher;
import com.restql.restvsgql.rest.payload.CreatePublisherPayload;
import com.restql.restvsgql.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherRestController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherRestController(
            PublisherService publisherService
    ) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(
            @RequestBody CreatePublisherPayload payload
    ) {
        try {
            return ResponseEntity.ok(
                    publisherService.createPublisher(payload)
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }


}
