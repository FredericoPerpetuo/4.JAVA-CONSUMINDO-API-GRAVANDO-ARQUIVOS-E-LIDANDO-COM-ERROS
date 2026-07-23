package br.com.devfred.aula5.desafiofinal.service;

import br.com.devfred.aula3.desafio3.entities.Repositorio;
import br.com.devfred.aula5.desafiofinal.integration.ViaCepClient;
import br.com.devfred.aula5.desafiofinal.integration.ViaCepDto;
import br.com.devfred.aula5.desafiofinal.model.Cep;
import br.com.devfred.aula5.desafiofinal.model.Endereco;
import br.com.devfred.aula5.desafiofinal.model.Logradouro;
import br.com.devfred.aula5.desafiofinal.parser.ConversonJson;
import br.com.devfred.aula5.desafiofinal.repository.EscritorArquivoEndereco;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BuscadorCepService {
    private ViaCepClient viaCepClient;
    private ConversonJson conversonJson;
    private EscritorArquivoEndereco escritorArquivoEndereco;

    public BuscadorCepService(ViaCepClient viaCepClient, ConversonJson conversonJson, EscritorArquivoEndereco escritorArquivoEndereco) {
        this.viaCepClient = viaCepClient;
        this.conversonJson = conversonJson;
        this.escritorArquivoEndereco = escritorArquivoEndereco;
    }

    public void buscaCep(String cep) throws IOException, InterruptedException {
        Cep objCep = new Cep(cep);
        String response = viaCepClient.buscarEnderecoPorCep(objCep.cep());
        ViaCepDto viaCepDto = conversonJson.converteJsonParaViaCepDto(response);
        Endereco endereco = converteViaCepDtoParaEndereco(objCep, viaCepDto);
        escritorArquivoEndereco.salvarEndereco(endereco);
    }

    public List<String> buscaLogradouro(String uf, String cidade, String rua) throws IOException, InterruptedException {
        Logradouro logradouro = new Logradouro(uf, cidade, rua);
        String response = viaCepClient.buscarEnderecoPorLogradouro(logradouro.uf(), logradouro.cidade(), logradouro.rua());
        List<ViaCepDto>listaViaCepDto = conversonJson.converterJsonParaListaViaCepDto(response);
        List<Endereco>enderecos = converterListaViaCepDtoParaListaEndereco(listaViaCepDto);

        if(enderecos.size() == 1){
            escritorArquivoEndereco.salvarEndereco(enderecos.getFirst());
        }

        List<String> enderecosFormatados = formatarListaEnderecos(enderecos);

        return enderecosFormatados;
    }

    private Endereco converteViaCepDtoParaEndereco(Cep objCep, ViaCepDto viaCepDto){
        return new Endereco(objCep.cep(), viaCepDto.logradouro(),
                viaCepDto.bairro(), viaCepDto.localidade(),
                viaCepDto.uf(), viaCepDto.estado(), viaCepDto.ddd());
    }

    private List<Endereco> converterListaViaCepDtoParaListaEndereco(List<ViaCepDto> listaViaCepDto){
        List<Endereco>enderecos = new ArrayList<>();
        for(ViaCepDto viaCepDto : listaViaCepDto){
            Cep objCep = new Cep(viaCepDto.cep());
            Endereco endereco = converteViaCepDtoParaEndereco(objCep, viaCepDto);
            enderecos.add(endereco);
        }
        return enderecos;
    }

    private List<String> formatarListaEnderecos(List<Endereco> enderecos){
        List<String> enderecosFormatados = new ArrayList<>();
        for(Endereco endereco : enderecos){
            enderecosFormatados.add(conversonJson.converteEnderecoParaJsonFormatado(endereco));
        }
        return enderecosFormatados;
    }


}
