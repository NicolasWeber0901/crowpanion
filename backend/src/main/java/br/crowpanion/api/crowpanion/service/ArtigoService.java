package br.crowpanion.api.crowpanion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.crowpanion.api.crowpanion.model.ArtigoModel;
import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.repository.ArtigoRepository;

@Service
public class ArtigoService {
    
    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    // Listar artigos
    public Iterable<ArtigoModel> listarArtigos() {
        return artigoRepository.findAll();
    }

    // Cadastrar/Alterar artigo
    public ResponseEntity<?> cadastrarAlterarArtigo(ArtigoModel artigoModel, String acao) {

        if(artigoModel.getConteudo().equals("")) {
            respostaModelo.setMessage("O conteúdo do artigo é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
          if(acao.equals("cadastrar")) {
            return new ResponseEntity<ArtigoModel>(artigoRepository.save(artigoModel), HttpStatus.CREATED);
          } else {
            return new ResponseEntity<ArtigoModel>(artigoRepository.save(artigoModel), HttpStatus.OK);
          } 
        }
    }

    // Remover artigo
    public ResponseEntity<RespostaModelo> removerArtigo(Long idMundo) {
        artigoRepository.deleteById(idMundo);
        respostaModelo.setMessage("Artigo removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

}
