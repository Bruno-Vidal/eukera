package br.com.cristal.eureka.business.service;

import br.com.cristal.eureka.business.model.Alternativa;
import br.com.cristal.eureka.business.model.Categoria;
import br.com.cristal.eureka.business.model.Questao;
import br.com.cristal.eureka.business.repository.CategoriaRepository;
import br.com.cristal.eureka.business.repository.QuestaoRepository;
import br.com.cristal.eureka.resource.request.QuestaoRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestaoService {

    private QuestaoRepository repository;
    private CategoriaService categoriaService;

    public QuestaoService(QuestaoRepository repository, CategoriaService categoriaService) {
        this.repository = repository;
        this.categoriaService = categoriaService;
    }

    public List<Questao> getQuestoes() {
        return repository.findAll();
    }

    public void criarQuestao(QuestaoRequest questao) {
        Questao novaQuestao = new Questao();
        Categoria categoria = categoriaService.buscarPorId(questao.getCategoriaId());
        novaQuestao.setCategoria(categoria);
        novaQuestao.setEnunciado(questao.getEnunciado());
        List<Alternativa> alternativas = questao.getAlternativas()
                                                        .stream()
                                                        .map((alternativa) ->
                                                             Alternativa.builder()
                                                                    .correta(Boolean.FALSE)
                                                                    .descricao(alternativa)
                                                                    .questao(novaQuestao)
                                                                    .build()
                                                        ).collect(Collectors.toList());
        novaQuestao.setAlternativas(alternativas);
        repository.save(novaQuestao);

    }
}
