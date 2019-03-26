package br.com.cristal.eureka.resource.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class QuestaoResponse {

    String enunciado;

    List<AlternativaResponse> alternativas;
}
