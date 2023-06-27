package br.crowpanion.api.crowpanion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.model.TimeLineModel;
import br.crowpanion.api.crowpanion.repository.TimeLineRepository;

@Service
public class TimeLineService {
    
    @Autowired
    private TimeLineRepository timeLineRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    // Listar timelines
    public Iterable<TimeLineModel> listarTimeLines() {
        return timeLineRepository.findAll();
    }

    // Cadastrar/Alterar timeline
    public ResponseEntity<?> cadastrarAlterarTimeLine(TimeLineModel timeLineModel, String acao) {

        if(timeLineModel.getNome().equals("")) {
            respostaModelo.setMessage("O nome da TimeLine é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
          if(acao.equals("cadastrar")) {
            return new ResponseEntity<TimeLineModel>(timeLineRepository.save(timeLineModel), HttpStatus.CREATED);
          } else {
            return new ResponseEntity<TimeLineModel>(timeLineRepository.save(timeLineModel), HttpStatus.OK);
          } 
        }
    }

    // Remover timeline
    public ResponseEntity<RespostaModelo> removerMundo(Long idTimeLine) {
        timeLineRepository.deleteById(idTimeLine);
        respostaModelo.setMessage("TimeLine removida com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

}
