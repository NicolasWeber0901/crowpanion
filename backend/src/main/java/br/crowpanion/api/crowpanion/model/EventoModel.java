package br.crowpanion.api.crowpanion.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "evento")
@Getter
@Setter
public class EventoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_evento;

    private String descricao;
    private String tipo;
    private String dataInicio;
    private String dataFim;
    private String impacto;


    @OneToMany
    @JoinColumn(name = "evento_id", referencedColumnName = "id_evento")
    private List<ArtigoModel> artigos; 
}
