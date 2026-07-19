package br.com.devfred.aula5.desafiofinal.exception;

public class FalhaConfiguracaoException extends RuntimeException {
    private String mensagem;

    public FalhaConfiguracaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }

}
