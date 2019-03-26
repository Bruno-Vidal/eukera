package br.com.cristal.eureka.resource.controller;

import br.com.cristal.eureka.business.service.QuestaoService;
import br.com.cristal.eureka.resource.mapper.QuestaoMapper;
import br.com.cristal.eureka.resource.request.QuestaoRequest;
import br.com.cristal.eureka.resource.response.QuestaoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    private QuestaoService service;
    private QuestaoMapper mapper;

    public QuestaoController(QuestaoService service, QuestaoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<QuestaoResponse> busacrQuestoes() {
        return mapper.converter(service.getQuestoes());
    }

    @PostMapping
    public ResponseEntity criarQuestao(@RequestBody QuestaoRequest questao) {
       service.criarQuestao(questao);
       return ResponseEntity.status(201).body(null);
    }
}
