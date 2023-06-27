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

import br.crowpanion.api.crowpanion.model.LocalizacaoModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.service.LocalizacaoService;

@RestController
@RequestMapping("/locais")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody LocalizacaoModel localizacaoModel) {
        return localizacaoService.cadastrarAlterarLocalizacao(localizacaoModel, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarUsuario(@RequestBody LocalizacaoModel localizacaoModel) {
        return localizacaoService.cadastrarAlterarLocalizacao(localizacaoModel, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<LocalizacaoModel> listarUsuarios() {
        return localizacaoService.listarLocais();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> removerUsuario(@PathVariable Long id) {
        return localizacaoService.removerLocalizacao(id);
    }

}