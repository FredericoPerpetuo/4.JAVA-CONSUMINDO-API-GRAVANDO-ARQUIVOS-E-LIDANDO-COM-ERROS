package br.com.devfred.aula3.desafio3.entities;

import java.util.List;

public class Usuario {
    private String nome;
    private List<Repositorio> repositorios;

    public Usuario(String nome, List<Repositorio> repositorios) {
        this.nome = nome;
        this.repositorios = repositorios;
    }
}
