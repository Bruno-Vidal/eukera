package br.com.cristal.eureka.business.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questoes")
@Data
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String enunciado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    Categoria categoria;

    @OneToMany(mappedBy = "questao",cascade = CascadeType.PERSIST)
    List<Alternativa> alternativas;
}
