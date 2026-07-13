package br.com.devfred.aula3.desafio2;

import br.com.devfred.aula3.desafio2.entities.Usuario;
import br.com.devfred.aula3.desafio2.exception.SenhaInvalidaException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        try {
            Usuario usu = new Usuario(nome, senha);
        } catch (SenhaInvalidaException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }


    }
}
