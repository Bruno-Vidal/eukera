package br.com.cristal.eureka.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoRequest {

    private String enunciado;

    @JsonProperty(value = "categoria_id")
    private Long categoriaId;

    private List<String> alternativas;
}
