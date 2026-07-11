package br.com.devfred.aula1.desafio1;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BuscadorLivros {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o título do livro? ");
        String titulo = sc.nextLine();
        String tituloConfigurado = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        System.out.print("Qual a chave da api? ");
        String chave = sc.nextLine();

        String endpoint = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + tituloConfigurado + "&key=" + chave;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        sc.close();
    }
}
