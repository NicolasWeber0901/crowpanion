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
@Table(name = "usuario")
//Lombok gera get e set dos atributos
@Getter
@Setter
public class UsuarioModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String login;
    private String email;
    private String senha;

    @OneToMany
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    private List<MundoModel> mundos;

}
