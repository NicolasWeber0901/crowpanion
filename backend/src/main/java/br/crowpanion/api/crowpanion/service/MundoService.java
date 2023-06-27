package br.crowpanion.api.crowpanion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.crowpanion.api.crowpanion.model.MundoModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.repository.MundoRepository;

@Service
public class MundoService {
    
    @Autowired
    private MundoRepository mundoRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    // Listar mundos do usuario
    public Iterable<MundoModel> listarMundos() {
        return mundoRepository.findAll();
    }

    // Cadastrar/Alterar mundo
    public ResponseEntity<?> cadastrarAlterarMundo(MundoModel mundoModel, String acao) {

        if(mundoModel.getNome().equals("")) {
            respostaModelo.setMessage("O nome do mundo é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
          if(acao.equals("cadastrar")) {
            return new ResponseEntity<MundoModel>(mundoRepository.save(mundoModel), HttpStatus.CREATED);
          } else {
            return new ResponseEntity<MundoModel>(mundoRepository.save(mundoModel), HttpStatus.OK);
          } 
        }
    }

    // Remover mundo
    public ResponseEntity<RespostaModelo> removerMundo(Long idMundo) {
        mundoRepository.deleteById(idMundo);
        respostaModelo.setMessage("Mundo removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

}
