package br.crowpanion.api.crowpanion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.crowpanion.api.crowpanion.model.PersonagemModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.service.PersonagemService;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {
    
    @Autowired
    private PersonagemService personagemService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody PersonagemModel personagemModel) {
        return personagemService.cadastrarAlterarPersonagem(personagemModel, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarUsuario(@RequestBody PersonagemModel personagemModel) {
        return personagemService.cadastrarAlterarPersonagem(personagemModel, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<PersonagemModel> listarUsuarios() {
        return personagemService.listarPersonagens();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> removerUsuario(@PathVariable Long id) {
        return personagemService.removerMundo(id);
    }

}
