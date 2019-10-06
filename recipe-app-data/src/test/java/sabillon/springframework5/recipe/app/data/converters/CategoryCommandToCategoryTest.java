package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.CategoryCommand;
import sabillon.springframework5.recipe.app.data.models.Category;

/**
 * The Class CategoryCommandToCategoryTest.
 */
public class CategoryCommandToCategoryTest {

	/** The Constant ID_VALUE. */
	public static final Long ID_VALUE = 1L;

	/** The Constant DESCRIPTION. */
	public static final String DESCRIPTION = "description";

	/** The conveter. */
	CategoryCommandToCategory conveter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		conveter = new CategoryCommandToCategory();
	}

	/**
	 * Test null object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testNullObject() throws Exception {
		assertNull(conveter.convert(null));
	}

	/**
	 * Test empty object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(conveter.convert(new CategoryCommand()));
	}

	/**
	 * Convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convert() throws Exception {
		CategoryCommand categoryCommand = new CategoryCommand();
		categoryCommand.setId(ID_VALUE);
		categoryCommand.setDescription(DESCRIPTION);

		Category category = conveter.convert(categoryCommand);

		assertEquals(ID_VALUE, category.getId());
		assertEquals(DESCRIPTION, category.getDescription());
	}

}
