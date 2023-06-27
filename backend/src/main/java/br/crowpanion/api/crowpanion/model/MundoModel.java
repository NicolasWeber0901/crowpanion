package br.crowpanion.api.crowpanion.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mundo")
@Getter
@Setter
public class MundoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mundo;

    private String nome;
    private String descricao;

    @OneToMany
    @JoinColumn(name = "mundo_id", referencedColumnName = "id_mundo")
    private List<LocalizacaoModel> locais; 
    
    @OneToMany
    @JoinColumn(name = "mundo_id", referencedColumnName = "id_mundo")
    private List<PersonagemModel> personagens; 

    @OneToOne
    @JoinColumn(name = "timeline_id", referencedColumnName = "id_timeline")
    private TimeLineModel timeLine;
}
