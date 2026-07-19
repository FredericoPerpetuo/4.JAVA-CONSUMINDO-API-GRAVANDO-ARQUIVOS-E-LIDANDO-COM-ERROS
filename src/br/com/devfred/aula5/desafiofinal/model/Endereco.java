package br.com.devfred.aula5.desafiofinal.model;

public record Endereco(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String ddd
) {}
