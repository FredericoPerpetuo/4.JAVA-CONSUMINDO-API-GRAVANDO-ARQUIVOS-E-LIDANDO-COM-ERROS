package br.com.devfred.aula5.desafiofinal.repository;

import br.com.devfred.aula5.desafiofinal.model.Endereco;
import br.com.devfred.aula5.desafiofinal.parser.ConversonJson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class EscritorArquivoEndereco {

    private final ConversonJson conversonJson;

    public EscritorArquivoEndereco(ConversonJson conversonJson) {
        this.conversonJson = conversonJson;
    }

    public void salvarEndereco(Endereco endereco){
        Path diretorio = Path.of("enderecos_salvos");
        Path arquivo = diretorio.resolve("enderecos.json");
        try{
            Files.createDirectories(diretorio);
            String enderecoFormatado = conversonJson.converteEnderecoParaJsonFormatado(endereco);
            Files.writeString(arquivo, enderecoFormatado, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Endereco gravado com sucesso em: " + arquivo.toAbsolutePath());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
