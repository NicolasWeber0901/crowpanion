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
@Table(name = "personagem")
@Getter
@Setter
public class PersonagemModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personagem;

    private String nome;
    private int classe;
    private int especie;
    private int status;
    

    @OneToMany
    @JoinColumn(name = "personagem_id", referencedColumnName = "id_personagem")
    private List<ArtigoModel> artigos; 
}
