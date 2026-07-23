package br.com.devfred.aula5.desafiofinal.exception;

public class LogradouroInvalidoException extends RuntimeException {
    private String mensagem;

    public LogradouroInvalidoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }

}
