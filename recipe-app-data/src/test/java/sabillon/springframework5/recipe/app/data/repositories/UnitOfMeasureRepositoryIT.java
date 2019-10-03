package sabillon.springframework5.recipe.app.data.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

/**
 * The Class UnitOfMeasureRepositoryIT.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	/** The unit of measure repository. */
	@Autowired
	private UnitOfMeasureRepository unitOfMeasureRepository;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Find by description.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findByDescription() throws Exception {
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}

	/**
	 * Find by description cup.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findByDescriptionCup() throws Exception {
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		assertEquals("Cup", uomOptional.get().getDescription());
	}

}
