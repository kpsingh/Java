package com.java.restcall;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestCallFromJavaAPI {

    public static void main(String[] args) {
        String url = "https://fakestoreapi.com/products/1";
        HttpClient client = HttpClient.newHttpClient(); // create the client
        HttpRequest request = HttpRequest.newBuilder() // create the request
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // make the http call
            System.out.println("Response:\n" + response.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
