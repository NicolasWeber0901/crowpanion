package br.crowpanion.api.crowpanion.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class RespostaModelo {
    
    //Serve para relatar erros na API caso aconteça
    private String message;

}
