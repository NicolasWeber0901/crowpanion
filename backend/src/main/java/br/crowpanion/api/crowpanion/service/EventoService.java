package br.crowpanion.api.crowpanion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.crowpanion.api.crowpanion.model.EventoModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.repository.EventoRepository;

@Service
public class EventoService {
    
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    // Listar evento
    public Iterable<EventoModel> listarEventos() {
        return eventoRepository.findAll();
    }

    // Cadastrar/Alterar evento
    public ResponseEntity<?> cadastrarAlterarEvento(EventoModel eventoModel, String acao) {

        if(eventoModel.getDescricao().equals("")) {
            respostaModelo.setMessage("A descrição do evento é obrigatória");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
          if(acao.equals("cadastrar")) {
            return new ResponseEntity<EventoModel>(eventoRepository.save(eventoModel), HttpStatus.CREATED);
          } else {
            return new ResponseEntity<EventoModel>(eventoRepository.save(eventoModel), HttpStatus.OK);
          } 
        }
    }

    // Remover evento
    public ResponseEntity<RespostaModelo> removerEvento(Long idLocalizacao) {
        eventoRepository.deleteById(idLocalizacao);
        respostaModelo.setMessage("Evento removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

}
