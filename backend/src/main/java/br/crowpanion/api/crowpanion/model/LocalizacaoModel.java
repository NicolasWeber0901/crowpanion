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
@Table(name = "localizacao")
@Getter
@Setter
public class LocalizacaoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_localizacao;

    private String nome;

    @OneToMany
    @JoinColumn(name = "localizacao_id", referencedColumnName = "id_localizacao")
    private List<ArtigoModel> artigos; 
}
