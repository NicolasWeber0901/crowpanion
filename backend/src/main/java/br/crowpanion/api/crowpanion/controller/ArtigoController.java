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

import br.crowpanion.api.crowpanion.model.ArtigoModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.service.ArtigoService;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {
    
    @Autowired
    private ArtigoService artigoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody ArtigoModel artigoModel) {
        return artigoService.cadastrarAlterarArtigo(artigoModel, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarUsuario(@RequestBody ArtigoModel artigoModel) {
        return artigoService.cadastrarAlterarArtigo(artigoModel, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<ArtigoModel> listarUsuarios() {
        return artigoService.listarArtigos();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> removerUsuario(@PathVariable Long id) {
        return artigoService.removerArtigo(id);
    }

}
