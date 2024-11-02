package com.sl.application.services;

import java.io.Serializable;
import java.util.List;

import com.sl.application.model.Client;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

/**
 * Example Spring service that connects to a REST API asynchronously.
 * <p>
 *
 * @see RestClientService
 */
@SuppressWarnings("serial")
@Service
public class ClientService implements Serializable {

    /**
     * Generic callback interface for asynchronous operations.
     *
     * @param <T> the result type
     */
    public static interface AsyncRestCallback<T> {
        void operationFinished(T results);
    }

    public List<Client> getAllClients() {
        System.out.println("Fetching all commend objects through REST...");

        // Fetch from 3rd party API; configure fetch
        WebClient.RequestHeadersSpec<?> spec = WebClient.create()
                .get().uri("http://localhost:8091/v1/clients");
        // do fetch and map result
        List<Client> clients = spec.retrieve().toEntityList(Client.class).block().getBody();

        System.out.println(String.format("... received %d items.", clients.size()));

        return clients;
    }

    /**
     * Returns parsed {@link Client} objects from the REST service,
     * asynchronously.
     */
    public void getAllClientsAsync(ClientService.AsyncRestCallback<List<Client>> callback) {
        // Configure fetch as normal
        WebClient.RequestHeadersSpec<?> spec = WebClient.create().get().uri("http://localhost:8091/v1/clients");

        // But instead of 'block', do 'subscribe'. This means the fetch will run on a
        // separate thread and notify us when it's ready by calling our lambda operation.
        spec.retrieve().toEntityList(Client.class).subscribe(result -> {

            // get results as usual
            final List<Client> clients = result.getBody();

            // call the ui with the data
            callback.operationFinished(clients);
        });
    }



}
