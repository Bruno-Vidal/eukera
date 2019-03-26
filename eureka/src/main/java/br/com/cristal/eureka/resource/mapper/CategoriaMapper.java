package br.com.cristal.eureka.resource.mapper;

import br.com.cristal.eureka.business.model.Categoria;
import br.com.cristal.eureka.resource.response.CategoriasResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaMapper {


    public List<CategoriasResponse> converter(List<Categoria> categorias) {
        return categorias.stream().map(this::converter).collect(Collectors.toList());
    }

    public CategoriasResponse converter(Categoria categoria ) {
        return CategoriasResponse
                .builder()
                    .id(categoria.getId())
                    .descricao(categoria.getDescricao())
                .build();
    }
}
