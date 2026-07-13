package br.com.devfred.aula3.desafio3;

import br.com.devfred.aula3.desafio3.entities.Repositorio;
import br.com.devfred.aula3.desafio3.entities.Usuario;
import br.com.devfred.aula3.desafio3.exception.ErroConsultaGitHubException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.xml.stream.events.EntityReference;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do usuário no GitHub: ");
        String nome = sc.nextLine();

        try {
            String endpoint = "https://api.github.com/users/" + nome + "/repos";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .header("Accept", "application/json")
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 404){
                throw new ErroConsultaGitHubException("Cadastro do usuário " + nome + " não existe no GitHub");
            }

            Gson gson = new Gson();
            Type tipoLista = new TypeToken<List<Repositorio>>() {}.getType();
            List<Repositorio> repositorios = gson.fromJson(response.body(), tipoLista);

            Usuario usuario = new Usuario(nome, repositorios);

            if(repositorios.isEmpty()){
                System.out.println("O usuário não possui repositórios públicos");
            }else{
                System.out.println("Repositórios públicos de " + nome);
                for (Repositorio repositorio : repositorios) {
                    System.out.println(repositorio.html_url());
                }
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erra durante o acesso à API GitHub");
            System.out.println(e.getMessage());
        }catch (ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        }

    }
}
