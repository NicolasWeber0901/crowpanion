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

import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.model.UsuarioModel;
import br.crowpanion.api.crowpanion.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return usuarioService.cadastrarAlterarUsuario(usuarioModel, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarUsuario(@RequestBody UsuarioModel usuarioModel) {
        return usuarioService.cadastrarAlterarUsuario(usuarioModel, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<UsuarioModel> listarUsuarios() {
        return usuarioService.listarTodos();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> removerUsuario(@PathVariable Long id) {
        return usuarioService.removerUsuario(id);
    }
}
