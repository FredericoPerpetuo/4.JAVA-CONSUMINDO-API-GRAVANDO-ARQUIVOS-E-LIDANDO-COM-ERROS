package br.com.devfred.aula5.desafiofinal.app;

import br.com.devfred.aula5.desafiofinal.service.BuscadorCepService;
import br.com.devfred.aula5.desafiofinal.view.TerminalView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BuscadorCepService buscadorCepService = new BuscadorCepService();
        TerminalView terminalView = new TerminalView(sc, buscadorCepService);
        terminalView.iniciarLoop();
    }
}
