package br.com.devfred.aula2.desafio3;

import br.com.devfred.aula2.desafio3.entities.Livro;
import com.google.gson.Gson;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        String livroJson = """
                {
                  "titulo":"Dom Casmurro",
                  "autor":"Machado de Assis",
                  "editora":{
                    "nome":"Principis",
                    "cidade":"Jandira" 
                  }
                }
                """;
        System.out.println("LIVRO JSON: " + livroJson);
        Gson gson = new Gson();
        Livro livro = gson.fromJson(livroJson, Livro.class);
        System.out.println("LIVRO OBJETO: " + livro);
    }
}


