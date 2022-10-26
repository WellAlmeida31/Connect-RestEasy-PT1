package com.example.projeto1.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface ConnectionRemote {

    @POST
    @Path("/emmpost")
    @Consumes({MediaType.APPLICATION_JSON})
    Response emmPost(String connectionDto);

    @GET
    @Path("/ws/{cep}/json/")
    @Produces({ MediaType.APPLICATION_JSON})
    String getCep(@PathParam("cep") String cep);
}
