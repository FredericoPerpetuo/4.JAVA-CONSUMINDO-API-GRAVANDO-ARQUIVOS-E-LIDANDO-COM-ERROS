package br.com.devfred.aula5.desafiofinal.integration;

import br.com.devfred.aula5.desafiofinal.exception.LogradouroInvalidoException;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
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
        String endpoint = String.format("%s%s/json/", urlBase, cep);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .timeout(readTimeout)
                .GET()
                .build();
        HttpResponse<String> response = httpClient
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao buscar CEP: status code:" + response.statusCode());
        }
        return response.body();

    }

    public String buscarEnderecoPorLogradouro(String uf, String cidade, String rua) throws IOException, InterruptedException {
        String endpoint = String.format("%s%s/%s/%s/json/", urlBase, uf, formatarParaUrl(cidade), formatarParaUrl(rua));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .timeout(readTimeout)
                .GET()
                .build();
        HttpResponse<String> response = httpClient
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao buscar logradouro: status code:" + response.statusCode());
        }
        if("[]".equals(response.body().trim())){
            throw new LogradouroInvalidoException("A rua não foi encontrada ou não existe");
        }
        return response.body();

    }

    private String formatarParaUrl(String termo){
        return URLEncoder.encode(termo, StandardCharsets.UTF_8).replace("+","%20");
    }
}
