package sabillon.springframework5.recipe.app.data.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class CategoryTest.
 */
public class CategoryTest {

	/** The category. */
	private Category category;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.category = new Category();
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetId() {
		Long id = 1L;
		this.category.setId(id);
		assertEquals(id, this.category.getId());
	}

	/**
	 * Test get description.
	 */
	@Test
	public void testGetDescription() {
		String someDesc = "someDesc";
		this.category.setDescription(someDesc);
		assertEquals(someDesc, this.category.getDescription());
	}

	/**
	 * Test get recipes.
	 */
	@Test
	public void testGetRecipes() {
		this.category.setRecipes(new HashSet<Recipe>());
		assertNotNull(this.category.getRecipes());
	}

}
