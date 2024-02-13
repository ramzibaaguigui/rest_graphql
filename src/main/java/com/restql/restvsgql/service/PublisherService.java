package com.restql.restvsgql.service;

import com.restql.restvsgql.graphql.Input.PublisherInput;
import com.restql.restvsgql.model.Publisher;
import com.restql.restvsgql.repository.PublisherRepository;
import com.restql.restvsgql.rest.payload.CreatePublisherPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(
            PublisherRepository publisherRepository
    ) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher createPublisher(CreatePublisherPayload payload) {
        Publisher publisher = new Publisher();

        publisher.setName(payload.getName());
        publisher.setPhone(payload.getPhone());
        publisher.setAddress(payload.getAddress());

        return publisherRepository.save(publisher);
    }

    public void deleteAll() {

        publisherRepository.deleteAll();
    }

    public Publisher createPublisher(@Argument   PublisherInput input) {
        Publisher publisher = new Publisher();
        publisher.setName(input.getName());
        publisher.setAddress(input.getAddress());
        publisher.setPhone(input.getName());

        return publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
}
