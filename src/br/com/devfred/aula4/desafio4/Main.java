package br.com.devfred.aula4.desafio4;

import br.com.devfred.aula4.desafio4.entities.Veiculo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("HB20", "Hyundai", 2026);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String veiculoSerializadoParaJson = gson.toJson(veiculo);
        System.out.println(veiculoSerializadoParaJson);
    }
}
