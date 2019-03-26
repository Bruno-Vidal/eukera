package br.com.cristal.eureka.business.exception;

public class CategoriaNaoEncontrada extends BaseException {
    public CategoriaNaoEncontrada(String mensagem , Integer status) {
        super(mensagem,status);
    }
}
