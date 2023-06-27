package br.crowpanion.api.crowpanion.repository;

import org.springframework.data.repository.CrudRepository;

import br.crowpanion.api.crowpanion.model.TimeLineModel;

public interface TimeLineRepository extends CrudRepository<TimeLineModel, Long> {
    
}
