package br.crowpanion.api.crowpanion.repository;

import org.springframework.data.repository.CrudRepository;

import br.crowpanion.api.crowpanion.model.ArtigoModel;

public interface ArtigoRepository extends CrudRepository<ArtigoModel, Long> {
    
}
