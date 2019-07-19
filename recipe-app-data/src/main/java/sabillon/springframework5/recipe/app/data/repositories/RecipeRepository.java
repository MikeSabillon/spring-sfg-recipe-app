package sabillon.springframework5.recipe.app.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sabillon.springframework5.recipe.app.data.domain.Recipe;

/**
 * The Interface RecipeRepository.
 */
@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
