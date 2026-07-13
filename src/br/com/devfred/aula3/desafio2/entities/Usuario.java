package br.com.devfred.aula3.desafio2.entities;

import br.com.devfred.aula3.desafio2.exception.SenhaInvalidaException;

public class Usuario {
    String nome;
    String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        if(senha.length() < 8){
            throw new SenhaInvalidaException("A senha deve ter pelo menos 8 caracteres");
        }
        this.senha = senha;
    }
}
