package br.crowpanion.api.crowpanion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.crowpanion.api.crowpanion.model.LocalizacaoModel;

@Repository
public interface LocalizacaoRepository extends CrudRepository<LocalizacaoModel, Long> {

}
