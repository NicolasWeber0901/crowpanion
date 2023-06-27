package br.crowpanion.api.crowpanion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.crowpanion.api.crowpanion.model.MundoModel;

@Repository
public interface MundoRepository extends CrudRepository<MundoModel, Long> {
    
}
