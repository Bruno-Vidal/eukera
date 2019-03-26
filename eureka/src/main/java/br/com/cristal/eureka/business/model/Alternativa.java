package br.com.cristal.eureka.business.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "alternativas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alternativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String descricao;

    Boolean correta;

    @ManyToOne()
    @JoinColumn(name = "questao_id")
    Questao questao;
}
