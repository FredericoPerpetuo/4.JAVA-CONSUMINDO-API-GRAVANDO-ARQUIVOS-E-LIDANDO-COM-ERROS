package br.com.devfred.aula5.desafiofinal.exception;

public class CepInvalidoException extends RuntimeException {
    private String mensagem;

    public CepInvalidoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }

}
