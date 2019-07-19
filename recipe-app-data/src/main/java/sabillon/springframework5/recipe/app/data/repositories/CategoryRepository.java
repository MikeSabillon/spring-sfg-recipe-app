package sabillon.springframework5.recipe.app.data.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sabillon.springframework5.recipe.app.data.domain.Category;

/**
 * The Interface CategoryRepository.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	/**
	 * Find by description.
	 *
	 * @param description the description
	 * @return the optional
	 */
	Optional<Category> findByDescription(String description);
}
