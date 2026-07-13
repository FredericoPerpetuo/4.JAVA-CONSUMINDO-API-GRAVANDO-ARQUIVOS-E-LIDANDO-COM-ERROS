package br.com.devfred.aula3.desafio3.exception;

public class ErroConsultaGitHubException extends RuntimeException{
    private String message;

    public ErroConsultaGitHubException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
