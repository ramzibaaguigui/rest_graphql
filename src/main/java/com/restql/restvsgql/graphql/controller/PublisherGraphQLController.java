package com.restql.restvsgql.graphql.controller;

import com.restql.restvsgql.graphql.Input.PublisherInput;
import com.restql.restvsgql.model.Publisher;
import com.restql.restvsgql.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PublisherGraphQLController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherGraphQLController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @MutationMapping("addPublisher")
    public Publisher createPublisher(
            @Argument PublisherInput input
    ) {
        return publisherService.createPublisher(input);
    }

    @QueryMapping("getPublisher")
    public Publisher getPublisher(
            @Argument Long publisherId
    ) {
        return publisherService.getPublisherById(publisherId);
    }

    @QueryMapping("allPublishers")
    public List<Publisher> allPublishers() {
        return publisherService.getAllPublishers();

    }


}
