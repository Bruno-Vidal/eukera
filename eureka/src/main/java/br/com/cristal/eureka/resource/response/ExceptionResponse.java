package br.com.cristal.eureka.resource.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.time.ZonedDateTime;


@Data
@Builder
public class ExceptionResponse {

    private Integer status;
    private String mensagem;
    private LocalTime timestamp;
}
