package br.com.devfred.aula5.desafiofinal.app;

import br.com.devfred.aula5.desafiofinal.config.ConfigurationLoader;
import br.com.devfred.aula5.desafiofinal.integration.ViaCepClient;
import br.com.devfred.aula5.desafiofinal.parser.ConversonJson;
import br.com.devfred.aula5.desafiofinal.repository.EscritorArquivoEndereco;
import br.com.devfred.aula5.desafiofinal.service.BuscadorCepService;
import br.com.devfred.aula5.desafiofinal.view.TerminalView;
import com.google.gson.Gson;

import java.net.http.HttpClient;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConfigurationLoader configurationLoader = new ConfigurationLoader();

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(configurationLoader.getConnectTimeout())
                .build();
        ViaCepClient viaCepClient = new ViaCepClient(client, configurationLoader.getUrlBase(), configurationLoader.getReadTimeout());

        Gson gson = new Gson();
        ConversonJson conversonJson = new ConversonJson(gson);

        EscritorArquivoEndereco escritorArquivoEndereco = new EscritorArquivoEndereco();

        BuscadorCepService buscadorCepService = new BuscadorCepService();

        Scanner sc = new Scanner(System.in);
        TerminalView terminalView = new TerminalView(sc, buscadorCepService);
        terminalView.iniciarLoop();
    }
}
