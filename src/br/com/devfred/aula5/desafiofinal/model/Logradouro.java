package br.com.devfred.aula5.desafiofinal.model;


import br.com.devfred.aula5.desafiofinal.exception.LogradouroInvalidoException;

public record Logradouro(String uf, String cidade, String rua) {
    public Logradouro{
        uf = uf.trim().toUpperCase();
        cidade = cidade.trim();
        rua = rua.trim();

        if (!uf.matches("^[a-zA-Z]{2}$")) {
            throw new LogradouroInvalidoException("A sigla do estado é obrigatória e deve conter apenas duas letras");
        }
        if (cidade.isBlank() | !cidade.matches("^[a-zA-Z ]{3,}$")) {
            throw new LogradouroInvalidoException("O nome da cidade é obrigatório e deve ter no mínimo 3 caracteres");
        }
        if (rua.isBlank() | !rua.matches("^[a-zA-Z0-9 ]{3,}$")) {
            throw new LogradouroInvalidoException("O nome da rua é obrigatório e deve ter no mínimo 3 caracteres");
        }
    }
}
