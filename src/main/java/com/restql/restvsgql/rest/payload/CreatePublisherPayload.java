package com.restql.restvsgql.rest.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePublisherPayload {

    private String name;
    private String address;
    private String phone;
}
