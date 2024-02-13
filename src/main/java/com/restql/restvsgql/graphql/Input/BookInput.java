package com.restql.restvsgql.graphql.Input;

import lombok.Getter;

import java.util.List;

@Getter
public class BookInput {
    private String title;
    private String isbn;
    private List<Long> authorsIds;
    private Long publisherId;

}
