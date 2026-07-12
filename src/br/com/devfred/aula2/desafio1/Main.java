package br.com.devfred.aula2.desafio1;

import br.com.devfred.aula2.desafio1.entities.Pessoa;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        String pessoaJson = "{\"nome\":\"Fred\",\"idade\":45,\"cidade\":\"Belo Horizonte\"}";
        System.out.println("Pessoa JSON: " + pessoaJson);

        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(pessoaJson, Pessoa.class);
        System.out.println("Pessoa objeto: " + pessoa);
    }
}
