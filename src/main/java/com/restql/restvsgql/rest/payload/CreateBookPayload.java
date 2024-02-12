package com.restql.restvsgql.rest.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookPayload {

    private String title;
    private String isbn;

    private Long publisherId;
    private List<Long> authorsIds;
}
