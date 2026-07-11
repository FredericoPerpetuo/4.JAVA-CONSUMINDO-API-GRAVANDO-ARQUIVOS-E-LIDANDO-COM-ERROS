package br.com.devfred.aula1.desafio2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CotacaoCriptoMoeda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cripto moeda: ");
        String cripto = sc.nextLine();

        String endpoint = "https://api.coingecko.com/api/v3/simple/price?ids=" + cripto + "&vs_currencies=usd,brl";

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
