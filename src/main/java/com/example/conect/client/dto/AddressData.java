package com.example.conect.client.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class AddressData {
    private Long id;
    private String name;
    private String age;
    private String state;
    private String city;
    private String street;
}
