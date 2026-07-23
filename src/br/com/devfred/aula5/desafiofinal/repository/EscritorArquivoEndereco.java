package br.com.devfred.aula5.desafiofinal.repository;

import br.com.devfred.aula5.desafiofinal.model.Endereco;
import br.com.devfred.aula5.desafiofinal.parser.ConversonJson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class EscritorArquivoEndereco {

    private final ConversonJson conversonJson;
    private final String diretorioDeSaida;

    public EscritorArquivoEndereco(ConversonJson conversonJson, String diretorioDeSaida) {
        this.conversonJson = conversonJson;
        this.diretorioDeSaida = diretorioDeSaida;
    }

    public void salvarEndereco(Endereco endereco){
        Path diretorio = Path.of(System.getProperty("user.home"), diretorioDeSaida);
        Path arquivo = diretorio.resolve(endereco.cep() + ".json");
        try{
            Files.createDirectories(diretorio);
            String enderecoFormatado = conversonJson.converteEnderecoParaJsonFormatado(endereco);
            Files.writeString(arquivo, enderecoFormatado, StandardOpenOption.CREATE);
            System.out.println("Endereco gravado com sucesso em: " + arquivo.toRealPath());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
