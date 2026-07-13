package br.com.devfred.aula3.desafio2.exception;

public class SenhaInvalidaException extends RuntimeException{
    private String message;

    public SenhaInvalidaException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
