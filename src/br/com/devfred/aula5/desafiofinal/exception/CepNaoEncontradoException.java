package br.com.devfred.aula5.desafiofinal.exception;

public class CepNaoEncontradoException extends RuntimeException{
    private String mensagem;

    public CepNaoEncontradoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
