package br.com.cristal.eureka.resource.controller;

import br.com.cristal.eureka.business.model.Categoria;
import br.com.cristal.eureka.business.service.CategoriaService;
import br.com.cristal.eureka.resource.mapper.CategoriaMapper;
import br.com.cristal.eureka.resource.response.CategoriasResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    private CategoriaService service;

    private CategoriaMapper mapper;

    public CategoriaController(CategoriaService service, CategoriaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CategoriasResponse> buscarCategorias() {
        return mapper.converter(service.buscarCategorias());
    }

    @PostMapping
    public ResponseEntity criarCategoria(@RequestBody Categoria descricao) throws Exception {
        service.criarCategoria(descricao.getDescricao());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriasResponse> alterarCategoria(@PathVariable(name = "id") Long id , @RequestBody Categoria categoria) {
        Categoria categoriaAlterada = service.alterar(id, categoria);
        return ResponseEntity.ok(mapper.converter(categoriaAlterada));
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable(name = "id") Long id) {
        service.deletar(id);
    }

}
