package br.com.mentoria.servicos.exececoes;

public class TipoCampeaoException extends Exception{
    private String msg;

    public TipoCampeaoException(String msg){
        super(msg);
        this.msg = msg;
    }
}
