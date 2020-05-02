package sachwini.springframework.Repositories;

import org.springframework.data.repository.CrudRepository;

import sachwini.springframework.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
