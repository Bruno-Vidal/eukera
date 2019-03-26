package br.com.cristal.eureka.business.repository;

import br.com.cristal.eureka.business.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByDescricao(String descricao);
}
