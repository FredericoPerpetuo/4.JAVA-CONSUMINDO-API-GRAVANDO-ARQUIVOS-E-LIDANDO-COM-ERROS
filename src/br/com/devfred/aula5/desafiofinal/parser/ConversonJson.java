package br.com.devfred.aula5.desafiofinal.parser;

import br.com.devfred.aula5.desafiofinal.exception.CepNaoEncontradoException;
import br.com.devfred.aula5.desafiofinal.integration.ViaCepDto;
import br.com.devfred.aula5.desafiofinal.model.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ConversonJson {
    private final Gson gson;

    public ConversonJson(Gson gson) {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public ViaCepDto converteJsonParaViaCepDto(String json){
        ViaCepDto viaCepDto = gson.fromJson(json, ViaCepDto.class);
        if(viaCepDto.erro() == true){
            throw new CepNaoEncontradoException("O cep não foi encontrado ou não existe");
        }else{
            return viaCepDto;
        }

    }

    public List<ViaCepDto> converterJsonParaListaViaCepDto(String json){
        Type tipoLista = new TypeToken<List<ViaCepDto>>() {}.getType();
        List<ViaCepDto> listaCeps = gson.fromJson(json, tipoLista);
        return listaCeps;
    }

    public String converteEnderecoParaJsonFormatado(Endereco endereco){
        return gson.toJson(endereco);
    }
}
