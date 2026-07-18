package br.com.devfred.aula5.desafiofinal.view;

import br.com.devfred.aula5.desafiofinal.service.BuscadorCepService;

import java.util.Scanner;

public class TerminalView {

    private final Scanner scanner;
    private final BuscadorCepService buscadorCepService;

    public TerminalView(Scanner scanner, BuscadorCepService buscadorCepService) {
        this.scanner = scanner;
        this.buscadorCepService = buscadorCepService;
    }

    public void iniciarLoop(){
        int opcao = 0;
        while(opcao != 3){
            exibirOpcoes();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            processarOpcao(opcao);
        }
    }

    private void exibirOpcoes(){
        String menu = """
                1) Buscar endereço por cep
                2) Buscar endereço por logradouro
                3) Sair
                """;
        System.out.print(menu);

    }

    private void processarOpcao(int opcao){
        switch(opcao){
            case 1:
                System.out.println("Escolheu opção 1\n");
                break;
            case 2:
                System.out.println("Escolheu opção 2\n");
                break;
            case 3:
                System.out.println("Obrigado por utilizar nosso sistema\n");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}
