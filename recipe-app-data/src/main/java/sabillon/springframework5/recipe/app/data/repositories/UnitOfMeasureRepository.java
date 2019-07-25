package sabillon.springframework5.recipe.app.data.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

/**
 * The Interface UnitOfMeasureRepository.
 */
@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	/**
	 * Find by description.
	 *
	 * @param description the description
	 * @return the optional
	 */
	Optional<UnitOfMeasure> findByDescription(String description);
}
