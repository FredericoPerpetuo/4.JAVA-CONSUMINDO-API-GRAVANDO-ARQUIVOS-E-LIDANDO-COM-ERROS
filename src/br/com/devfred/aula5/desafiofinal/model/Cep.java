package br.com.devfred.aula5.desafiofinal.model;

import br.com.devfred.aula5.desafiofinal.exception.CepInvalidoException;

public record Cep(String cep) {
    public Cep{
        cep = cep.trim();
        cep = cep.replace("-", "");

        if (!cep.matches("^\\d{8}$")) {
            throw new CepInvalidoException("O cep deve conter apenas números e exatamente 8 dígitos.");
        }
    }
}
