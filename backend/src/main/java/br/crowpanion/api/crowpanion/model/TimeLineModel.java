package br.crowpanion.api.crowpanion.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name = "timeline")
@Getter
@Setter
public class TimeLineModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_timeline;

    private String nome;
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "mundo_id", referencedColumnName = "id_mundo")
    private MundoModel mundo;

    @OneToMany
    @JoinColumn(name = "timeline_id", referencedColumnName = "id_timeline")
    private List<EventoModel> eventos;
}
