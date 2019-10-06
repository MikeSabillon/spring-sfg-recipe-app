package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.CategoryCommand;
import sabillon.springframework5.recipe.app.data.models.Category;

/**
 * The Class CategoryToCategoryCommandTest.
 */
public class CategoryToCategoryCommandTest {

	/** The Constant ID_VALUE. */
	public static final Long ID_VALUE = 1L;

	/** The Constant DESCRIPTION. */
	public static final String DESCRIPTION = "descript";

	/** The convter. */
	CategoryToCategoryCommand convter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		convter = new CategoryToCategoryCommand();
	}

	/**
	 * Test null object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testNullObject() throws Exception {
		assertNull(convter.convert(null));
	}

	/**
	 * Test empty object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(convter.convert(new Category()));
	}

	/**
	 * Convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convert() throws Exception {
		Category category = new Category();
		category.setId(ID_VALUE);
		category.setDescription(DESCRIPTION);

		CategoryCommand categoryCommand = convter.convert(category);

		assertEquals(ID_VALUE, categoryCommand.getId());
		assertEquals(DESCRIPTION, categoryCommand.getDescription());
	}

}
