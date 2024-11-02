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

    /**
     * Returns parsed {@link Client} objects from the REST service,
     * asynchronously.
     */
    public void getAllClients1(AsyncRestCallback<List<Client>> callback) {

        System.out.println("Setting up fetching all Comment objects through REST..");

        // Configure fetch as normal
        RequestHeadersSpec<?> spec = WebClient.create().get().uri("http://localhost:8091/v1/clients");

        // But instead of 'block', do 'subscribe'. This means the fetch will run on a
        // separate thread and notify us when it's ready by calling our lambda
        // operation.
        spec.retrieve().toEntityList(Client.class).subscribe(result -> {

            // This code block is run whenever the results are back

            // get results as usual
            final List<Client> clients = result.getBody();

            //System.out.println(String.format("...received %d items.", clients.size()));

            // call the ui with the data
            callback.operationFinished(clients);
        });

    }

    public void getAllClients11(AsyncRestCallback<List<Client>> callback) {
        System.out.println("Setting up fetching all Comment objects through REST..");
        RequestHeadersSpec<?> spec = WebClient.create().get().uri("http://localhost:8091/v1/clients");
        spec.retrieve().toEntityList(Client.class).subscribe(result -> {
            callback.operationFinished(result.getBody());
        });
    }


}
