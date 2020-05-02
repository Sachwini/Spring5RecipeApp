package sachwini.springframework.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import sachwini.springframework.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Optional<Category> findByDescription (String description);

}
