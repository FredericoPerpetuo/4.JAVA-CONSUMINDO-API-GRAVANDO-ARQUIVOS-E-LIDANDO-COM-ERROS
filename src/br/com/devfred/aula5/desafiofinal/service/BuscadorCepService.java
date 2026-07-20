package br.com.devfred.aula5.desafiofinal.service;

import br.com.devfred.aula5.desafiofinal.integration.ViaCepClient;
import br.com.devfred.aula5.desafiofinal.integration.ViaCepDto;
import br.com.devfred.aula5.desafiofinal.model.Cep;
import br.com.devfred.aula5.desafiofinal.model.Endereco;
import br.com.devfred.aula5.desafiofinal.parser.ConversonJson;
import br.com.devfred.aula5.desafiofinal.repository.EscritorArquivoEndereco;

import java.io.IOException;

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

    private Endereco converteViaCepDtoParaEndereco(Cep objCep, ViaCepDto viaCepDto){
        return new Endereco(objCep.cep(), viaCepDto.logradouro(),
                viaCepDto.bairro(), viaCepDto.localidade(),
                viaCepDto.uf(), viaCepDto.estado(), viaCepDto.ddd());
    }


}
