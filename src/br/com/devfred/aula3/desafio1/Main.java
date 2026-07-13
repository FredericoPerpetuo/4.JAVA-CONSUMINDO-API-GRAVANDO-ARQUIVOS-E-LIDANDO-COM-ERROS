package br.com.devfred.aula3.desafio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dividendo: ");
        int dividendo = sc.nextInt();

        System.out.print("Divisor: ");
        int divisor = sc.nextInt();
        try {
            int resultado = dividendo / divisor;
        } catch (ArithmeticException e) {
            System.out.println("Não é possível fazer divisão por zero");
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
