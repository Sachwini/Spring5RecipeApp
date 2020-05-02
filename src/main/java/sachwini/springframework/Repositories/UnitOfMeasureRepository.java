package sachwini.springframework.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import sachwini.springframework.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	
	Optional<UnitOfMeasure> findByDescription(String description);

}
