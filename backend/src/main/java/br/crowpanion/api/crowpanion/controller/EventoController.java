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

import br.crowpanion.api.crowpanion.model.EventoModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    
    @Autowired
    private EventoService eventoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody EventoModel eventoModel) {
        return eventoService.cadastrarAlterarEvento(eventoModel, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarUsuario(@RequestBody EventoModel eventoModel) {
        return eventoService.cadastrarAlterarEvento(eventoModel, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<EventoModel> listarUsuarios() {
        return eventoService.listarEventos();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> removerUsuario(@PathVariable Long id) {
        return eventoService.removerEvento(id);
    }


}
