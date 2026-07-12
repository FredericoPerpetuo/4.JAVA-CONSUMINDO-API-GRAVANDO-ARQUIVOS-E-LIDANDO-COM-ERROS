package br.com.devfred.aula2.desafio2;

import br.com.devfred.aula2.desafio2.entities.Pessoa;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        String pessoaJson = "{\"nome\":\"Fred\",\"idade\":45,\"cidade\":\"Belo Horizonte\"}";
       //Na nova versão da API o json mal-formado que quebrava anteriomente não quebra mais
        Gson gson = new Gson();
        //Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa = gson.fromJson(pessoaJson, Pessoa.class);
        System.out.println("Pessoa objeto: " + pessoa);
    }
}
