package com.example.projeto1.dto;

import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class ConnectionDto <T> {

    private HeadersDTO headersDTO;
    private RequestMethod requestMethod;
    private final String fields;
}
