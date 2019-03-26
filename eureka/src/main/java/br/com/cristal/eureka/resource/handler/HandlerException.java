package br.com.cristal.eureka.resource.handler;

import br.com.cristal.eureka.business.exception.BaseException;
import br.com.cristal.eureka.business.exception.CategoriaExisteException;
import br.com.cristal.eureka.resource.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;
import java.time.ZonedDateTime;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { BaseException.class })
    protected ResponseEntity<ExceptionResponse> handleConflict(BaseException ex, WebRequest request) {
        return ResponseEntity.status(ex.getStatus())
                .body(ExceptionResponse.builder()
                                            .mensagem(ex.getMessage())
                                            .status(ex.getStatus())
                                            .timestamp(LocalTime.now())
                                            .build());
    }
}
