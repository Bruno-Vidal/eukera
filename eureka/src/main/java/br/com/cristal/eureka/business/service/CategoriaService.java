package br.com.cristal.eureka.business.service;

import br.com.cristal.eureka.business.exception.CategoriaExisteException;
import br.com.cristal.eureka.business.exception.CategoriaNaoEncontrada;
import br.com.cristal.eureka.business.model.Categoria;
import br.com.cristal.eureka.business.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> buscarCategorias() {
        return repository.findAll();
    }

    public Categoria criarCategoria(String descricao) {
        if(Optional
                .ofNullable(repository
                        .findByDescricao(descricao)).isPresent()){
            throw new CategoriaExisteException("Categoria já existe", 422);
        }
        return repository.save(Categoria.builder()
                                    .descricao(descricao)
                                    .build());
    }

    public Categoria alterar(Long id, Categoria categoria) {
        categoria.setId(id);
         return repository.save(categoria);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new CategoriaNaoEncontrada("A categoria com id: " + id + " não existe" , 404);
        });
    }
}
