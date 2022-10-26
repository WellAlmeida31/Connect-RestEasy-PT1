package com.example.conect.controller;

import com.example.conect.client.dto.AddressData;
import com.example.conect.client.dto.ClientData;
import com.example.conect.client.dto.DataDto;
import com.example.conect.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class Controller {

    @Autowired
    private ConnectionService connectionService;

    @GetMapping(value = "/getcep/{cep}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findCep(@PathVariable String cep){
        return ok(connectionService.getCep(cep));
    }

    @PostMapping(value = "/postconection",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientData> clientData(@RequestBody DataDto dto){
        return ok(connectionService.clientData(dto, ClientData.class));
    }

    @PostMapping(value = "/postconection2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressData> addressdata(@RequestBody DataDto dto){
        return ok(connectionService.addressData(dto, AddressData.class));
    }
}
