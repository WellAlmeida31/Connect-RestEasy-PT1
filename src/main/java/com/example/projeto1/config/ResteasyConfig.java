package com.example.projeto1.config;

import com.example.projeto1.service.ConnectionRemote;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient43Engine;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.core.UriBuilder;


@Configuration
public class ResteasyConfig {
    //UriBuilder FULL_PATH = UriBuilder.fromPath("https://viacep.com.br");
    UriBuilder FULL_PATH = UriBuilder.fromPath("http://localhost:8081");

    @Bean
    public ResteasyClient resteasyClient(){
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(300);
        connectionManager.setDefaultMaxPerRoute(20);
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        ApacheHttpClient43Engine engine = new ApacheHttpClient43Engine(httpClient);
        return new ResteasyClientBuilderImpl()
                .httpEngine(engine)
                .register(new ResteasyJackson2Provider()).build();
    }

    @Bean
    public ResteasyWebTarget target(){
        return resteasyClient().target(FULL_PATH);
    }

    @Bean
    public ConnectionRemote conectionRemote(){
        return new ResteasyConfig().target().proxy(ConnectionRemote.class);
    }

}
