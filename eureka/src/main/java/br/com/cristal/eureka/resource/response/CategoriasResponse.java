package br.com.cristal.eureka.resource.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriasResponse {

    private Long id;

    private String descricao;
}
