package com.restql.restvsgql.graphql.Input;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class BookInput {
    private String title;
    private String isbn;
    private List<Long> authorsIds;
    private Long publisherId;

}
