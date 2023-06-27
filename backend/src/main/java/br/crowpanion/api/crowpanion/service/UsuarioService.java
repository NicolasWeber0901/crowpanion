package br.crowpanion.api.crowpanion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.crowpanion.api.crowpanion.model.RespostaModelo;
import br.crowpanion.api.crowpanion.model.UsuarioModel;
import br.crowpanion.api.crowpanion.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespostaModelo respostaModelo;


    //Listar Usuários
    public Iterable<UsuarioModel> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Cadastrar/Alterar usuario
    public ResponseEntity<?> cadastrarAlterarUsuario(UsuarioModel usuarioModel, String acao) {

        if(usuarioModel.getLogin().equals("")) {
            respostaModelo.setMessage("O nome de usuário é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (usuarioModel.getSenha().equals("")) {
            respostaModelo.setMessage("A senha é obrigatória");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
          if(acao.equals("cadastrar")) {
            return new ResponseEntity<UsuarioModel>(usuarioRepository.save(usuarioModel), HttpStatus.CREATED);
          } else {
            return new ResponseEntity<UsuarioModel>(usuarioRepository.save(usuarioModel), HttpStatus.OK);
          } 
        }

    }

    // Remover usuario
    public ResponseEntity<RespostaModelo> removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
        respostaModelo.setMessage("Usuário removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

}