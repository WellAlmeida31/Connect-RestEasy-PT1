package com.example.conect.client.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ClientData {
    private Long id;
    private String name;
    private String age;
}
