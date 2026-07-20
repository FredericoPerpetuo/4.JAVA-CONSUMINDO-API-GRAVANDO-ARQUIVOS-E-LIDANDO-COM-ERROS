package br.com.devfred.aula5.desafiofinal.integration;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ViaCepClient {
    private final HttpClient httpClient;
    private final String urlBase;
    private final Duration readTimeout;


    public ViaCepClient(HttpClient httpClient, String urlBase, Duration readTimeout) {
        this.httpClient = httpClient;
        this.urlBase = urlBase;
        this.readTimeout = readTimeout;
    }

    public String buscarEnderecoPorCep(String cep) throws IOException, InterruptedException {
        String endereco = String.format("%s%s/json/", urlBase, cep);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .timeout(readTimeout)
                .GET()
                .build();
        HttpResponse<String> response = httpClient
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }

    public String buscarEnderecoPorLogradouro(String uf, String cidade, String logradouro) throws IOException, InterruptedException {
        String endereco = String.format("%s%s/%s/%s/json/", urlBase, uf, cidade, logradouro);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .timeout(readTimeout)
                .GET()
                .build();
        HttpResponse<String> response = httpClient
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
}
