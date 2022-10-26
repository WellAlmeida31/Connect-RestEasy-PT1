package com.example.projeto1.service;

import com.example.projeto1.client.dto.AddressData;
import com.example.projeto1.client.dto.ClientData;
import com.example.projeto1.dto.ConnectionDto;
import com.example.projeto1.dto.HeadersDTO;
import com.example.projeto1.dto.RequestMethod;
import com.example.projeto1.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

import static java.util.Collections.singletonList;

@Service
public class ConnectionService {

    @Autowired
    private ConnectionRemote connectionRemoteProxy;

    public String getCep(String cep){
        return connectionRemoteProxy.getCep(cep);
    }

    public <T,R> ClientData clientData(T t, Class<R> clazz){
        ConnectionDto<T> dto = new ConnectionDto<>(HeadersDTO.builder()
                .authorization("TestAutorization")
                .userAgent("TestUserAgente")
                .build(),RequestMethod.method1,Utils.arrayToString(singletonList(t)));
        ClientData cd = (ClientData) getClientData(dto, clazz);
        return cd;
    }

    public <T,R> AddressData addressData(T t, Class<R> clazz){
        ConnectionDto<T> dto = new ConnectionDto<>(HeadersDTO.builder()
                .authorization("TestAutorization")
                .userAgent("TestUserAgente")
                .build(),RequestMethod.method2,Utils.arrayToString(singletonList(t)));
        AddressData cd = (AddressData) getClientData(dto, clazz);
        return cd;
    }


    private <T,R> Object getClientData(ConnectionDto<T> dto, Class<R> clazz) {
        Response client = connectionRemoteProxy.projeto2Post(Utils.toJson(dto));
        R cd = client.readEntity(clazz);
        client.close();
        return (R) cd;
    }


}
