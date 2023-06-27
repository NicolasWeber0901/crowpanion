package br.crowpanion.api.crowpanion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.crowpanion.api.crowpanion.model.PersonagemModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.repository.PersonagemRepository;

@Service
public class PersonagemService {
    
    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    // Listar personagens
    public Iterable<PersonagemModel> listarPersonagens() {
        return personagemRepository.findAll();
    }

    // Cadastrar/Alterar personagem
    public ResponseEntity<?> cadastrarAlterarPersonagem(PersonagemModel personagemModel, String acao) {

        if(personagemModel.getNome().equals("")) {
            respostaModelo.setMessage("O nome do personagem é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
          if(acao.equals("cadastrar")) {
            return new ResponseEntity<PersonagemModel>(personagemRepository.save(personagemModel), HttpStatus.CREATED);
          } else {
            return new ResponseEntity<PersonagemModel>(personagemRepository.save(personagemModel), HttpStatus.OK);
          } 
        }
    }

    // Remover mundo
    public ResponseEntity<RespostaModelo> removerMundo(Long idMundo) {
        personagemRepository.deleteById(idMundo);
        respostaModelo.setMessage("Mundo removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

}
