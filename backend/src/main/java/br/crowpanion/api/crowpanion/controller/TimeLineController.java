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
import br.crowpanion.api.crowpanion.model.TimeLineModel;
import br.crowpanion.api.crowpanion.service.TimeLineService;

@RestController
@RequestMapping("/timelines")
public class TimeLineController {

    @Autowired
    private TimeLineService timeLineService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody TimeLineModel timeLineModel) {
        return timeLineService.cadastrarAlterarTimeLine(timeLineModel, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarUsuario(@RequestBody TimeLineModel timeLineModel) {
        return timeLineService.cadastrarAlterarTimeLine(timeLineModel, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<TimeLineModel> listarUsuarios() {
        return timeLineService.listarTimeLines();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> removerUsuario(@PathVariable Long id) {
        return timeLineService.removerMundo(id);
    }

}
