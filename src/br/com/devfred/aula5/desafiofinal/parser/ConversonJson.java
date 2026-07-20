package br.com.devfred.aula5.desafiofinal.parser;

import br.com.devfred.aula5.desafiofinal.integration.ViaCepDto;
import br.com.devfred.aula5.desafiofinal.model.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversonJson {
    private final Gson gson;

    public ConversonJson(Gson gson) {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public ViaCepDto converteJsonParaViaCepDto(String json){
        return gson.fromJson(json, ViaCepDto.class);
    }

    public String converteEnderecoParaJsonFormatado(Endereco endereco){
        return gson.toJson(endereco);
    }
}
