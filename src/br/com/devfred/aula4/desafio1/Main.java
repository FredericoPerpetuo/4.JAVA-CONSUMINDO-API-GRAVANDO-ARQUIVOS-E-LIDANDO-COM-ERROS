package br.com.devfred.aula4.desafio1;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter("arquivo.txt");
            writer.write("Escrevendo em arquivos com Java!!!");
            writer.close();
        }catch (Exception  e){
            System.out.println(e.getMessage());
        }
    }
}
