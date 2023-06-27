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

import br.crowpanion.api.crowpanion.model.MundoModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.service.MundoService;

@RestController
@RequestMapping("/mundos")
public class MundoController {

    @Autowired
    private MundoService mundoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody MundoModel mundoModel) {
        return mundoService.cadastrarAlterarMundo(mundoModel, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarUsuario(@RequestBody MundoModel MundoModel) {
        return mundoService.cadastrarAlterarMundo(MundoModel, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<MundoModel> listarUsuarios() {
        return mundoService.listarMundos();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> removerUsuario(@PathVariable Long id) {
        return mundoService.removerMundo(id);
    }

}