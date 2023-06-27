package br.crowpanion.api.crowpanion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.crowpanion.api.crowpanion.model.LocalizacaoModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {
    
    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    // Listar localizacoes
    public Iterable<LocalizacaoModel> listarLocais() {
        return localizacaoRepository.findAll();
    }

    // Cadastrar/Alterar localizacao
    public ResponseEntity<?> cadastrarAlterarLocalizacao(LocalizacaoModel LocalizacaoModel, String acao) {

        if(LocalizacaoModel.getNome().equals("")) {
            respostaModelo.setMessage("O nome do local é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
          if(acao.equals("cadastrar")) {
            return new ResponseEntity<LocalizacaoModel>(localizacaoRepository.save(LocalizacaoModel), HttpStatus.CREATED);
          } else {
            return new ResponseEntity<LocalizacaoModel>(localizacaoRepository.save(LocalizacaoModel), HttpStatus.OK);
          } 
        }
    }

    // Remover localizacao
    public ResponseEntity<RespostaModelo> removerLocalizacao(Long idLocalizacao) {
        localizacaoRepository.deleteById(idLocalizacao);
        respostaModelo.setMessage("Localização removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

}