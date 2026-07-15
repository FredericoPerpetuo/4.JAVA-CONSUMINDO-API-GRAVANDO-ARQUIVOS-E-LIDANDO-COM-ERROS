package br.com.devfred.aula4.desafio2_3;

import br.com.devfred.aula4.desafio2_3.entities.Titulo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Titulo titulo = new Titulo("Matrix", "Lilly Wachowski / Lana Wachowski", 1999);

        System.out.println("SEM PRETTY PRINTING");
        Gson gson = new Gson();
        String jsonTitulo = gson.toJson(titulo);
        System.out.println(jsonTitulo);

        System.out.println("--------------------------------------------");

        System.out.println("COM SEM PRETTY PRINTING");
        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String jsonTituloPretty = gsonPretty.toJson(titulo);
        System.out.println(jsonTituloPretty);

    }
}
