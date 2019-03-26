package br.com.cristal.eureka.business.repository;

import br.com.cristal.eureka.business.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao,Long> {
}
