package br.com.cristal.eureka.resource.mapper;

import br.com.cristal.eureka.business.model.Alternativa;
import br.com.cristal.eureka.business.model.Questao;
import br.com.cristal.eureka.resource.response.AlternativaResponse;
import br.com.cristal.eureka.resource.response.QuestaoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestaoMapper {

    public QuestaoResponse converter(Questao questao) {
        return QuestaoResponse.builder()
                .enunciado(questao.getEnunciado())
                .alternativas(converterToResponse(questao.getAlternativas()))
                .build();
    }

    public List<AlternativaResponse> converterToResponse(List<Alternativa> alternativas) {
        return alternativas.stream()
                .map(this::converter)
                .collect(Collectors.toList());
    }

    public AlternativaResponse converter(Alternativa alternativa) {
        return AlternativaResponse.builder()
                .descricao(alternativa.getDescricao())
                .build();
    }

    public List<QuestaoResponse> converter(List<Questao> questoes) {
        return  questoes.stream()
                .map(this::converter)
                .collect(Collectors.toList());
    }
}
