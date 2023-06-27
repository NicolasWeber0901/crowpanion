package br.crowpanion.api.crowpanion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.crowpanion.api.crowpanion.model.EventoModel;

@Repository
public interface EventoRepository extends CrudRepository<EventoModel, Long> {

}
