package com.restql.restvsgql.graphql.controller;

import com.restql.restvsgql.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PublisherGraphQLController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherGraphQLController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }


}
