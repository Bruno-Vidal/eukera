package br.com.cristal.eureka.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class CategoriaExisteException extends BaseException {

    public CategoriaExisteException(String message, Integer status) {
        super(message,status);
    }
}
